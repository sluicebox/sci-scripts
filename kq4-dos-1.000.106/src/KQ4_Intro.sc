;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Sound)
(use Game)

(public
	KQ4_Intro 0
	KQ4MUSIC 1
)

(instance KQ4MUSIC of Sound
	(properties
		number 104
		keep 1
	)
)

(instance KQ4_Intro of Rgn
	(properties
		name {KQ4 Intro}
	)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(super init:)
		((ScriptID 520 1) init:) ; KQ4MUSIC
	)
)

