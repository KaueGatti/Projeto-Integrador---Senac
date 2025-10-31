const rootStyles = getComputedStyle(document.documentElement);

export const Colors = {
    orange: rootStyles.getPropertyValue('--orange').trim(),
    green: rootStyles.getPropertyValue('--green').trim(),
    red: rootStyles.getPropertyValue('--red').trim(),
    blue: rootStyles.getPropertyValue('--blue').trim(),
    gray: rootStyles.getPropertyValue('--gray').trim(),
    grayLight: rootStyles.getPropertyValue('--gray--light').trim(),
}