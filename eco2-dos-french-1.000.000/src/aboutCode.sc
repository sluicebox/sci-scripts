;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	aboutCode 0
)

(local
	local0
	local1
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 30] [temp30 30])
		(= local0 (gTheCursor loop:))
		(= local1 (gTheCursor cel:))
		(gGame setCursor: 999)
		(Message msgGET 7 2 0 1 1 @temp0) ; "Lost Secret of the Rainforest  version %s"
		(Format @temp30 @temp0 gVersion)
		(Print font: gUserFont mode: 1 addTextF: @temp30 init:)
		(gMessager say: 2 0 0 0 0 7) ; "If you're enjoying LOST SECRET OF THE RAINFOREST, play the first game in the EcoQuest series: ECOQUEST: THE SEARCH FOR CETUS."
		(self dispose:)
	)

	(method (dispose)
		(gTheCursor loop: local0 cel: local1 init:)
		(DisposeScript 967)
		(DisposeScript 7)
	)
)

