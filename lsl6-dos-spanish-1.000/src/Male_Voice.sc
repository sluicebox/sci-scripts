;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1822)
(include sci.sh)
(use Main)
(use Talker)

(public
	Male_Voice 4
	Female_Voice 5
)

(instance Female_Voice of Narrator
	(properties
		name {Female Voice}
		showTitle 1
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(34 {Voz Femenina})
				(49 {Weibliche Stimme})
				(33 {Voic F\82minine})
				(else {Female Voice})
			)
		)
		(super init: &rest)
		(= font gUserFont)
	)
)

(instance Male_Voice of Narrator
	(properties
		name {Male Voice}
		showTitle 1
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(34 {Vox Masculina})
				(49 {M\84nnliche Stimme})
				(33 {Voix Masculine})
				(else {Male Voice})
			)
		)
		(super init: &rest)
		(= font gUserFont)
	)
)

