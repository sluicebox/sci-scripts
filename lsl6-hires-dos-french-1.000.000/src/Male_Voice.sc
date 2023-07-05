;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1822)
(include sci.sh)
(use Main)
(use LarryTalker)

(public
	Male_Voice 4
	Female_Voice 5
)

(instance Female_Voice of LarryTalker
	(properties
		name {Female Voice}
		showTitle 1
		showFrame 0
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {Weibliche Stimme})
				(33 {Voic F\82minine})
				(else {Female Voice})
			)
		)
		(super init: &rest)
	)
)

(instance Male_Voice of LarryTalker
	(properties
		name {Male Voice}
		showTitle 1
		showFrame 0
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {M\84nnliche Stimme})
				(33 {Voix Masculine})
				(else {Male Voice})
			)
		)
		(super init: &rest)
	)
)

