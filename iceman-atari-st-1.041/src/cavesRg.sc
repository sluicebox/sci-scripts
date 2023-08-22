;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 304)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Track)
(use SmoothLooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	cavesRg 0
)

(local
	local0 = 4
	local1 = 2
	[local2 37] = [0 0 0 0 0 0 0 264 0 0 61 0 63 65 64 243 54 0 67 363 166 68 53 0 0 360 359 162 0 0 0 57 56 55 53 54 0]
	[local39 48] = [46 7 44 9 26 13 -43 7 -38 8 -21 9 18 9 25 8 32 6 -14 8 -24 8 -32 7 21 -20 33 -17 44 -16 -19 -21 -31 -16 -41 -14 42 -19 34 -23 28 -24 -44 -19 -33 -26 -24 -23]
	local87
	local88
	[local89 6]
	local95
	local96
	local97
	local98 = 15
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (>= (= temp0 (+ (* 6 param1) param2)) 0)
		(return (mod [local2 temp0] 100))
	else
		(return 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(return (/ [local2 (+ (* 6 local0) local1)] 100))
)

(procedure (localproc_2 param1 param2)
	(return [local39 (localproc_4 param1 param2)])
)

(procedure (localproc_3 param1 param2)
	(return [local39 (+ (localproc_4 param1 param2) 1)])
)

(procedure (localproc_4 param1 param2)
	(return (+ (* param1 6) (& param2 $000e)))
)

(instance cavesRg of Rgn
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((< 0 global102)
				(-= global102 local97)
				(if (< 0 (/ global102 800))
					(air setCel: (- 10 (/ global102 800)))
				else
					(air hide:)
				)
			)
			((not (gEgo script:))
				(gEgo setScript: dyingEgo)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 59 60 63 64 65 66 67 68 62 43)) ; inCave1Rm, inCave2Rm, inCave3Rm, inCave4Rm, nwDeadEndRm, northDeadEndRm, inCave5Rm, caveExitRm, inCave6Rm, inCave7Rm
		(= initialized 0)
		(switch ((User alterEgo:) edgeHit:)
			(EDGE_TOP
				(-- local0)
			)
			(EDGE_BOTTOM
				(++ local0)
			)
			(EDGE_RIGHT
				(++ local1)
			)
			(EDGE_LEFT
				(-- local1)
			)
		)
		(if (== newRoomNumber 53) ; antiSubNetRm
			(gGame changeScore: local98)
		)
		(if (< 0 local98)
			(-- local98)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(if (== gPrevRoomNum 53) ; antiSubNetRm
			(= local0 3)
			(= local1 3)
			(= local98 0)
		)
		(gCurRoom
			north: (localproc_0 (- local0 1) local1)
			south: (localproc_0 (+ 1 local0) local1)
			east: (localproc_0 local0 (+ 1 local1))
			west: (localproc_0 local0 (- local1 1))
		)
		(air init: ignoreActors: 1 setPri: 15)
		(if (<= (/ global102 800) 0)
			(air hide:)
		)
		(gauge init: ignoreActors: 1 setPri: 15 addToPic:)
		(lightBeam init: setPri: 2 hide:)
		(bubbles init:)
		(if (not local96)
			(= local96 1)
			(gIceGlobalSound number: 56 priority: 1 loop: -1 play: egosBubbleScript)
		)
		(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(= local97 1)
			(gEgo view: 54 cycleSpeed: 2 setLoop: caveLooper)
			(caveLooper vNormal: 54 vChangeDir: 55)
		else
			(= local97 5)
			(gEgo view: 154 cycleSpeed: 2 setLoop: caveLooper)
			(caveLooper vNormal: 154 vChangeDir: 254)
		)
		(super init:)
		(HandsOn)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,cave,wall]')
				(Print 304 0) ; "You see the dark walls of the cave."
			)
			((and (gEgo has: 6) (Said 'turn<on/light')) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(= local87 1)
			)
			((and (gEgo has: 6) (Said 'turn<off/light')) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(= local87 0)
			)
			((and (gEgo has: 6) (Said 'press/lever,switch<left')) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(if local87
					(Print 304 1) ; "You turn the light off."
					(= local87 0)
				else
					(Print 304 2) ; "You find the switch for the headlight and turn it on."
					(= local87 1)
				)
			)
			((Said 'light/flare')
				(if (and (not local88) (gEgo has: 7)) ; Sub: Flare | Tunisia: Duct_Tape
					(if (not (-- global103))
						(gEgo put: 7) ; Sub: Flare | Tunisia: Duct_Tape
					)
					(gEgo setScript: lightFlare)
				else
					(Print 304 3) ; "You don't have one."
				)
			)
			((and (gEgo has: 6) (Said 'press/lever,switch<right')) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(Print 304 4) ; "To activate the propeller, use the directional keys."
			)
			((Said 'examine,look[<at]/gear,scuba,coat,wetsuit,equipment')
				(Print 304 5) ; "Typical scuba gear."
			)
		)
	)
)

