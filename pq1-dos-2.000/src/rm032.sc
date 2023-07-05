;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
)

(instance rm032 of PQRoom
	(properties
		noun 1
		picture 32
		south -1
		west -1
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 135 319 189 0 189 0 0 319 0 319 130 168 185 132 185 109 171 114 168 102 159 92 161 69 161 19 130 3 134 3 187 173 187
					yourself:
				)
		)
		(super init:)
		(gLongSong2 number: 915 play: 85 loop: -1)
		(gLongSong number: 330 loop: -1 play: 1)
		(pigeon init:)
		(bvds init:)
		(aptBldg init:)
		(aptWin init:)
		(aptCurtains init:)
		(clothesLine init:)
		(roofTops init:)
		(beerMug init:)
		(dumpster init:)
		(graffiti init:)
		(bra init:)
		(clothes init:)
		(box init:)
		(garbage init:)
		(wires init:)
		(pantyhose init:)
		(budWin init:)
		(wilroof init:)
		(upWindow init:)
		(arrowSign init: setCycle: Fwd)
		(bikers init: approachVerbs: 2 setScript: makeout) ; Talk
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(switch gPrevRoomNum
			(33
				(wilDoor init: cel: 4 setCycle: Beg)
				(gEgo
					posn: 125 159
					setCycle: StopWalk -1
					setMotion: MoveTo 101 166
				)
				(HandsOn)
			)
			(else
				(gEgo posn: 224 173)
				(wilDoor init:)
				(self posn: 194 180 setScript: (ScriptID 896 1)) ; sWI
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(self newRoom: 30)
			)
			((gEgo inRect: 70 149 179 189)
				(if local3
					(= local3 0)
					(gLongSong number: 330 fade: 80 5 5 0)
					(gLongSong2 pause: 1)
				else
					(= local4 1)
				)
			)
			(local4
				(= local4 0)
				(gLongSong fade: 1 10 10 0)
				(gLongSong2 pause: 0)
			)
			(else
				(= local3 1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance makeout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(bikers setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(2
				(bikers setCycle: End self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance goInWillys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local4)
					(gLongSong number: 330 play: 5 fade: 70 12 15 0 loop: -1)
				)
				(gEgo setMotion: PolyPath 108 173 self)
			)
			(1
				(Face gEgo wilDoor)
				(= ticks 3)
			)
			(2
				(wilDoor setCycle: End self)
			)
			(3
				(gEgo setMotion: MoveTo 134 158 self)
			)
			(4
				(wilDoor setCycle: Beg self)
			)
			(5
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance bikers of Prop
	(properties
		x 93
		y 156
		noun 23
		approachX 80
		approachY 165
		view 251
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if local0
					(gMessager say: 23 2 2) ; "Pardon me, would you two care to break it up?"
				else
					(= local0 1)
					(gMessager say: 23 2 1) ; "Excuse me, you two."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance arrowSign of Prop
	(properties
		x 105
		y 98
		noun 2
		onMeCheck 1024
		view 252
		signal 4096
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance wilDoor of Prop
	(properties
		x 109
		y 154
		noun 9
		view 253
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: goInWillys)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pigeon of Feature
	(properties
		noun 24
		sightAngle 40
		onMeCheck 1024
	)
)

(instance bvds of Feature
	(properties
		noun 16
		sightAngle 40
		onMeCheck 4096
	)
)

(instance aptBldg of Feature
	(properties
		noun 7
		sightAngle 40
		onMeCheck 4
	)
)

(instance aptWin of Feature
	(properties
		noun 8
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local1
					(0
						(= local1 1)
						(gMessager say: 8 2 1) ; "Hello up there!"
					)
					(1
						(= local1 2)
						(gMessager say: 8 2 2) ; "You haven't done anything, Ma'am. I was just being friendly."
					)
					(2
						(gMessager say: 8 2 3) ; "There is no reply. The woman has gone inside."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aptCurtains of Feature
	(properties
		noun 22
		sightAngle 40
		onMeCheck 16
	)
)

(instance clothesLine of Feature
	(properties
		noun 14
		sightAngle 40
		onMeCheck 64
	)
)

(instance roofTops of Feature
	(properties
		noun 19
		sightAngle 40
		onMeCheck 8
	)
)

(instance dumpster of Feature
	(properties
		noun 11
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local2
					(0
						(= local2 1)
						(gMessager say: 11 2) ; "A thin, reedy voice says from the dumpster:"
					)
					(1
						(gMessager say: 11 2 4) ; "The voice doesn't answer. You decide to leave well enough alone."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance graffiti of Feature
	(properties
		noun 10
		sightAngle 40
		onMeCheck 128
	)
)

(instance bra of Feature
	(properties
		noun 15
		sightAngle 40
		onMeCheck 8192
	)
)

(instance clothes of Feature
	(properties
		noun 18
		sightAngle 40
		onMeCheck 16384
	)
)

(instance beerMug of Feature
	(properties
		noun 3
		sightAngle 40
		onMeCheck 2048
	)
)

(instance budWin of Feature
	(properties
		x 70
		y 94
		noun 5
		nsTop 78
		nsLeft 55
		nsBottom 110
		nsRight 86
		sightAngle 40
		onMeCheck 512
		approachX 70
		approachY 94
		approachDist 48
	)
)

(instance pantyhose of Feature
	(properties
		x 223
		y 172
		noun 17
		nsTop 158
		nsLeft 215
		nsBottom 187
		nsRight 232
		sightAngle 40
		onMeCheck 16384
		approachX 223
		approachY 172
		approachDist 19
	)
)

(instance wires of Feature
	(properties
		x 116
		y 97
		noun 20
		nsTop 66
		nsBottom 129
		nsRight 232
		sightAngle 40
		onMeCheck 64
		approachX 116
		approachY 97
		approachDist 89
	)
)

(instance garbage of Feature
	(properties
		x 42
		y 134
		noun 13
		nsTop 126
		nsBottom 143
		nsRight 85
		sightAngle 40
		onMeCheck 256
		approachX 42
		approachY 134
		approachDist 14
	)
)

(instance box of Feature
	(properties
		x 36
		y 116
		noun 12
		nsTop 104
		nsLeft 14
		nsBottom 128
		nsRight 59
		sightAngle 40
		onMeCheck 256
		approachX 36
		approachY 116
		approachDist 24
	)
)

(instance wilroof of Feature
	(properties
		x 168
		y 9
		noun 6
		nsLeft 113
		nsBottom 19
		nsRight 223
		sightAngle 40
		onMeCheck 8
		approachX 168
		approachY 9
	)
)

(instance upWindow of Feature
	(properties
		noun 4
		sightAngle 40
		onMeCheck 512
	)
)

