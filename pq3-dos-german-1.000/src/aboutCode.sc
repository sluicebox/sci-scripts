;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 878)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 100])
		(Format @temp0 878 0 gVersion gVersion) ; "Police Quest III The Kindred Version %s"
		(if
			(Print
				@temp0
				#button
				{Cancel}
				0
				#button
				{German Messages}
				1
				#mode
				1
				#width
				135
			)
			(if (== (gGame printLang:) 49)
				(gGame parseLang: 1 printLang: 1)
			else
				(gGame parseLang: 49 printLang: 49)
			)
		)
		(DisposeScript 878)
		(return 1)
	)
)

