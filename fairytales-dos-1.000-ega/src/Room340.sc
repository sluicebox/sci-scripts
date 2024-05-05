;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	Room340 0
)

(local
	local0
	local1
	local2
	local3
	[local4 6] = [145 101 165 102 205 104]
)

(procedure (localproc_0)
	(house init:)
	(hedge init:)
	(impala init:)
	(giraffe init:)
	(tree init:)
	(wall init:)
	(spike init:)
	(statue init:)
	(mountain init:)
)

(instance Room340 of FRoom
	(properties
		lookStr {This must be the house of the Beast.}
		picture 340
		style 0
		north 290
		south 330
		northX 116
		northY 142
		southX 108
		southY 175
	)

	(method (init)
		(switch (gBeautyStory state:)
			(1
				(if (== gPrevRoomNum south)
					(Load rsSOUND 26)
				)
			)
			(4
				(if (== gPrevRoomNum south)
					(Load rsSOUND 27)
				)
				(= local0 ((gInventory at: 8) regActor:))
				(self defeatEntrance: 1)
			)
		)
		(super init:)
		(switch (gBeautyStory state:)
			(1
				(if (== gPrevRoomNum south)
					(if (gGame script:)
						(gGame setScript: 0)
						(gGlobalMusic2 stop:)
					)
					(gGlobalMusic number: 26 priority: 15 setLoop: -1 play:)
				)
			)
			(4
				(if (== gPrevRoomNum south)
					(if (gGame script:)
						(gGame setScript: 0)
						(gGlobalMusic2 stop:)
					)
					(gGlobalMusic number: 27 priority: 15 setLoop: -1 play:)
				)
			)
		)
		(gTheIconBar enable: show:)
		(= local3 (Random 10 20))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 44 173 0 173 0 -26 319 -26 319 172 103 172 165 139 125 139 99 127 89 121 98 139 114 138 130 143 115 152 102 155 60 168
					yourself:
				)
		)
		(localproc_0)
		(llama stopUpd: init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (<= (gEgo y:) 135)
			(self newRoom: 290)
		)
		(if (>= (gEgo y:) 180)
			(self newRoom: 330)
		)
		(cond
			((gCurRoom script:) 0)
			((not (gEgo has: 9)) 0)
			((<= 90 (gEgo heading:) 270)
				(= local1 (GetTime 1)) ; SysTime12
				(if (!= local2 local1)
					(= local1 local2)
					(if (not (-- local3))
						(gCurRoom setScript: showBeast)
						(= local3 (Random 50 100))
					)
				)
			)
		)
	)

	(method (cue)
		(super cue:)
	)

	(method (enterSpecial)
		(gCurRoom setScript: enterWithBeauty self)
	)

	(method (dispose)
		(if (and (== gNewRoomNum 330) (gGlobalMusic handle:))
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(super dispose: &rest)
	)
)

(instance showBeast of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (Random 0 2))
				(beast
					posn: [local4 (* temp0 2)] [local4 (+ (* temp0 2) 1)]
					cel: 2
					cycleSpeed: 9
					init:
					setCycle: Beg self
				)
			)
			(1
				(beast cel: 0 setCycle: End self)
			)
			(2
				(beast dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterWithBeauty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0
					setCycle: StopWalk
					normal: 0
					ignoreActors: 0
					posn: (gCurRoom southX:) (- (gCurRoom southY:) 5)
					init:
				)
				(NormalEgo 0 global139)
				(gEgo
					normal: 1
					setHeading: 0
					posn: (gCurRoom southX:) (gCurRoom southY:)
					init:
				)
				(= cycles 1)
			)
			(1
				(local0 setMotion: PolyPath 135 141 self)
				(gEgo setMotion: NPFollow local0 20)
			)
			(2
				(local0 setMotion: PolyPath 110 141 self)
			)
			(3
				(gCurRoom newRoom: 290)
				(self dispose:)
			)
		)
	)
)

(instance moveLlama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(llama setPri: 15 setCycle: End self)
			)
			(1
				(llama setCycle: CT 3 -1 self)
			)
			(2
				(llama setCycle: End self)
			)
			(3
				(llama setCel: 3 setCycle: Beg self)
			)
			(4
				(llama stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance llama of Prop
	(properties
		x 55
		y 90
		description {Llama}
		lookStr {Plants are growing in the shape of a llama.}
		view 340
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (llama script:))
					(llama setScript: moveLlama)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beast of Prop
	(properties
		description {Beast}
		lookStr {Uh oh,__that looks like a beast!}
		view 340
		loop 2
	)
)

(instance house of Feature
	(properties
		x 211
		y 80
		description {House}
		sightAngle 90
		onMeCheck 2
		lookStr {This huge house looks very old.}
	)
)

(instance hedge of Feature
	(properties
		x 120
		y 140
		description {Hedge}
		sightAngle 90
		onMeCheck 4
		lookStr {The path of the hedge leads away from the house.}
	)
)

(instance impala of Feature
	(properties
		x 256
		y 105
		description {Impala}
		sightAngle 90
		onMeCheck 16
		lookStr {This plant is shaped like an impala.}
	)
)

(instance giraffe of Feature
	(properties
		x 293
		y 80
		description {Giraffe}
		sightAngle 90
		onMeCheck 32
		lookStr {This plant is shaped like a giraffe.}
	)
)

(instance tree of Feature
	(properties
		x 80
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 64
		lookStr {The tree has green leaves.}
	)
)

(instance wall of Feature
	(properties
		x 278
		y 140
		description {Wall}
		sightAngle 90
		onMeCheck 128
		lookStr {This is the wall around the house.}
	)
)

(instance spike of Feature
	(properties
		x 168
		y 140
		description {Spike}
		sightAngle 90
		onMeCheck 256
		lookStr {This spike is on top of the wall to keep things off the wall.}
	)
)

(instance statue of Feature
	(properties
		x 71
		y 108
		description {Statue}
		sightAngle 90
		onMeCheck 512
		lookStr {You see some sort of statue from here.}
	)
)

(instance mountain of Feature
	(properties
		x 80
		y 70
		description {Mountain}
		sightAngle 90
		onMeCheck 1024
		lookStr {The mountain is dark.}
	)
)

