;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use n098)
(use Print)
(use Polygon)
(use Feature)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm800 0
)

(local
	local0
	local1
	local2
)

(instance rm800 of LarryRoom
	(properties
		noun 1
		picture 800
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 136 89 137 91 189 91 213 93 261 91 261 89 224 89 215 91 214 90 218 86 213 86 207 91 201 86 176 84 210 62 205 61 169 85 200 87 200 89 183 89 170 89
					yourself:
				)
		)
		(if (<= gPrevRoomNum 140)
			(= local1 1)
			(= noControls 1)
		)
		(super init: &rest)
		(gEgo normalize: 801 setStep: 1 1 init:)
		(self
			setScript:
				(if local1
					startOfGameScr
				else
					(switch gPrevRoomNum
						(810 fromCliffsScr)
						(820 fromWoodsScr)
						(850
							(if (IsFlag 2) eatMissleScr else fromStationScr)
						)
						(else fromLobbyScr)
					)
				)
		)
		(if (not local1)
			(if (>= (gGame detailLevel:) 2)
				(butterFly init: setScript: butterFlyScr)
				(peeker init: hide: setScript: peekScr)
			)
		else
			(gMouseDownHandler add: self)
			(gKeyDownHandler add: self)
			(gGame setCursor: gWaitCursor)
		)
		(doorFtr init: approachVerbs: 4 3) ; Do, Walk
		(guardGate init:)
		(if (not local1)
			(guardGate setPri: 100)
		)
		(guardHouse init:)
		(hotel init:)
		(sky init:)
		(foliage init:)
		(water setCycle: Fwd init:)
		(palms init:)
		(birds play:)
		(ocean play:)
		(if (not (== (gCurRoom script:) eatMissleScr))
			(Load rsVIEW 802)
			(Lock rsVIEW 802 1)
			(proc79_11 1003)
			(= local0 1)
			(birdTimer setReal: birdTimer (Random 5 12))
		)
	)

	(method (handleEvent event)
		(if
			(and
				local1
				(not (event claimed:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (== (event message:) KEY_RETURN) (& (event type:) evKEYBOARD))
				)
			)
			(proc98_0)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((< (gEgo x:) 138)
				(gCurRoom setScript: haltScr)
			)
			((gEgo inRect: 165 80 178 86)
				(gCurRoom setScript: toCliffScr)
			)
			((gEgo inRect: 257 80 264 95)
				(gCurRoom newRoom: 820)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(ocean number: 0 dispose:)
		(birds number: 0 dispose:)
		(sfx number: 0 dispose:)
		(Lock rsVIEW 802 0)
		(UnLoad 128 802)
		(if local0
			(proc79_12 1003)
		)
		(birdTimer dispose: delete:)
		(cawTimer dispose: delete:)
		(if local1
			(gMouseDownHandler delete: self)
			(gKeyDownHandler delete: self)
		)
		(DisposeScript 64964)
		(gGlobalSound1 fade: 0 10 10 0)
		(super dispose:)
	)
)

(instance haltScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 3 1 0 self) ; "Halt! Who goes there?"
			)
			(1
				(gEgo posn: 138 (gEgo y:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromStationScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 125 88)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 138 89 self)
			)
			(2
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance peekScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 45))
			)
			(1
				(client show: setCycle: End self)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance butterFlyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 1 3))
				(= cycles 2)
			)
			(1
				(if (Random 0 1)
					(butterFly setCycle: End self)
				else
					(butterFly setCycle: Beg self)
				)
				(if (-- register)
					(-- state)
				)
			)
			(2
				(= state -1)
				(= ticks (Random 60 300))
			)
		)
	)
)

(instance peeker of Prop
	(properties
		x 169
		y 122
		priority 199
		fixPriority 1
		view 802
		loop 4
		signal 26665
	)
)

(instance butterFly of Prop
	(properties
		x 237
		y 113
		priority 199
		fixPriority 1
		view 802
		loop 2
		cel 5
	)
)

(instance water of Prop
	(properties
		noun 7
		x 315
		y 83
		view 800
		cel 3
		cycleSpeed 25
		detailLevel 3
	)
)

(instance missle of Prop
	(properties
		x 26
		y 111
		priority 199
		fixPriority 1
		view 804
	)
)

