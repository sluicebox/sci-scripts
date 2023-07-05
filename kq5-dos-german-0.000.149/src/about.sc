;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 756)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	about 0
)

(instance about of Code
	(properties)

	(method (doit &tmp temp0 [temp1 255])
		(switch
			(= temp0
				(Print ; "King's Quest V"
					756
					0
					#font
					1
					#button
					{About KQV}
					1
					#button
					{Help}
					2
					#button
					{Cancel}
					0
					#button
					{German\nMessages}
					3
				)
			)
			(3
				(if (== (gGame printLang:) 49)
					(gGame printLang: 1)
				else
					(gGame printLang: 49)
				)
			)
			(1
				(Format @temp1 756 1 gVersion gVersion) ; "King's Quest V by Roberta Williams Version: %s (c) 1990 Sierra On-Line, Inc."
				(Print @temp1 #mode 1)
			)
			(2
				((ScriptID 753) doit:) ; help
			)
		)
	)
)

