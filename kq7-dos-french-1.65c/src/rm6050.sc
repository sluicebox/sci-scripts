;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6050 0
)

(local
	[local0 12] = [88 101 93 100 98 98 103 95 108 93 113 91]
	[local12 5] = [1 5 6 4 0]
	local17
	local18
	[local19 5] = [105 100 115 94 89]
	[local24 5] = [115 107 91 123 111]
	local29
)

(instance rm6050 of KQRoom
	(properties
		picture 6050
	)

	(method (init &tmp temp0 temp1)
		(SetFlag 21)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					name: {Polygon}
					type: PContainedAccess
					init: 115 130 94 134 98 165 153 165 216 124 208 114 161 113
					yourself:
				)
		)
		(switch gPrevRoomNum
			(6300
				(self setScript: enterRoom)
			)
			(6060
				(self setScript: returnFromBall)
			)
			(else
				(self setScript: enterRoom)
			)
		)
		(gazeBall init:)
		(mySouthExit init:)
		(glint init: hide: setScript: glintMe)
		(glowingBall init: hide:)
		(for ((= temp0 1)) (<= temp0 6) ((++ temp0))
			(harpSet
				add:
					(((harpString new:)
							view: 6050
							loop: (+ 2 temp0)
							cel: 0
							x: 84
							y: 84
							soundNumber: (+ 6050 temp0)
							yourself:
						)
						init:
						yourself:
					)
			)
			(Load rsSOUND (+ 6050 temp0))
		)
		(gKqMusic1
			stop:
			number: 6050
			setLoop: -1
			play:
			setVol: 0
			fade: 127 25 10 0
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 ((gUser curEvent:) x:))
		(= temp1 ((gUser curEvent:) y:))
		(cond
			((and (> temp0 72) (< temp0 120) (> temp1 80) (< temp1 125))
				(if (not local29)
					(gKqMusic1 setVol: 63)
					(= local29 1)
				)
			)
			(local29
				(gKqMusic1 setVol: 127)
				(= local29 0)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gKqMusic1 fade: 0 25 10 1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(string stop:)
		(harpSet release:)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(gEgo
					x: 140
					y: 175
					setScale:
					scaleX: 115
					scaleY: 115
					init:
					normalize: 3
					setMotion: MoveTo 140 134 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(gEgo setMotion: MoveTo (mySouthExit approachX:) 160 self)
			)
			(1
				(gCurRoom newRoom: 6300)
			)
		)
	)
)

(instance enterBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(gEgo setMotion: PolyPath 109 120 self)
			)
			(1
				(gEgo
					view: 6051
					loop: 0
					cel: 0
					setScale:
					scaleX: 146
					scaleY: 146
					setPri: 128
					setCycle: End self
				)
				(gKqSound1 number: 868 setLoop: 1 play:)
			)
			(2
				(gEgo setPri: -1 hide:)
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 6060)
				(self dispose:)
			)
		)
	)
)

(instance returnFromBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(Load rsVIEW 6051)
				(Load rsVIEW 8021)
				(Load rsVIEW 800)
				(Load rsSOUND 868)
				(= seconds 1)
			)
			(1
				(gKqSound1 number: 868 setLoop: 1 play:)
				(gEgo
					x: 112
					y: 130
					view: 6051
					loop: 0
					setPri: 128
					setSpeed: 6
					setScale:
					scaleX: 146
					scaleY: 146
				)
				(gEgo cel: (NumCels gEgo) init: setCycle: Beg self)
			)
			(2
				(gEgo normalize: 1 setScale: scaleX: 115 scaleY: 115)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToGaze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(gEgo setMotion: MoveTo 95 139 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo
					view: 8085
					loop: 1
					cel: 0
					y: (- (gEgo y:) 2)
					setCycle: Osc 1 self
				)
			)
			(3
				(gEgo
					normalize:
					setScale:
					scaleX: 115
					scaleY: 115
					loop: 7
					y: (+ (gEgo y:) 2)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance glintMe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(= temp0 (Random 0 4))
				(client
					cel: 0
					x: [local19 temp0]
					y: [local24 temp0]
					show:
					setCycle: End self
				)
			)
			(2
				(client hide:)
				(= cycles 2)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance playMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Osc 2 self)
				(string
					number: (client soundNumber:)
					setLoop: 1
					priority: 100
					play:
					setVol: 127
				)
			)
			(1
				(client cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance finishTune of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 45)
			)
			(1
				(gKqSound1
					number: 6057
					setLoop: 1
					priority: 100
					play: self
					setVol: 127
				)
			)
			(2
				((harpSet at: 0) setCycle: Osc 3)
			)
			(3
				((harpSet at: 1) setCycle: Osc 3)
			)
			(4
				((harpSet at: 3) setCycle: Osc 3)
			)
			(5
				((harpSet at: 5) setCycle: Osc 3)
			)
			(6
				((harpSet at: 4) setCycle: Osc 3)
			)
			(7
				((harpSet at: 2) setCycle: Osc 3)
			)
			(8
				(gKqSound1 stop:)
				(= ticks 10)
			)
			(9
				(gKqSound1 number: 867 setLoop: 1 play:)
				(client cel: 0 show: setCycle: Osc 5 self)
			)
			(10
				(client hide:)
				(= cycles 2)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance glowingBall of Prop
	(properties
		x 86
		y 98
		priority 130
		fixPriority 1
		view 6050
		loop 1
	)
)

(instance glint of Prop
	(properties
		x 105
		y 115
		view 6050
		loop 2
	)
)

(class harpString of Prop
	(properties
		soundNumber 0
	)

	(method (playSound)
		(if soundNumber
			(self setScript: (playMe new:))
		)
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self playSound:)
				(if (== (- soundNumber 6050) [local12 local17])
					(++ local17)
				else
					(= local17 0)
				)
				(if (not [local12 local17])
					(= local18 1)
					(= local17 0)
					(glowingBall setScript: (finishTune new:))
				)
			)
		)
	)
)

(instance gazeBall of Feature
	(properties
		nsLeft 75
		nsTop 77
		nsRight 90
		nsBottom 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if local18
					(gCurRoom setScript: enterBall)
				else
					(gCurRoom setScript: goToGaze)
				)
				(return 1)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 60
		nsTop 130
		nsRight 170
		nsBottom 140
		approachX 134
		approachY 135
		x 134
		y 145
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: leaveRoom)
	)
)

(instance string of Sound
	(properties
		number 6051
	)
)

(instance harpSet of Set
	(properties)
)

