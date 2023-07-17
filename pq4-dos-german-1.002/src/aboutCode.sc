;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use TransPlane)
(use Str)
(use Print)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (Str newWith: 40 {}))
		(Message msgGET 8 2 0 1 1 (temp0 data:)) ; "Police Quest Open Season  version %s"
		(Print
			font: 999
			fore: 13
			y: 15
			shadowText: 1
			plane: TransPlane
			addTextF: (temp0 data:) gVersion
			init:
		)
		(gMessager say: 2 0 0 0 0 8) ; "This entire work Copyright (c) 1993 Sierra On-Line, Inc. Contains technologies described in U.S patent applications including 598,174 and 658,297. All Rights Reserved."
		(Print font: 4 width: 0 shadowText: 0 plane: 0 modeless: 0)
		(temp0 dispose:)
		(DisposeScript 8)
	)
)

