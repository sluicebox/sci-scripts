;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Inset)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	local0 = 1
	local1
)

(instance rm690 of FPRoom
	(properties
		noun 3
		picture 690
		east 220
	)

	(method (init)
		(LoadMany rsVIEW 691)
		(gEgo init: normalize: setScale: Scaler 111 100 181 159)
		(switch gPrevRoomNum
			(700
				(gGame handsOff:)
				(LoadMany rsSOUND 2694 2692 2691)
				(box init: setPri: 14)
				(gEgo view: 691 setLoop: 6 setCel: 0 x: 210 y: 165 stopUpd:)
				(banker view: 693 setLoop: 4 setCel: 5 x: 109 y: 176)
				(vaultDoor
					view: 691
					setLoop: 4
					setCel: 1
					ignoreActors:
					stopUpd:
					init:
				)
				(gate
					view: 691
					setLoop: 0
					setCel: 1
					setPri: 13
					ignoreActors:
					stopUpd:
					init:
				)
				(gCurRoom setScript: sAfterBox)
			)
			(east
				(gEgo x: 300 y: 162)
				(self setScript: sEnter)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gGame handsOn:)
				(= style 100)
				(gEgo x: 160 y: 160)
			)
		)
		(banker
			init:
			setScale: Scaler 101 79 165 146
			stopUpd:
			approachVerbs: 2 4 ; Talk, Do
			setStep: 6 3
		)
		(super init:)
		(if (or (> gAct 1) (== gPrevRoomNum 700))
			(gGameMusic1 fade: 127 25 10 0)
		else
			(gGameMusic1
				number: 690
				flags: 1
				loop: -1
				play:
				setVol: 80
				fade: 127 25 10 0
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 161 151 161 93 186 319 186 319 189 0 189 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 303 166 286 182 148 182 161 165 296 166
					yourself:
				)
		)
		(portrait init:)
		(bigPainting init:)
		(crack init: setOnMeCheck: 1 16384)
		(bigPlant init: setOnMeCheck: 1 2)
		(camera init: setOnMeCheck: 1 4)
		(lamp init: setOnMeCheck: 1 8)
		(clock init: setOnMeCheck: 1 16)
		(desk init: setOnMeCheck: 1 32)
		(files init: setOnMeCheck: 1 64)
		(quill init: setOnMeCheck: 1 128)
		(registerBook init: setOnMeCheck: 1 256)
		(roundPic init: setOnMeCheck: 1 512)
		(roundPic2 init: setOnMeCheck: 1 512)
		(rug init: setOnMeCheck: 1 1024)
		(smallPlant init: setOnMeCheck: 1 2048)
		(cage init: setOnMeCheck: 1 4096)
		(wantedPoster init: setOnMeCheck: 1 8192)
		(pendulum setCycle: Osc init: setPri: 1)
		(if (!= gPrevRoomNum 700)
			(vaultDoor init: stopUpd: ignoreActors:)
			(gate init: setPri: 13 stopUpd: setCel: 0 ignoreActors:)
			(flashTimer setReal: flashTimer (Random 10 15))
		)
	)

	(method (dispose)
		(gGameMusic1 fade: 80 25 10 0)
		(gTimers delete: flashTimer)
		(super dispose:)
	)
)

(instance sShowFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flash init: setLoop: 2 setCel: 0)
				(= ticks 30)
			)
			(1
				(flash setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(flash dispose:)
				(flashTimer setReal: flashTimer (Random 10 15))
				(self dispose:)
			)
		)
	)
)

