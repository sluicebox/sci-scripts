;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm95 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(instance rm95 of Rm
	(properties
		noun 10
		picture 95
		style 8
		horizon 80
	)

	(method (dispose)
		(= gUseSortedFeatures local15)
		(= global425 0)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 465 195 95 4)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 163 278 133 278 113 291 113 283 93 279 85 224 85 224 104 83 104 84 88 65 88 64 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 51 0 51 86 42 87 18 103 25 103 23 114 43 116 60 112 135 112 110 165 163 168 162 158 178 158 161 118 171 113 245 113 260 130 292 189
					yourself:
				)
		)
		(super init:)
		(= local15 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(table init: setOnMeCheck: 26505)
		(ceiling init: setOnMeCheck: 26505)
		(floor1 init: setOnMeCheck: 26505)
		(floor2 init: setOnMeCheck: 26505)
		(floor3 init: setOnMeCheck: 26505)
		(floor1 init:)
		(floor2 init:)
		(floor3 init:)
		(SolvePuzzle 706 8)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(chairs init: setPri: 6 addToPic:)
		(rDoor init: stopUpd:)
		(lDoor init: ignoreActors: 1 stopUpd:)
		(theCandelabra init: stopUpd:)
		(drunk init: setPri: 12 addToPic:)
		(chandelier init: setPri: 5 stopUpd:)
		(rope init: setPri: 3)
		(flames init: setPri: 6 setCycle: Fwd)
		(chairBlockDoor init: stopUpd:)
		(brig1 init: stopUpd: hide:)
		(moe init:)
		(curly init:)
		(larry init:)
		(bDoor init: setPri: 1 stopUpd:)
		(fDoor setCel: 3 init: setPri: 14 stopUpd:)
		(gEgo posn: 305 230 init: setScript: egoEntersSouth)
		(|= global425 $0008)
		(gTheIconBar disable: 6)
		(self setScript: controllingScript)
	)
)

(instance chairs of View
	(properties
		x 169
		y 77
		sightAngle 360
		view 95
	)

	(method (init)
		(super init:)
	)
)

(instance drunk of View
	(properties
		x 202
		y 146
		noun 7
		sightAngle 360
		view 547
		loop 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not local7)
					(gEgo setScript: handOnDrunk)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rDoor of Prop
	(properties
		x 288
		y 85
		sightAngle 360
		view 95
		loop 1
	)
)