(instance lightBeam of Act
	(properties
		view 64
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
		(gEgo ignoreActors:)
		(lightShine init: hide:)
	)
)

(instance lightShine of Act
	(properties
		view 63
	)

	(method (init)
		(super init:)
		(self
			setPri: 1
			ignoreActors:
			loop: (gEgo loop:)
			setMotion: Track lightBeam 0 0
		)
	)
)

(instance caveLooper of SmoothLooper
	(properties
		vNormal 54
		vChangeDir 55
	)

	(method (init)
		(super init: &rest)
		(self doit: gEgo (gEgo heading:) inProgress: 0)
	)

	(method (doit param1 param2)
		(super doit: param1 param2)
		(lightBeam setCycle: lightBeamCycler setMotion: lightMover)
		(lightShine setCycle: lightShineCycler)
	)
)

(instance lightBeamCycler of Cycle
	(properties)

	(method (doit)
		(if local87
			(lightBeam show:)
			(cond
				((== (gEgo view:) 55)
					(lightBeam
						view: 65
						setLoop: (gEgo loop:)
						setCel: (/ (gEgo cel:) 2)
					)
				)
				((== (gEgo view:) 54)
					(lightBeam view: 64 setLoop: (gEgo loop:))
				)
			)
		else
			(lightBeam hide:)
		)
	)
)

(instance lightShineCycler of Cycle
	(properties)

	(method (doit)
		(if local87
			(lightShine show:)
			(cond
				((== (gEgo view:) 55)
					(lightShine
						view: 63
						loop: (gEgo loop:)
						setCel: (/ (gEgo cel:) 2)
					)
				)
				((== (gEgo view:) 54)
					(lightShine view: 62 loop: (gEgo loop:))
				)
			)
		else
			(lightShine hide:)
		)
	)
)

(instance lightMover of Motion
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp2 (gEgo loop:))
		(= temp3 (gEgo cel:))
		(cond
			((== (gEgo view:) 55)
				(lightBeam
					x: (+ (gEgo x:) (localproc_2 temp2 temp3))
					y: (+ (gEgo y:) (localproc_3 temp2 temp3))
				)
			)
			((== (gEgo view:) 54)
				(switch temp2
					(3
						(= temp0 0)
						(= temp1 -24)
					)
					(0
						(= temp0 43)
						(= temp1 3)
					)
					(2
						(= temp0 0)
						(= temp1 8)
					)
					(1
						(= temp0 -44)
						(= temp1 3)
					)
				)
				(lightBeam setMotion: Track gEgo temp0 temp1)
			)
		)
	)
)

(instance lightFlare of Script
	(properties)

	(method (cue param1)
		(if (and (== param1 soundFlare) (== (soundFlare signal:) 10))
			(egosBubbleScript cue:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:) self
				)
			)
			(1
				(gEgo
					view: 155
					viewer: 0
					setLoop: 0
					cycleSpeed: 3
					setCycle: End self
				)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(gGame changeScore: 1)
					(lightShine setCycle: 0 setMotion: 0)
					(lightBeam setCycle: 0 setMotion: 0)
					(DV_3X
						init:
						view: 155
						setLoop: 8
						setCel: 1
						setPri: (gEgo priority:)
						posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
					)
				)
				(= local88 1)
				(Flare init: hide:)
			)
			(2
				(gEgo setLoop: 1 setCycle: End self)
			)
			(3
				(if (< (Random 0 19) 16)
					(soundFlare init: play: self)
					(Flare
						show:
						illegalBits: 0
						ignoreActors:
						view: 155
						setLoop: 2
						setPri: (gEgo priority:)
						posn: (- (gEgo x:) 22) (- (gEgo y:) 23)
						setScript: debrisFlow
						setCycle: End self
					)
				else
					(Print 304 6) ; "The flare is a dud!"
					(self changeState: 7)
				)
			)
			(4
				(gEgo setLoop: 4 cycleSpeed: 6 setCycle: End)
				(Flare setLoop: 3 setCycle: Fwd)
				(= cycles 20)
			)
			(5
				(gEgo setLoop: 4 cycleSpeed: 6 setCycle: Beg)
				(= cycles 150)
			)
			(6
				(= local88 0)
				(Flare setLoop: 2 setCel: 3 setCycle: Beg self)
				(soundFlare dispose:)
			)
			(7
				(= local88 0)
				(Flare view: 155 setLoop: 8 setCel: 0 hide:)
				(gEgo setLoop: 1 setCel: 2 setCycle: Beg)
				(lightShineCycler dispose:)
				(= cycles 30)
			)
			(8
				(gEgo
					setLoop: 0
					setCel: 3
					setMotion: MoveTo (+ (gEgo x:) 3) (gEgo y:)
					setCycle: Beg self
				)
				(Flare
					posn: (- (gEgo x:) 19) (+ (gEgo y:) 4)
					show:
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 18) 200
				)
			)
			(9
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(lightShine setCycle: lightShineCycler)
					(lightShine setMotion: Track lightBeam 0 0)
					(lightBeam setCycle: lightBeamCycler setMotion: lightMover)
					(DV_3X dispose:)
					(gEgo view: 54)
				else
					(gEgo view: 154)
				)
				(gEgo
					loop: 1
					setLoop: -1
					cel: 5
					setCycle: Walk
					cycleSpeed: 2
					heading: 270
					setLoop: caveLooper
				)
				(= cycles 30)
			)
			(10
				(gEgo illegalBits: -32768 setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance bubbles of Act
	(properties
		yStep 3
		view 54
		loop 4
	)

	(method (init)
		(self
			setCycle: Walk
			setLoop: 4
			ignoreActors:
			illegalBits: 0
			setScript: egosBubbleScript
		)
		(super init:)
		(self hide:)
	)
)

(instance egosBubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(bubbles
					x:
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 8)
							)
							(1
								(- (gEgo x:) 8)
							)
							(else
								(gEgo x:)
							)
						)
					y: (- (gEgo y:) 5)
					show:
					setPri: (gEgo priority:)
					setMotion: MoveTo (gEgo x:) 5 self
				)
			)
			(2
				(bubbles hide:)
				(= cycles 2)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance Flare of Act
	(properties)
)

