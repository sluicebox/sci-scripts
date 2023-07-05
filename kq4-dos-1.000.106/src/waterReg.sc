;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use System)

(public
	waterReg 0
)

(local
	local0
	local1
)

(instance waterReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsVIEW 5)
		(Load rsVIEW 6)
		(Load rsVIEW 7)
		(Load rsVIEW 8)
		(gEgo viewer: water)
	)
)

(instance water of Script
	(properties)

	(method (doit)
		(if (!= (= local0 (gEgo onControl: 1)) local1)
			(= local1 local0)
			(if (!= global105 14)
				(gEgo setCycle: Walk)
				(switch local0
					(1
						(= global105 0)
						(gEgo view: 2)
					)
					(2048
						(= global105 1)
						(gEgo view: 5)
					)
					(512
						(= global105 2)
						(gEgo view: 6)
					)
					(8
						(gEgo view: 7)
						(= global105 3)
					)
					(2
						(gEgo view: 8)
						(= global105 4)
						(gEgo setCycle: Fwd)
					)
				)
			)
		)
	)
)