(instance bDoor of Prop
	(properties
		x 44
		y 83
		noun 1
		sightAngle 360
		view 95
		loop 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local14
						(gEgo setScript: openBDoor)
					)
					(
						(and
							(not local7)
							local1
							(!= (brig1 script:) brigandsSouth)
						)
						(gCurRoom setScript: 0)
						(gEgo setScript: exitTooSoon)
					)
					(local1
						(brig1 setScript: exitTooSoon)
					)
					(local7
						(HandsOff)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lDoor of Prop
	(properties
		x 14
		y 96
		sightAngle 360
		view 95
		loop 3
	)
)

(instance fDoor of Prop
	(properties
		x 272
		y 189
		noun 8
		sightAngle 360
		view 95
		loop 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not local1)
					(gEgo setScript: barFDoor)
				else
					(gMessager say: 8 4) ; "The front door is already barred."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theCandelabra of Prop
	(properties
		x 236
		y 86
		noun 3
		sightAngle 360
		view 95
		loop 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local2
						(gMessager say: 3 4 1 1 self) ; "The candelabra has already fallen."
					)
					(local7
						(HandsOff)
					)
					(else
						(gEgo setScript: pushCan)
						(if (and (not local0) (!= (brig1 script:) brigandsEast))
							(gCurRoom setScript: 0)
							(brig1 setScript: candTooSoon)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chandelier of Prop
	(properties
		x 135
		y 18
		noun 6
		sightAngle 360
		view 95
		loop 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local14
						(gMessager say: 6 4 0 1 self) ; "No time for that again (although it WAS fun). Just get the heck outta here."
					)
					(local7
						(gEgo setScript: egoSwings)
					)
					(else
						(gMessager say: 6 4 1 1 self) ; "The chandelier is out of your reach."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance flames of Prop
	(properties
		x 72
		y 16
		sightAngle 360
		view 95
		loop 6
		priority 2
		signal 16
	)
)

(instance rope of Prop
	(properties
		x 182
		y 15
		noun 11
		sightAngle 360
		view 195
		loop 7
		priority 7
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local14
						(gMessager say: 6 4 0 1 self) ; "No time for that again (although it WAS fun). Just get the heck outta here."
					)
					(local7
						(gEgo setScript: egoSwings)
					)
					(else
						(gMessager say: 11 4 0 1 self) ; "Leave the rope alone for now. It's serving a very important function by holding up the chandelier."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chairBlockDoor of Prop
	(properties
		x 308
		y 102
		sightAngle 360
		view 95
		loop 7
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local0
						(gMessager say: 5 4 0 1 self) ; "The door is already blocked."
					)
					((!= (brig1 script:) brigandsEast)
						(gEgo setScript: pushChair)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stars of Prop
	(properties
		sightAngle 360
		view 295
		loop 2
	)
)

(instance brig1 of Actor
	(properties
		noun 2
		view 465
	)
)

(instance brig2 of Actor
	(properties
		noun 2
		view 465
	)
)

(instance brig3 of Actor
	(properties
		noun 2
		view 465
	)
)

(instance curly of Actor
	(properties
		view 188
	)
)

(instance moe of Actor
	(properties
		view 187
	)
)

(instance larry of Actor
	(properties
		view 186
	)
)

(instance ceiling of Feature
	(properties
		x 165
		y 106
		z 99
		noun 4
		nsTop 1
		nsLeft 20
		nsBottom 14
		nsRight 311
		sightAngle 360
	)
)

(instance table of Feature
	(properties
		x 159
		y 102
		z 15
		noun 12
		nsTop 75
		nsLeft 96
		nsBottom 99
		nsRight 223
		sightAngle 360
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(local14
						(gMessager say: 6 4 0 self)
					)
					(local7 0)
					((not local7)
						(gEgo setScript: climb)
						(if (and (not local0) (!= (brig1 script:) brigandsEast))
							(gCurRoom setScript: 0)
							(brig1 setScript: candTooSoon)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance floor1 of Feature
	(properties
		x 55
		y 95
		noun 9
		sightAngle 360
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 33 88 84 88 83 99 69 110 27 109
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance floor2 of Feature
	(properties
		x 55
		y 95
		noun 9
		sightAngle 360
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 114 103 184 103 186 113 169 115 181 159 107 159 130 111 111 111
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance floor3 of Feature
	(properties
		x 55
		y 95
		noun 9
		sightAngle 360
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 228 95 279 94 293 112 271 113 288 129 263 130 243 109 227 109 226 101
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance stoogeSound of Sound
	(properties
		number 120
	)
)

(instance egoEntersSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 305 160 self)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance openBDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 60 86 self)
			)
			(2
				(NormalEgo)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance barFDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 295 175 self)
			)
			(1
				(fDoor setPri: 15 ignoreActors: 1 setCycle: Beg self)
			)
			(2
				(gMessager say: 10 0 2 1 self) ; "You close and bar the door."
				(fDoor addToPic:)
				(NormalEgo)
				(= local1 1)
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance finalEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lDoor setCycle: End self)
			)
			(1
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 55 90 self
				)
				(brig2
					init:
					setPri: 3
					ignoreActors: 1
					posn: 20 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(brig3
					init:
					setPri: 3
					ignoreActors: 1
					posn: 10 90
					setCycle: Walk
					setMotion: MoveTo 40 94
				)
			)
			(2
				(EgoDead 76 77) ; "You're hopelessly outnumbered. You should have left this room when you had a chance."
			)
		)
	)
)

(instance chairTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 240)
			)
			(1
				(if (< (gEgo x:) 100)
					(gEgo setMotion: PolyPath 100 100)
				)
				(= ticks 120)
			)
			(2
				(lDoor setCycle: End self)
			)
			(3
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 55 90 self
				)
				(brig2
					init:
					setPri: 3
					ignoreActors: 1
					posn: 20 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(brig3
					init:
					setPri: 3
					ignoreActors: 1
					posn: 10 90
					setCycle: Walk
					setMotion: MoveTo 40 94
				)
			)
			(4
				(EgoDead 35 36) ; "Hmm... Maybe letting the brigands see you block the door with the chair wasn't a good idea."
			)
		)
	)
)

(instance exitTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo script:) exitTooSoon)
					(gCurRoom setScript: 0)
					(gEgo setMotion: PolyPath 60 100)
					(brig1 setScript: 0)
				)
				(if local16
					(brig1 setMotion: MoveTo (brig1 x:) 240 self)
					(brig2 setMotion: MoveTo (brig2 x:) 240)
					(brig3 setMotion: MoveTo (brig2 x:) 240)
				else
					(self cue:)
				)
			)
			(1
				(lDoor setCycle: End self)
			)
			(2
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					setCycle: Walk
					setMotion: PolyPath 60 90 self
				)
				(brig2
					init:
					setPri: 3
					ignoreActors: 1
					posn: 20 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(brig3
					init:
					setPri: 3
					ignoreActors: 1
					posn: 10 90
					setCycle: Walk
					setMotion: MoveTo 40 90
				)
			)
			(3
				(EgoDead 66 67) ; "You need to guard your flanks before a frontal assault is possible."
			)
		)
	)
)