(instance sAskBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 1 global123 self)
				(if (< global123 8)
					(++ global123)
				)
				(= local0 0)
			)
			(1
				(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
				(gGame setCursor: 999 1)
				(switch
					(Print
						font: gUserFont
						addText: 21 0 2 1 0 0 ; "Wanna sell me your property? You won't regret it!"
						addButton: 1 22 0 0 1 0 30 690 ; "Yep. I want the cashola!"
						addButton: 2 22 0 0 2 0 50 690 ; "And give up my dreams of herohood?        Never, you CAD!"
						init:
					)
					(1
						(= global122 21)
						(gCurRoom newRoom: 99) ; deathRoom
					)
					(2
						(= cycles 1)
					)
				)
			)
			(2
				(gGame setCursor: gNormalCursor)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 287 162 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTimers delete: flashTimer)
				(if (gCast contains: flash)
					(sShowFlash dispose:)
					(flash dispose:)
				)
				(LoadMany rsSOUND 2694 2692 2691)
				(LoadMany rsVIEW 693)
				(= local1 (gEgo cycleSpeed:))
				(gEgo setSpeed: 7 put: 14) ; Deposit_Key
				(proc0_9 700)
				(gEgo setMotion: PolyPath 210 165 self)
			)
			(1
				(gEgo view: 691 setLoop: 6 setCel: 1 stopUpd:)
				(= cycles 3)
			)
			(2
				(UnLoad 128 800)
				(gMessager say: 1 46 0 0 self) ; "You hand the safe-deposit key to P.H. Balance."
			)
			(3
				(banker
					view: 693
					setLoop: 8
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 135 149 self
				)
			)
			(4
				(banker setMotion: MoveTo 69 169 self)
			)
			(5
				(banker loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(proc0_9 0)
				(banker setCycle: Fwd)
				(gGameMusic2 number: 2691 flags: 1 loop: -1 play:)
				(LoadMany rsVIEW 690)
				(= ticks 120)
			)
			(7
				(gGameMusic2 stop:)
				(proc0_9 700)
				(banker setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(banker setCycle: Beg)
				(gGameMusic2 number: 2692 flags: 1 loop: 1 play:)
				(vaultDoor view: 690 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(9
				(vaultDoor view: 691 setLoop: 4 setCel: 1 stopUpd: 1)
				(= cycles 3)
			)
			(10
				(UnLoad 128 690)
				(banker
					setLoop: 8
					setCel: 7
					posn: 63 164
					setCycle: Walk
					setMotion: MoveTo 1 155 self
				)
			)
			(11
				(LoadMany rsVIEW 694)
				(= seconds 2)
			)
			(12
				(gEgo setCel: 0)
				(banker
					setLoop: 2
					setCycle: Walk
					setMotion: DPath 66 161 70 170 self
				)
			)
			(13
				(gGameMusic2 number: 2700 flags: 1 loop: 1 play:)
				(gate view: 694 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(14
				(gate view: 691 setLoop: 0 setCel: 1 stopUpd: 1)
				(= cycles 3)
			)
			(15
				(UnLoad 128 694)
				(banker setMotion: DPath 116 170 153 176 self)
			)
			(16
				(banker setLoop: 4 setCel: 0 setCel: 14 setCycle: CT 3 1 self)
			)
			(17
				(box init: setPri: 14)
				(banker setCycle: End self)
			)
			(18
				(= seconds 2)
			)
			(19
				(flashTimer setReal: flashTimer (Random 10 15))
				(gEgo normalize: setCel: 2 setSpeed: local1)
				(gCurRoom newRoom: 700)
				(self dispose:)
			)
		)
	)
)

(instance sAfterBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setSpeed: 7)
				(= seconds 2)
			)
			(1
				(proc0_9 1000 banker)
				(gMessager say: 2 0 0 1 self) ; "I'm all done now."
			)
			(2
				(gEgo setLoop: 6 setCel: 1 stopUpd:)
				(banker
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 153 176 self
				)
			)
			(3
				(banker setLoop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(box dispose:)
				(banker setCycle: End self)
			)
			(5
				(banker
					setLoop: 3
					setCycle: Walk
					setMotion: DPath 116 170 81 170 66 161 1 155 self
				)
			)
			(6
				(LoadMany rsVIEW 690)
				(= seconds 2)
			)
			(7
				(banker
					setLoop: 7
					setCycle: Walk
					setMotion: DPath 66 161 69 169 self
				)
			)
			(8
				(banker setLoop: 1 setCel: 0)
				(vaultDoor
					view: 690
					setLoop: 0
					setCel: 5
					setCycle: CT 2 -1 self
				)
			)
			(9
				(banker setLoop: 1 setCel: 0 setCycle: Beg)
				(gGameMusic2 number: 2692 flags: 1 loop: 1 play:)
				(vaultDoor setCycle: Beg self)
			)
			(10
				(vaultDoor view: 691 setLoop: 4 setCel: 0 stopUpd: 1)
				(= cycles 3)
			)
			(11
				(UnLoad 128 690)
				(proc0_9 0)
				(banker loop: 0 cel: 0 setCycle: Fwd)
				(gGameMusic2 number: 2691 flags: 1 loop: -1 play:)
				(= ticks 120)
			)
			(12
				(gGameMusic2 stop:)
				(proc0_9 1000 banker)
				(banker
					setLoop: 7
					setCycle: Walk
					setMotion: DPath 81 170 116 170 163 175 self
				)
			)
			(13
				(banker setLoop: 4 setCel: 5)
				(= cycles 10)
			)
			(14
				(LoadMany rsVIEW 694)
				(gMessager say: 2 0 0 2 self) ; "Thank you for using the Bank of Bob."
			)
			(15
				(banker setLoop: 8 setMotion: DPath 116 170 60 170 self)
			)
			(16
				(banker setLoop: 4 setCel: 5)
				(gGameMusic2 number: 2700 flags: 1 loop: 1 play:)
				(gate view: 694 setLoop: 0 setCel: 9 setCycle: Beg self)
			)
			(17
				(gate view: 691 setLoop: 0 setCel: 0 stopUpd:)
				(gEgo view: 691 setLoop: 6 setCel: 0 stopUpd:)
				(UnLoad 128 694)
				(= cycles 3)
			)
			(18
				(banker
					setLoop: 7
					setCel: 0
					setMotion: DPath 104 154 191 149 self
				)
			)
			(19
				(banker view: 691 setLoop: 5 setCel: 0 posn: 191 149)
				(= seconds 2)
			)
			(20
				(= cycles 2)
			)
			(21
				(gEgo get: -1 14) ; Deposit_Key
				(gate view: 691 setLoop: 0 setCel: 0 stopUpd:)
				(vaultDoor view: 691 setLoop: 4 setCel: 0 stopUpd:)
				(banker stopUpd:)
				(= cycles 3)
			)
			(22
				(gEgo normalize: setCel: 2 setSpeed: local1)
				(UnLoad 128 694)
				(UnLoad 128 690)
				(UnLoad 128 693)
				(flashTimer setReal: flashTimer (Random 10 15))
				(proc0_9 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pendulum of Prop
	(properties
		x 78
		y 82
		noun 6
		view 691
		loop 1
		detailLevel 2
	)
)

(instance vaultDoor of Prop
	(properties
		x 65
		y 69
		noun 4
		view 691
		loop 4
	)
)

(instance gate of Prop
	(properties
		x 125
		y 167
		noun 17
		view 691
	)
)

(instance banker of Actor
	(properties
		x 191
		y 149
		noun 1
		approachX 214
		approachY 162
		view 691
		loop 5
	)

	(method (cue)
		(gate startUpd: cel: 0)
		(vaultDoor startUpd: cel: 0)
		(box dispose:)
		(banker view: 691 setLoop: 5 setCel: 0 posn: 191 149 setMotion: 0)
		(sAfterBox changeState: 19)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(46 ; Deposit_Key
				(gCurRoom setScript: sOpenBox)
				(gGame points: 1 142)
			)
			(2 ; Talk
				(if (< gCurPuzzle 7)
					(= temp0 0)
				else
					(= temp0 1)
				)
				(if (== temp0 1)
					(if (not (IsFlag 108))
						(SetFlag 108)
						(= global123 1)
					)
					(gCurRoom setScript: sAskBox)
				else
					(gMessager say: 1 2 temp0 global123)
					(= global123 (+ (mod global123 8) 1))
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flash of Prop
	(properties
		x 110
		y 58
		noun 5
		view 691
		loop 2
		detailLevel 2
	)
)

(instance box of View
	(properties
		x 186
		y 135
		view 693
		loop 6
	)
)

(instance crack of Feature
	(properties
		x 160
		y 60
		noun 23
	)
)

(instance portrait of Feature
	(properties
		x 138
		y 72
		noun 8
		nsTop 61
		nsLeft 125
		nsBottom 84
		nsRight 152
		sightAngle 40
		approachX 138
		approachY 72
	)
)

(instance bigPainting of Feature
	(properties
		x 254
		y 77
		noun 10
		nsTop 60
		nsLeft 223
		nsBottom 95
		nsRight 285
		sightAngle 40
		approachX 254
		approachY 77
	)
)

(instance bigPlant of Feature
	(properties
		x 7
		y 114
		noun 11
		sightAngle 40
		approachX 7
		approachY 114
	)
)

(instance camera of Feature
	(properties
		x 97
		y 61
		noun 5
		sightAngle 40
		approachX 97
		approachY 61
	)
)

(instance lamp of Feature
	(properties
		x 292
		y 39
		noun 18
		sightAngle 40
		approachX 292
		approachY 39
	)
)

(instance clock of Feature
	(properties
		x 82
		y 85
		noun 6
		sightAngle 40
		approachX 82
		approachY 85
	)
)

(instance desk of Feature
	(properties
		x 225
		y 175
		noun 13
		sightAngle 40
		approachX 225
		approachY 154
	)
)

(instance files of Feature
	(properties
		x 137
		y 120
		noun 19
		sightAngle 40
		approachX 137
		approachY 120
	)
)

(instance quill of Feature
	(properties
		x 252
		y 118
		noun 14
		sightAngle 40
		approachX 252
		approachY 118
	)
)

(instance registerBook of Feature
	(properties
		x 219
		y 134
		noun 15
		sightAngle 40
		approachX 219
		approachY 134
	)
)

(instance roundPic of Feature
	(properties
		x 8
		y 77
		noun 7
		sightAngle 40
		approachX 8
		approachY 77
	)
)

(instance roundPic2 of Feature
	(properties
		x 8
		y 100
		noun 7
		sightAngle 40
		approachX 8
		approachY 100
	)
)

(instance rug of Feature
	(properties
		x 228
		y 175
		noun 16
		sightAngle 40
		approachX 228
		approachY 175
	)
)

(instance smallPlant of Feature
	(properties
		x 97
		y 119
		noun 12
		sightAngle 40
		approachX 97
		approachY 119
	)
)

(instance cage of Feature
	(properties
		x 241
		y 121
		noun 20
		sightAngle 40
		approachX 241
		approachY 121
	)
)

(instance wantedPoster of Feature
	(properties
		x 199
		y 78
		noun 9
		sightAngle 40
		approachX 199
		approachY 78
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: posterInset)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flashTimer of Timer
	(properties)

	(method (cue)
		(flash setScript: sShowFlash)
	)
)

(instance posterInset of Inset
	(properties
		view 255
		x 70
		y 70
		disposeNotOnMe 1
	)

	(method (doVerb)
		(UnLoad 128 255)
		(self dispose:)
	)
)