(instance skidScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 6 1 self)
			)
			(1
				(missleFx2 number: 806 loop: 1 play:)
				(= cycles 2)
			)
			(2
				(missleFx2 play:)
				(= cycles 2)
			)
			(3
				(client setCycle: CT 8 1 self)
			)
			(4
				(missleFx2 play:)
				(= cycles 2)
			)
			(5
				(client setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance limo of Actor
	(properties
		x 218
		y 132
		view 803
		cel 3
		signal 18465
		cycleSpeed 11
	)

	(method (cue)
		(self dispose:)
	)
)

(instance bird of Actor
	(properties
		view 802
		signal 26657
		cycleSpeed 2
	)

	(method (init &tmp temp0)
		(= temp0 (Random 3 40))
		(if (not (Random 0 1))
			(self
				setLoop: 0
				x: -20
				y: temp0
				setStep: 12 12
				setCycle: Fwd
				setPri: 30
				setMotion: MoveTo 330 temp0 birdTimer
			)
		else
			(self
				setLoop: 1
				x: 330
				y: temp0
				setStep: 12 12
				setCycle: Fwd
				setPri: 30
				setMotion: MoveTo -20 temp0 birdTimer
			)
		)
		(cawTimer cue:)
		(super init:)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance toCliffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 172 85 self)
			)
			(2
				(gEgo setMotion: MoveTo 172 83 self)
			)
			(3
				(gEgo setMotion: MoveTo 178 81 self)
			)
			(4
				(gCurRoom newRoom: 810)
			)
		)
	)
)

(instance fromCliffsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 178 76)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 172 82 self)
			)
			(2
				(gEgo setMotion: DPath 172 85 179 86 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromWoodsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 250 88)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 242 92 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromLobbyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 223 84)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 217 84 self)
			)
			(2
				(gEgo setMotion: MoveTo 215 87 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guardGate of Prop
	(properties
		x 130
		y 89
		view 800
		loop 1
	)
)

(instance startOfGameScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(= ticks 60)
			)
			(1
				(gGlobalSound1 number: 803 loop: -1 hold: 1 setVol: 10 play:)
				(= ticks 30)
			)
			(2
				(gGlobalSound1 fade: 127 10 5 0)
				(= ticks 240)
			)
			(3
				(limo
					init:
					setStep: 5 2
					setCycle: Fwd
					setMotion: DPath 174 120 61 120 -20 119 self
				)
			)
			(4
				(limo hide:)
				(= ticks 120)
			)
			(5
				(limo
					show:
					setStep: 3 2
					loop: 1
					cel: 0
					posn: -10 89
					setCycle: Fwd
					setPri: 100
					setMotion: MoveTo 117 89 self
				)
			)
			(6
				(gGlobalSound1 hold: 2)
				(= ticks 120)
			)
			(7
				(gGlobalSound2 number: 801 loop: 1 play:)
				(guardGate setCycle: End self)
			)
			(8
				(= ticks 20)
			)
			(9
				(gGlobalSound1 hold: 3)
				(limo setCycle: Fwd setMotion: MoveTo 197 89 self)
			)
			(10
				(gGlobalSound1 hold: 4)
				(limo loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(11
				(= cycles 2)
			)
			(12
				(limo setPri: 80 posn: 202 89 cel: 2)
				(= ticks 45)
			)
			(13
				(gEgo setPri: 79 posn: 203 90 loop: 8 cel: 1 show:)
				(= ticks 90)
			)
			(14
				(gGlobalSound1 hold: 5)
				(gGlobalSound2 number: 802 loop: 1 play:)
				(guardGate setCycle: Beg)
				(limo setCycle: End self)
			)
			(15
				(= cycles 2)
			)
			(16
				(limo posn: 194 88 loop: 3 cel: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(17
				(limo
					cel: 0
					loop: 3
					setCycle: Fwd
					setMotion: MoveTo -10 88 self
				)
			)
			(18
				(limo dispose:)
				(gGlobalSound1 fade:)
				(gEgo
					setPri: -1
					setSpeed: 6
					setMotion: DPath 211 90 215 87 217 84 223 84 self
				)
			)
			(19
				(= ticks 120)
			)
			(20
				(gThePlane drawPic: -1 0)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance toLobbyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DPath 215 87 217 84 223 84 self)
			)
			(1
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance doorFtr of Feature
	(properties
		noun 3
		nsLeft 206
		nsTop 70
		nsRight 220
		nsBottom 86
		approachX 214
		approachY 82
		x 215
		y 87
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(gCurRoom setScript: toLobbyScr)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance toGuardHouseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 125 88 self)
			)
			(1
				(gCurRoom newRoom: 850)
			)
		)
	)
)

(instance guardHouse of Feature
	(properties
		noun 2
		nsLeft 114
		nsTop 71
		nsRight 126
		nsBottom 85
		sightAngle 40
		approachX 140
		approachY 89
		x 120
		y 78
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4) ; Look, Do
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gCurRoom setScript: toGuardHouseScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hotel of Feature
	(properties
		noun 6
		x 215
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 78 165 53 182 43 192 38 208 37 210 16 223 12 236 13 236 39 258 39 259 50 276 46 277 65 255 62 239 84 206 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foliage of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 116 10 112 23 125 44 118 55 111 73 112 83 118 107 129 132 109 319 109 319 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance skyPoly1 of Polygon
	(properties)

	(method (init)
		(super init: 267 47 267 23 277 23 286 40 279 47)
	)
)

(instance skyPoly2 of Polygon
	(properties)

	(method (init)
		(super init: 160 18 176 11 157 32 128 3)
	)
)

(instance skyPoly3 of Polygon
	(properties)

	(method (init)
		(super init: 120 29 88 13 89 5 97 6)
	)
)

(instance skyPoly4 of Polygon
	(properties)

	(method (init)
		(super init: 172 44 190 25 202 34 207 17 207 36)
	)
)

(instance sky of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 37 239 16 244 17 256 28 256 37
					yourself:
				)
				(skyPoly1 init: yourself:)
				(skyPoly2 init: yourself:)
				(skyPoly3 init: yourself:)
				(skyPoly4 init: yourself:)
		)
		(super init: &rest)
	)
)