(instance candTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rDoor setPri: 4 setCel: 1 addToPic: dispose:)
				(= ticks 60)
			)
			(1
				(if (== (moe script:) 0)
					(gCurRoom setScript: 0)
					(larry
						init:
						view: 465
						loop: 1
						setPri: 5
						ignoreActors: 1
						setCycle: Walk
						posn: 300 90
						setMotion: MoveTo 295 90 self
					)
				else
					(self cue:)
				)
			)
			(2
				(EgoDead 25 26) ; "There are still too many brigands for you to fight in here. You need to find some way to block one of the doors."
			)
		)
	)
)

(instance climb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 237 102 self)
			)
			(1
				(= local8 1)
				(gEgo
					view: 195
					setLoop: 0
					setCel: 0
					setPri: 7
					illegalBits: 0
					posn: 220 80
					setCycle: CT 7 1 self
				)
			)
			(2
				(= local7 1)
				(if (== (brig1 script:) 0)
					(HandsOn)
					(gTheIconBar disable: 1 6)
				)
				(gEgo
					view: 4
					loop: 3
					setCel: 0
					posn: (- (gEgo x:) 11) (- (gEgo y:) 2)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoSwings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 195
					setLoop: 0
					setCel: 7
					posn: 220 80
					cycleSpeed: 3
					setCycle: End self
				)
				(rope setLoop: 3 setCel: 5 posn: 180 7)
			)
			(1
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 3 setPri: 12)
				(rope setLoop: 4 setCel: 0 cycleSpeed: 3 setPri: 11)
			)
			(2
				(gEgo setCycle: End)
				(rope setCycle: End self)
				(lDoor setCycle: End)
			)
			(3
				(gEgo posn: 52 91 setLoop: 2 cel: 0 setCycle: CT 2 1 self)
				(rope setLoop: 5 cel: 0 setCycle: End)
			)
			(4
				(lDoor setCycle: Beg)
				(= ticks 15)
			)
			(5
				(gEgo cel: 3)
				(= ticks 15)
			)
			(6
				(lDoor stopUpd:)
				(gEgo setCycle: End)
				(rope stopUpd: hide:)
				(HandsOn)
				(gTheIconBar disable: 6)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance pushChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 2)
				(EgoGait 0 0) ; walking
				(gEgo setMotion: PolyPath 278 106 self)
			)
			(1
				(gMessager say: 10 0 5 1 self) ; "You move the chair in front of the door."
				(rDoor addToPic:)
				(gEgo setPri: 7 setMotion: MoveTo 307 108 self)
			)
			(2
				(chairBlockDoor posn: 303 98)
				(gEgo setLoop: 3 setMotion: MoveTo 298 100 self)
			)
			(3
				(chairBlockDoor posn: 297 94)
				(gEgo setMotion: MoveTo 293 96 self)
			)
			(4
				(chairBlockDoor posn: 291 92)
				(gEgo setMotion: MoveTo 288 94 self)
			)
			(5
				(chairBlockDoor
					setPri: 5
					setCel: 1
					posn: 285 92
					ignoreActors: 0
					stopUpd:
				)
				(gEgo setLoop: -1 setMotion: MoveTo 270 103 self)
			)
			(6
				(chairBlockDoor addToPic:)
				(= local0 1)
				(NormalEgo)
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance pushCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo y:) 120)
					(gEgo setMotion: PolyPath 247 120 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setPri: 8 setMotion: PolyPath 247 95 self)
			)
			(2
				(gMessager say: 3 4 0 0 self) ; "You begin toppling the candelabra."
			)
			(3
				(gEgo setLoop: 1 setCel: 3)
				(= ticks 6)
			)
			(4
				(gEgo view: 547 setLoop: 1 setCel: 0 setPri: 6 posn: 246 91)
				(= ticks 6)
			)
			(5
				(gEgo setCel: 1 posn: 244 91)
				(= ticks 6)
			)
			(6
				(gEgo setCel: 2 posn: 242 91)
				(= ticks 6)
			)
			(7
				(gEgo setCel: 1 posn: 240 91)
				(theCandelabra setCel: 1)
				(= ticks 6)
			)
			(8
				(gEgo setCel: 0 posn: 238 91)
				(theCandelabra setCel: 2)
				(= ticks 6)
			)
			(9
				(gEgo view: 4 setLoop: 1 setCel: 0)
				(theCandelabra setCycle: End self)
			)
			(10
				(theCandelabra addToPic:)
				(NormalEgo)
				(= local2 1)
				(if (!= (gEgo script:) handOnDrunk)
					(HandsOn)
					(gTheIconBar disable: 6)
					(self dispose:)
				)
			)
		)
	)
)

