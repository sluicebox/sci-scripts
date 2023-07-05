;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 100] temp100)
		(= temp100 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(Printf 809 0 gVersion) ; "You are playing "Conquests of the Longbow", version %s."
		(Print 809 1) ; ""Conquests of the Longbow" was designed by Christy Marx, who also designed the award winning "Conquests of Camelot" for Sierra On-Line. To order this and other fine Sierra games, call (800) 326-6654 within the United States, or (209) 683-4468 from outside the United States."
		(Print 809 2) ; ""Conquests of the Longbow" was battered into its perfectly running condition by crack quality assurance experts Dan Scott, Sharon Simmons, Sharon Smith, Dave Fleming, Max Deardoff, Robin Bradley, Mike Pickhinke, Gordon Owens, Keri Cooper, Rose Lewis..."
		(Print 809 3) ; "...Doug Wheeler, Joe Carper, Roger Pyle, Bill Davis Jr., Dave Clingman, Susan Simmons, D.J. Williams, Dave Artis, Gary Cox, and Diana Mulligan. Then when all those folks went home..."
		(Print 809 4) ; "...Mike Harian, Dan Woolard, John Ratcliffe, Victor Sadauskas, Joe Perry, Judy Crites, Mike Broscius, Matthew Genesi, Jason Hickingbottom, Brian Doig, and Bill Hilton found the bugs that go bump in the night."
		(Print 809 5) ; "The gorgeous background art and masterful animation was painstakingly rendered by Kenn Nishiuye, Jerry Moore, Ernie Chan, Eric Kasner, Deanna Yhalkee, Al Roughton, Frankie Powell, Arturo Sinclair, Diana Wilson, and Terry Falls."
		(Print 809 6) ; "Special consideration is deserved for the Cavalry programming of Carlos Escobar and Brian K. Hughes, lately of Larry fame."
		(Print 809 7) ; "Our authentic medievally synthesized score and sounds were composed and created by Mark Seibert, Aubrey Hodges, Chris Braymen, Ken Allen, and Orpheus Hanley."
		(Print 809 8) ; "The monumental programming effort was engineered by two Bobs (Fischbach and Mallory) and a Todd (Powers), a Yoko (Hayashi), a Vana (Baker), a Cindy (Goff), two Hoods (Mark and Robin), two Richards (King and Aronson), a Kris (Shankar), and no guys from Andromeda."
		(gSystemWindow eraseOnly: temp100)
	)
)

