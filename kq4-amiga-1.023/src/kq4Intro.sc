;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Sound)
(use Game)

(public
	kq4Intro 0
	KQ4MUSIC 1
)

(instance KQ4MUSIC of Sound
	(properties
		number 104
		priority 15
	)
)

(instance kq4Intro of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(super init:)
		((ScriptID 520 1) owner: kq4Intro init:) ; KQ4MUSIC
	)
)