(instance brigandsSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(2
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(3
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(4
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(5
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(6
				(if (< (gEgo y:) 133)
					(self changeState: 7)
				else
					(= ticks 90)
				)
			)
			(7
				(= local16 1)
				(brig1
					show:
					posn: 185 232
					setPri: 15
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 239 215 self
				)
			)
			(8
				(brig2
					init:
					posn: 350 200
					setPri: 15
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 300 200
				)
				(brig3
					init:
					posn: 295 244
					setPri: 15
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 295 208 self
				)
				(brig1 setMotion: MoveTo 286 200)
			)
			(9
				(brig1 loop: 3)
				(brig2 loop: 3)
				(= ticks 36)
			)
			(10
				(if local1
					(brig2 loop: 1)
					(brig1 loop: 0)
					(= ticks 120)
				else
					(brig1 setPri: 14 setMotion: MoveTo 304 165)
					(brig2 setPri: 14 setMotion: MoveTo 310 163)
					(brig3 setPri: 14 setMotion: MoveTo 307 161)
					(if (gEgo inRect: 50 108 230 124)
						(HandsOff)
						(gEgo loop: 0)
						(self changeState: 13)
					else
						(self changeState: 14)
					)
				)
			)
			(11
				(if local0
					(brig1 setMotion: MoveTo 260 250)
					(brig2 setMotion: MoveTo 304 250)
					(brig3 setMotion: MoveTo 240 250 self)
					(= local3 1)
				else
					(brig1 setMotion: MoveTo 340 204)
					(brig2 setMotion: MoveTo 340 204)
					(brig3 setMotion: MoveTo 307 250 self)
				)
			)
			(12
				(= local16 0)
				(brig1 stopUpd: hide:)
				(brig2 stopUpd: dispose:)
				(brig3 stopUpd: dispose:)
				(if local3
					(client setScript: chairTooSoon)
				else
					(= local3 1)
					(client setScript: 0)
				)
				(self dispose:)
			)
			(13
				(Face gEgo brig1)
				(brig1 setPri: 13 ignoreActors: 0 setMotion: MoveTo 280 165)
				(brig2 ignoreActors: 0 setMotion: MoveTo 310 150)
				(= ticks 120)
			)
			(14
				(EgoDead 27 28) ; "You'd better find a way to prevent the brigands from getting at you from all sides if you want to survive this."
			)
		)
	)
)

(instance brigandsEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rDoor setPri: 4 setCel: 1 addToPic: dispose:)
				(brig1
					show:
					loop: 1
					setPri: 5
					ignoreActors: 1
					setCycle: Walk
					posn: 330 90
					setMotion: MoveTo 295 90 self
				)
			)
			(1
				(if (< (gEgo distanceTo: brig1) 50)
					(self changeState: 5)
				else
					(brig1 setMotion: PolyPath 277 100 self)
				)
				(Face gEgo brig1)
			)
			(2
				(brig1 setMotion: PolyPath 270 113 self)
				(brig2
					setPri: 5
					loop: 1
					ignoreActors: 1
					setCycle: Walk
					posn: 330 90
					init:
					setMotion: MoveTo 295 90
				)
			)
			(3
				(if (< (gEgo distanceTo: brig1) 50)
					(self changeState: 5)
				else
					(brig2 setMotion: PolyPath 277 100 self)
				)
			)
			(4
				(if (gEgo inRect: 50 108 230 124)
					(gEgo loop: 0)
					(brig1 setPri: -1 setMotion: MoveTo 224 113)
					(brig2 setMotion: MoveTo 270 113 self)
				else
					(self changeState: 5)
				)
			)
			(5
				(EgoDead 25 26) ; "There are still too many brigands for you to fight in here. You need to find some way to block one of the doors."
			)
		)
	)
)

