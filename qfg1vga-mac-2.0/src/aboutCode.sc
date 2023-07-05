;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 556)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	aboutCode 0
)

(local
	local0 = 1
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 50])
		(if (== local0 8)
			(Message msgGET 556 1 0 0 8 @temp0) ; "Version %s Copyright 1989, 1990, 1992, 1994 Sierra On-Line, Inc."
			(Print
				font: gUserFont
				mode: 1
				width: 180
				addTextF: @temp0 gVersion
				init: dummyCue
			)
			(Platform 0 4 2 -1)
		else
			(Platform 0 4 3 -1)
			(Print
				font: gUserFont
				mode: 1
				width: 260
				addText: 1 0 0 local0 0 0 556
				init: dummyCue
			)
		)
	)
)

(instance dummyCue of Script
	(properties)

	(method (cue)
		(if (<= (++ local0) 8)
			(aboutCode doit:)
		else
			(= local0 1)
		)
	)
)

