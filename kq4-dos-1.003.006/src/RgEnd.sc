;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 521)
(include sci.sh)
(use Sound)
(use Game)

(public
	RgEnd 0
	ENDMUSIC 1
)

(instance ENDMUSIC of Sound
	(properties)
)

(instance RgEnd of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(super init:)
		(ENDMUSIC number: 201 owner: 521 init:)
	)
)