(instance brigandsWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (+ 60 (* 500 (- 3 gHowFast))))
			)
			(1
				(lDoor setCycle: End)
				(moe
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 80 90
				)
				(curly
					setPri: 3
					ignoreActors: 1
					posn: 20 90
					setCycle: Walk
					setMotion: MoveTo 71 90
				)
				(larry
					setPri: 3
					ignoreActors: 1
					posn: 10 90
					setCycle: Walk
					setMotion: MoveTo 63 90 self
				)
				(if (< (gEgo x:) 200)
					(HandsOff)
					(= register 1)
					(if (< (gEgo x:) 100)
						(gEgo setMotion: PolyPath 120 103)
					)
				)
			)
			(2
				(lDoor stopUpd:)
				(if local7
					(EgoDead 29 30) ; "You're hopelessly surrounded. You should have stopped those brigands somehow. Maybe you'll see the light."
				else
					(self cue:)
				)
			)
			(3
				(if (< (gEgo x:) 200)
					(HandsOff)
					(= register 1)
					(if (< (gEgo x:) 115)
						(gEgo setMotion: PolyPath 130 103)
					else
						(gEgo setMotion: 0 setCycle: 0)
					)
					(moe setMotion: MoveTo 110 100)
					(curly setMotion: MoveTo 100 90)
					(larry setMotion: MoveTo 90 90 self)
				else
					(moe setMotion: MoveTo 157 90)
					(curly setMotion: MoveTo 148 90)
					(larry setMotion: MoveTo 140 90 self)
				)
			)
			(4
				(if (< (gEgo x:) 200)
					(HandsOff)
					(= register 1)
					(if (< (gEgo x:) 115)
						(gEgo setMotion: PolyPath 130 103)
					else
						(gEgo setMotion: 0 setCycle: 0)
					)
					(curly setMotion: MoveTo 100 90)
					(larry setMotion: MoveTo 90 90 self)
				else
					(moe setMotion: MoveTo 194 90)
					(curly setMotion: MoveTo 185 90)
					(larry setMotion: MoveTo 177 90 self)
				)
			)
			(5
				(if register
					(EgoDead 29 30) ; "You're hopelessly surrounded. You should have stopped those brigands somehow. Maybe you'll see the light."
				else
					(self cue:)
				)
			)
			(6
				(lDoor setCel: 0)
				(if local2
					(client setScript: brigBlocked)
				else
					(EgoDead 29 30) ; "You're hopelessly surrounded. You should have stopped those brigands somehow. Maybe you'll see the light."
				)
			)
		)
	)
)

