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
		(super init: &rest)
		(= font gUserFont)
	)
)