(instance palms of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 74 0 1 119 1 156 35 192 0 319 0 319 69 276 17 238 5 191 19 165 50 171 77 0 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance missleFx1 of Sound
	(properties
		flags 5
	)
)

(instance missleFx2 of Sound
	(properties
		flags 5
	)
)

(instance birds of Sound
	(properties
		flags 5
		number 811
		loop -1
	)
)

(instance ocean of Sound
	(properties
		flags 5
		number 812
		loop -1
	)
)

(instance birdTimer of Timer
	(properties)

	(method (cue)
		(if (gCast contains: bird)
			(bird dispose:)
			(self setReal: self (Random 20 60))
		else
			(bird init:)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance eatMissleScr of Script
	(properties)

	(method (dispose)
		(missleFx2 number: 0 dispose:)
		(missleFx1 number: 0 dispose:)
		(proc79_12 804 805 808 809 231)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc79_11 804 805 808 809 231)
				(gEgo posn: (guardHouse approachX:) (guardHouse approachY:))
				(gEgo setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:))
				(= cycles 2)
			)
			(1
				(missle cycleSpeed: 12 init: setCycle: End self)
			)
			(2
				(missleFx1 number: 804 loop: 1 play: self)
				(missle loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(missle loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(missle loop: 0 cel: 3 setCycle: Beg self)
			)
			(5)
			(6
				(missleFx1 number: 805 loop: 1 play:)
				(missle
					show:
					loop: 3
					cel: 0
					posn: 162 85
					setScript: skidScr self
				)
			)
			(7
				(missle loop: 4 cel: 0 setCycle: End self)
			)
			(8
				(missle loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(9
				(missleFx1 number: 807 loop: 1 play:)
				(= ticks 10)
			)
			(10
				(missle setCycle: End self)
			)
			(11
				(missleFx2 number: 808 loop: 1 play:)
				(missle loop: 6 cel: 0 setCycle: End self)
			)
			(12
				(missle hide:)
				(= ticks 120)
			)
			(13
				(missleFx1 number: 809 loop: 1 play:)
				(gEgo
					show:
					view: 804
					loop: 7
					cel: 0
					setSpeed: 8
					cycleSpeed: 16
					setCycle: CT 11 1 self
				)
			)
			(14
				(missleFx1 number: 0 stop:)
				(= cycles 2)
			)
			(15
				(gEgo setCycle: End self)
			)
			(16
				(missleFx2 number: 231 loop: 1 play:)
				(gEgo
					posn: 300 (gEgo y:)
					loop: 8
					setPri: 199
					setCycle: End self
				)
			)
			(17
				(EgoDead (if (IsFlag 84) 20 else 7) self)
			)
			(18
				(ClearFlag 2)
				(gCurRoom newRoom: 850)
			)
		)
	)
)

(instance cawTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				(not (or (gTalkers size:) (Print dialog:)))
				(not local2)
				(gCast contains: bird)
			)
			(= local2 1)
			(if (and (DoSound sndGET_AUDIO_CAPABILITY) (or (ResCheck 140 1003) (ResCheck rsAUDIO 1003))) ; WAVE
				(sfx number: 1003 loop: 1 play: self)
			else
				(self cue:)
			)
		else
			(= local2 0)
			(self setTicks: (Random 3 20) self)
		)
	)
)