(instance brigBlocked of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (gEgo script:) 0)
				(not local8)
				(< (self state:) 8)
				(< (gEgo distanceTo: moe) 15)
			)
			(self changeState: 8)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stoogeSound play:)
				(= ticks 20)
			)
			(1
				(stoogeSound play:)
				(= ticks 20)
			)
			(2
				(stoogeSound play:)
				(= ticks 20)
			)
			(3
				(if local8
					(self changeState: 4)
				else
					(gMessager say: 10 0 3 1 self) ; "Oh, a wise guy, eh?"
					(moe setMotion: MoveTo 125 88 self)
					(curly setScript: curlyFollow)
					(larry setScript: larryFollow)
				)
			)
			(4
				(if local8
					(moe setMotion: MoveTo (gEgo x:) 88)
					(larry setMotion: MoveTo (gEgo x:) 88)
					(curly setMotion: MoveTo (gEgo x:) 88)
					(= ticks 60)
				else
					(moe setMotion: MoveTo 89 88 self)
				)
			)
			(5
				(if (and local8 (== (moe loop:) 0))
					(EgoDead 23 24) ; "Die drei Knochelkopfen grab you off the table. You should have waited until they were out of reach."
				else
					(moe setMotion: MoveTo 76 106 self)
				)
			)
			(6
				(moe setPri: 8 setMotion: MoveTo 130 115 self)
			)
			(7
				(moe setMotion: MoveTo 150 112 self)
			)
			(8
				(if local8
					(= local10 1)
					(self cue:)
				else
					(EgoDead 124 125) ; "You're hopelessly surrounded. You should have taken quicker action against these Knochelkopfs. Elevate your thoughts to a higher plane."
				)
			)
			(9
				(moe setMotion: MoveTo 170 110)
				(= local11 1)
			)
			(10
				(= ticks (* 5 (- 4 gHowFast)))
			)
			(11
				(moe view: 187 cel: 0 loop: 4 setCycle: End self)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance curlyFollow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* 30 (- 4 gHowFast)))
			)
			(1
				(curly setLoop: -1 setMotion: MoveTo 89 88 self)
			)
			(2
				(curly setMotion: MoveTo 76 116 self)
			)
			(3
				(curly setPri: -1 setMotion: MoveTo 100 115 self)
			)
			(4
				(curly setMotion: MoveTo 156 111)
				(= local12 1)
			)
			(5
				(= ticks (* 5 (- 4 gHowFast)))
			)
			(6
				(curly view: 188 cel: 0 loop: 4 setCycle: End self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance larryFollow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* 60 (- 4 gHowFast)))
			)
			(1
				(larry setMotion: MoveTo 82 88 self)
			)
			(2
				(larry setMotion: MoveTo 76 115 self)
			)
			(3
				(larry setPri: -1 setMotion: MoveTo 100 115 self)
			)
			(4
				(larry setMotion: MoveTo 142 109)
				(= local13 1)
			)
			(5
				(= ticks (* 5 (- 4 gHowFast)))
			)
			(6
				(larry view: 186 cel: 0 loop: 4 setCycle: End)
				(stars
					init:
					setPri: 10
					ignoreActors: 1
					posn: 156 69
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(7
				(moe cycleSpeed: 7 moveSpeed: 7 setCycle: Beg)
				(curly cycleSpeed: 7 moveSpeed: 7 setCycle: Beg)
				(larry cycleSpeed: 7 moveSpeed: 7 setCycle: Beg self)
			)
			(8
				(stars posn: 156 69)
				(moe cycleSpeed: 0 moveSpeed: 0 setLoop: 0 setCycle: Fwd)
				(curly cycleSpeed: 0 moveSpeed: 0 setLoop: 2 setCycle: Fwd)
				(larry cycleSpeed: 0 moveSpeed: 0 setLoop: 1 setCycle: Fwd)
				(= ticks 60)
			)
			(9
				(stars hide:)
				(HandsOn)
				(gTheIconBar disable: 6)
				(flames dispose:)
				(rope view: 295 show: loop: 4 posn: 157 14 cel: 0)
				(chandelier
					view: 295
					setLoop: 3
					setCel: 0
					setPri: 9
					posn: 135 18
				)
				(= ticks 5)
			)
			(10
				(rope posn: 156 24 cel: 1)
				(chandelier setCel: 1 posn: 134 28)
				(= ticks 5)
			)
			(11
				(rope posn: 155 33 cel: 2)
				(chandelier setCel: 2 posn: 133 37)
				(= ticks 5)
			)
			(12
				(rope posn: 155 43 cel: 2)
				(chandelier setCel: 2 posn: 133 47)
				(= ticks 5)
			)
			(13
				(larry view: 295 setLoop: 1 setCel: 0)
				(curly dispose:)
				(moe dispose:)
				(rope cel: 3 posn: 154 57)
				(chandelier dispose:)
				(= ticks 5)
			)
			(14
				(rope dispose:)
				(larry ignoreActors: 0 setCel: 1)
				(stars show: posn: 156 85 setCycle: Fwd)
				(= local14 1)
				(self dispose:)
			)
		)
	)
)