(instance DV_3X of View
	(properties
		name {DV-3X}
	)
)

(instance debris of Act
	(properties
		view 155
		loop 5
	)
)

(instance debrisFlow of Script
	(properties)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			([local89 temp0] hide: forceUpd:)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			([local89 temp0] dispose:)
		)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (!= state 10) (not local88))
			(self changeState: 10)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((= [local89 temp0] (Clone debris))
						init:
						setLoop: (Random 5 7)
						ignoreActors:
						ignoreHorizon:
						illegalBits: 0
						hide:
					)
				)
				(= cycles 2)
			)
			(1
				([local89 local95]
					setCycle: Fwd
					posn: (Flare x:) (Flare y:)
					setPri:
						(if (gEgo priority:)
							(gEgo priority:)
						else
							0
						)
					show:
					setMotion:
						MoveTo
						(switch (localproc_1)
							(0 330)
							(1 -10)
							(else
								(+ (Random 0 50) (Flare x:) -25)
							)
						)
						(switch (localproc_1)
							(2 200)
							(3 -10)
							(else
								(+ (Random 0 50) (Flare y:) -25)
							)
						)
				)
				(= local95 (mod (++ local95) 4))
				(= cycles 6)
			)
			(2
				([local89 local95] setCycle: 0 hide:)
				(= cycles 6)
			)
			(3
				(self changeState: 1)
			)
			(10
				(= cycles 60)
			)
			(11
				(client dispose:)
			)
		)
	)
)

(instance gauge of Prop
	(properties
		y 11
		x 22
		z 1
		view 54
		loop 5
		priority 15
	)
)

(instance air of Prop
	(properties
		y 8
		x 5
		z 2
		view 54
		loop 6
		cel 9
	)
)

(instance soundFlare of Sound
	(properties
		number 57
		priority 2
	)
)

(instance soundDying of Sound
	(properties
		number 59
		priority 2
	)
)

(instance dyingEgo of Script
	(properties)

	(method (cue param1)
		(cond
			((and (< 0 argc) (== (param1 signal:) 20))
				(super cue: param1 &rest)
			)
			((== argc 0)
				(super cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:)
				)
				(gIceGlobalSound stop:)
				(soundDying init: play: self)
				(= seconds 4)
			)
			(1
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(lightShine setMotion: 0 setCycle: 0)
					(lightBeam setCycle: 0 setMotion: 0)
					(DV_3X
						init:
						view: 155
						setLoop: 8
						setCel: 1
						setPri: (gEgo priority:)
						ignoreActors:
						posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
					)
				)
				(gEgo
					view: 155
					viewer: 0
					setLoop: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(= seconds 1)
			)
			(3
				(gEgo
					view: 255
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(4
				(gEgo
					view: 255
					setLoop: 0
					setCel: 0
					cycleSpeed: 0
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(5
				(gEgo
					view: 255
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(6
				(gEgo
					view: 255
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: Fwd
				)
			)
			(7
				(gEgo
					view: 255
					setLoop: 1
					setCel: 0
					cycleSpeed: 3
					setCycle: End self
				)
				(= cycles 60)
			)
			(8
				(gEgo
					illegalBits: -32768
					moveSpeed: 1
					setCycle: 0
					setLoop: 1
					setCel: 4
					ignoreActors:
					looper: 0
					setMotion: MoveTo (gEgo x:) 0
				)
				(= cycles 40)
			)
			(9
				(EgoDead 951 0 0 304 7) ; "Your air is gone and you never were any good at holding your breath."
			)
		)
	)
)

