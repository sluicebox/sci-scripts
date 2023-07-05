;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Game)
(use Actor)

(public
	rm039 0
)

(instance rm039 of Rm
	(properties
		picture 39
		style 0
		horizon 113
		south 13
		vanishingY 80
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(= global125 -1)
		(gEgo
			loop: 3
			x: (+ (/ (* (- (gEgo x:) 168) 53) 21) 135)
			y: 188
			init:
		)
		(proc0_10 275 171 164 250)
		(table init:)
		(if [global675 13]
			(teacher init:)
			(mary init:)
			(lamb init:)
			(kid1 init:)
			(kid2 init:)
		)
		(Load rsVIEW 36)
		(Load rsVIEW 126)
		(super init:)
		(= global207 1)
		(if (== global208 0)
			(gGlobalMGSound play:)
		)
	)
)

(instance teacher of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 setPri: 0 setLoop: 2 setCel: 0 posn: 161 85 stopUpd:)
	)
)

(instance mary of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 setLoop: 3 setCel: 2 posn: 256 171 setPri: 12 stopUpd:)
	)
)

(instance lamb of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 setLoop: 3 setCel: 3 posn: 226 164 stopUpd:)
	)
)

(instance kid1 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 setLoop: 3 setCel: 0 posn: 65 170 setPri: 12 stopUpd:)
	)
)

(instance kid2 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 setLoop: 3 setCel: 1 posn: 90 120 setPri: 8 stopUpd:)
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 275 188 setPri: 12 ignoreActors: 1 stopUpd:)
	)
)