(instance candelabraTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (moe x:) 32)
					(lDoor setCycle: End)
					(moe
						setPri: 3
						posn: 31 90
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 65 90
					)
					(curly
						setPri: 3
						ignoreActors: 1
						posn: 20 90
						setCycle: Walk
						setMotion: MoveTo 56 90
					)
					(larry
						setPri: 3
						ignoreActors: 1
						posn: 10 90
						setCycle: Walk
						setMotion: MoveTo 46 90 self
					)
				else
					(= ticks 20)
				)
			)
			(1
				(lDoor stopUpd:)
				(stoogeSound play:)
				(= ticks 20)
			)
			(2
				(stoogeSound play:)
				(= ticks 20)
			)
			(3
				(stoogeSound play:)
				(= ticks 20)
			)
			(4
				(gMessager say: 10 0 3 1) ; "Oh, a wise guy, eh?"
				(moe setMotion: MoveTo 80 88 self)
			)
			(5
				(moe setMotion: PolyPath 75 115 self)
				(curly setScript: curlyFollow)
			)
			(6
				(moe setPri: -1 setMotion: PolyPath 100 115 self)
			)
			(7
				(EgoDead 33 34) ; "Whoops! Who'd have thought that guys that look that stupid could figure out to go around the table beFORE they ran all the way up to the fallen candelabra."
			)
		)
	)
)

(instance handOnDrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local13
					(self changeState: 4)
				else
					(gEgo setMotion: PolyPath 175 143 self)
				)
			)
			(1
				(gMessager say: 10 0 4 1 self) ; "There's no need to knock this guy out; the Troll's Sweat he's been drinking has already done the job for you."
				(self cue:)
			)
			(2
				(= ticks 30)
			)
			(3
				(cond
					((== (brig1 script:) brigandsEast)
						(self changeState: 6)
					)
					((== (moe script:) brigandsWest)
						(self changeState: 6)
					)
					((== (brig1 script:) brigandsSouth)
						(self changeState: 2)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(lDoor setCycle: End self)
			)
			(5
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 55 90 self
				)
				(brig2
					init:
					setPri: 3
					ignoreActors:
					posn: 20 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(brig3
					init:
					setPri: 3
					ignoreActors:
					posn: 10 90
					setCycle: Walk
					setMotion: MoveTo 40 94
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(EgoDead 58 59) ; "Yes, it was possible that this drunkard would somehow regain his senses, leap to his feet, realize that you didn't belong there, and do you in. On the other hand, you might have done a little better worrying about the wide-awake brigands closing in on you with their spears."
			)
		)
	)
)

