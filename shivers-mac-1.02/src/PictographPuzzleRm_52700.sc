;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52700)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(public
	PictographPuzzleRm 0
)

(local
	[local0 4] = [13 39 65 91]
	[local4 3] = [10 32 53]
	local7
	local8
	[local9 12]
	local21
	local22
	[local23 12]
	[local35 12]
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(if
			(or
				(!= ([local9 temp0] loop:) (+ temp0 1))
				(!= ([local9 temp0] cel:) 0)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(= temp0 (param1 loop:))
	(= temp1 (param1 cel:))
	(param1 loop: (param2 loop:) cel: (param2 cel:))
	(param2 loop: temp0 cel: temp1)
)

(instance PictographPuzzleRm of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= local21 0)
		(PictographBoard init:)
		(= temp4 0)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= [local23 temp0] (+ temp0 1))
			(= [local35 temp0] (Random 0 3))
			(+= temp4 [local35 temp0])
		)
		(if (!= temp4 (* (/ temp4 2) 2))
			(= [local35 temp3] (mod (+ [local35 (= temp3 (Random 0 11))] 1) 4))
		)
		(= temp3 (+ 6 (Random 0 12)))
		(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
			(= temp1 (Random 0 11))
			(= temp2 (Random 0 11))
			(= temp5 [local23 temp1])
			(= [local23 temp1] [local23 temp2])
			(= [local23 temp2] temp5)
		)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= temp6 (PictoTile new:))
			(temp6
				init:
					(+ 90 [local0 (mod temp0 4)])
					(+ 53 [local4 (/ temp0 4)])
					[local23 temp0]
					[local35 temp0]
			)
			(= [local9 temp0] temp6)
		)
		(RotateButton init:)
		(super init: &rest)
	)
)

(instance PictographBoard of View
	(properties
		x 90
		y 53
		priority 1
		fixPriority 1
		view 52700
	)
)

(instance RotateButton of ShiversProp
	(properties
		x 50
		y 50
		priority 1
		fixPriority 1
		view 52700
		loop 13
	)

	(method (doVerb)
		(if (!= cel 0)
			(= cel 1)
		)
		(if (and (!= local7 0) (!= local8 0))
			(self setCycle: End)
			(local7 cel: (mod (+ (local7 cel:) 1) 4))
			(local8 cel: (mod (+ (local8 cel:) 1) 4))
		)
	)
)

(instance PictoTile of ShiversProp
	(properties
		priority 2
		fixPriority 1
		view 52700
	)

	(method (init param1 param2 param3 param4)
		(= x param1)
		(= y param2)
		(= loop param3)
		(= cel param4)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(cond
				((and (== local7 0) (== local8 0))
					(= local7 self)
					(++ x)
					(-- y)
					(event claimed: 1)
					(gSounds play: 800 0 122 0)
				)
				((and (!= local7 0) (== local8 0) (== local7 self))
					(= local7 0)
					(-- x)
					(++ y)
					(event claimed: 1)
					(gSounds play: 800 0 122 0)
				)
				((and (!= local7 0) (== local8 0) (!= local7 self))
					(= local8 self)
					(++ x)
					(-- y)
					(localproc_1 local7 local8)
					(= local22 1)
					(RotateButton cel: 1)
					(event claimed: 1)
					(gSounds play: 800 0 122 0)
				)
				((== local22 1)
					(= local22 0)
					(local7 x: (- (local7 x:) 1) y: (+ (local7 y:) 1))
					(local8 x: (- (local8 x:) 1) y: (+ (local8 y:) 1))
					(= local7 0)
					(= local8 0)
					(RotateButton cel: 0)
					(event claimed: 1)
					(gSounds play: 800 0 122 0)
				)
			)
		)
	)
)