(instance controllingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(= ticks 60)
			)
			(1
				(cond
					(local14
						(self changeState: 7)
					)
					((and local13 local11 local12)
						(self changeState: 6)
					)
					((or local13 local12 local11)
						(self changeState: 0)
					)
					(local5
						(self changeState: 5)
					)
					(local4
						(self changeState: 4)
					)
					(local3
						(self changeState: 3)
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(2
				(cond
					((== (brig1 script:) exitTooSoon)
						(rm95 setScript: 0)
					)
					((== (gEgo script:) exitTooSoon)
						(rm95 setScript: 0)
					)
					(
						(and
							(!= (brig1 script:) brigandsSouth)
							(or
								(> (gEgo x:) 180)
								(> (gEgo y:) 110)
								(>= register (+ 5 (* 3 (- 4 gHowFast))))
							)
						)
						(= register 1)
						(brig1 setScript: brigandsSouth)
						(self changeState: 0)
					)
					(
						(and
							(!= (brig1 script:) brigandsSouth)
							(!= (brig1 script:) exitTooSoon)
							(< (gEgo x:) 180)
							(< (gEgo y:) 110)
						)
						(brig1 setScript: exitTooSoon)
					)
					(else
						(self changeState: 0)
					)
				)
			)
			(3
				(if
					(and
						(>= register (+ 29 (* 12 (- 3 gHowFast))))
						(not local0)
						(!= (gEgo script:) handOnDrunk)
						(not
							(OneOf
								(brig1 script:)
								brigandsSouth
								brigandsEast
								exitTooSoon
							)
						)
					)
					(brig1 setScript: brigandsEast)
					(= local4 1)
				)
				(if
					(and
						local0
						(!= (brig1 script:) brigandsSouth)
						(!= (brig1 script:) brigandsEast)
					)
					(= local4 (= register 1))
				)
				(self changeState: 0)
			)
			(4
				(cond
					((== (brig1 script:) brigandsEast)
						(= register 1)
					)
					(
						(and
							(!= (brig1 script:) chairTooSoon)
							(!= (brig1 script:) exitTooSoon)
							(or
								local0
								(>= register (+ 13 (* 8 (- 3 gHowFast))))
							)
						)
						(moe setScript: brigandsWest)
						(= local5 1)
					)
				)
				(self changeState: 0)
			)
			(5
				(if
					(and
						local2
						(== (moe script:) brigandsWest)
						(< (moe x:) 125)
					)
					(if local7
						(EgoDead 23 24) ; "Die drei Knochelkopfen grab you off the table. You should have waited until they were out of reach."
						(client setScript: 0)
						(self dispose:)
					else
						(moe setScript: candelabraTooSoon)
					)
				)
				(self changeState: 0)
			)
			(6
				(if
					(and
						(== (gEgo script:) egoSwings)
						(== (egoSwings state:) 1)
					)
					(egoSwings changeState: 2)
					(brigBlocked cue:)
					(larryFollow cue:)
					(curlyFollow cue:)
					(= local13 0)
					(= local12 0)
					(= local11 0)
					(= register 1)
					(self changeState: 0)
				else
					(EgoDead 162 163) ; "Hey, man, like, when it's time to swing, it's time to SWING!"
				)
			)
			(7
				(if
					(and
						(>= register (+ 12 (* 5 (- 3 gHowFast))))
						(!= (gEgo script:) openBDoor)
						(!= (brig1 script:) finalEntry)
					)
					(brig1 setScript: finalEntry)
				)
				(self changeState: 0)
			)
		)
	)
)

