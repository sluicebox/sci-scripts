;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use ExitArrow)
(use n045)
(use Array)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm910 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance ambience of Sound
	(properties
		number 924
		loop -1
	)
)

(instance rm910 of Room
	(properties
		noun 22
		picture 910
		style 0
	)

	(method (doVerb theVerb)
		(if (== gDay 3)
			(if (Message msgGET gCurRoomNum noun theVerb 10 1)
				(gMessager say: noun theVerb 10 0)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(proc45_0)
		(gEgo get: 18) ; coins
		(gThePlane setRect: 0 0 319 152)
		(super init: &rest)
		(= local1 (IntArray newWith: 3 891 892 -1))
		(ambience play:)
		(gTheIconBar enable: show: 0)
		(pretzels0 init:)
		(pretzels1 init:)
		(pretzels2 init:)
		(pretzels3 init:)
		(tv init:)
		(stools init:)
		(leftPic init:)
		(rightPic init:)
		(poolTable init:)
		(poolBalls init:)
		(videoGame2 init:)
		(if (!= gDay 3)
			(poolTable approachVerbs: 4 27) ; Do, badge
			(poolBalls approachVerbs: 4 27) ; Do, badge
			(videoGame2 approachVerbs: 4 29 20) ; Do, coins, wallet
		)
		(bartender
			init:
			signal: (| (bartender signal:) $5000)
			approachVerbs:
				(if (== gDay 3)
					0
				else
					4
					2
					27
				)
			setScript: bartScr
		)
		(barGlass
			init:
			signal: (| (barGlass signal:) $4000)
			x: (- (bartender x:) 10)
			y: (- (bartender y:) 10)
			setPri: (+ (bartender priority:) 1)
		)
		(lights init: signal: (| (lights signal:) $4000) setCycle: Fwd)
		(if (== gDay 3)
			(gGame handsOff:)
			(proc0_4 1)
			(if (> (Random 0 100) 50)
				(woman init: setScript: womanScr)
				(womanGlass x: (+ (woman x:) 10) y: (- (woman y:) 30) init:)
			)
			(julie init: signal: (| (julie signal:) $5000))
			(julieLegs
				signal: (| (julieLegs signal:) $5000)
				x: (- (julie x:) 4)
				y: (- (julie y:) 6)
				z: (julie z:)
				init:
			)
			(julieBeer init: signal: (| (julieBeer signal:) $4000))
			(sam init: signal: (| (sam signal:) $5000) setScript: samScr)
			(gEgo
				view: 9913
				setLoop: 0
				cel: 0
				posn: 77 125
				heading: 225
				signal: (| (gEgo signal:) $1800)
				setPri: 6
				setScript: egoHandleScr
				actions: egoActions
				init:
			)
			(don
				view: 9108
				cel: 4
				x: 154
				y: 167
				init:
				signal: (| (don signal:) $5000)
			)
			(kevin
				view: 9116
				x: 297
				y: 104
				z: -15
				priority: 100
				fixPriority: 1
				signal: (| (kevin signal:) $5000)
				init:
			)
			(kevLight
				priority: (+ (kevin priority:) 1)
				fixPriority: 1
				signal: (| (kevLight signal:) $5000)
				x: (- (kevin x:) 5)
				y: (- (kevin y:) 56)
				z: (kevin z:)
				init:
				setCycle: Fwd
			)
			(newsGuy signal: (| (newsGuy signal:) $5000) init:)
			(newsGuyHead
				signal: (| (newsGuyHead signal:) $5000)
				setPri: (newsGuy priority:)
				cel: 3
				init:
			)
		else
			(proc0_4 0)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 319 117 289 112 219 110 182 106 154 109 149 121 75 124 80 128 98 131 87 137 96 147 206 147 200 130 284 128 319 139
						yourself:
					)
			)
			(switch gPrevRoomNum
				(41 ; skimmerRoom
					(gEgo
						heading: 48
						posn: 287 118
						setScaler: Scaler 90 66 145 108
						normalize: 9120
						init:
					)
				)
				(2010
					(gEgo
						heading: 1
						posn: 174 110
						setScaler: Scaler 90 66 145 108
						normalize: 9120
						init:
					)
				)
				(else
					(gEgo
						heading: 270
						posn: 300 130
						setScaler: Scaler 90 66 145 108
						normalize: 9120
						init:
					)
				)
			)
			(if (> (Random 0 100) 50)
				(woman
					init:
					signal: (| (woman signal:) $4000)
					setScript: womanScr
					approachVerbs: 4 2 27 ; Do, Talk, badge
				)
				(womanGlass init: x: (+ (woman x:) 10) y: (- (woman y:) 30))
			)
			(if (> (Random 0 100) 50)
				(don setScript: donScr)
			else
				(don view: 9108 cel: 0 x: 154 y: 167)
			)
			(don init: signal: (| (don signal:) $5000) approachVerbs: 4 2 27) ; Do, Talk, badge
			(if (and (!= gPrevRoomNum 41) (> (Random 0 100) 50)) ; skimmerRoom
				(kevin
					view: 9116
					x: 297
					y: 119
					priority: 100
					fixPriority: 1
					signal: (| (kevin signal:) $5000)
					approachVerbs: 2 ; Talk
					init:
				)
				(kevLight
					priority: (+ (kevin priority:) 1)
					fixPriority: 1
					signal: (| (kevLight signal:) $5000)
					x: (- (kevin x:) 5)
					y: (- (kevin y:) 56)
					init:
					setCycle: Fwd
				)
			else
				(kevin
					view: 9114
					x: 107
					y: 120
					init:
					signal: (| (kevin signal:) $5000)
					approachVerbs: 4 2 27 ; Do, Talk, badge
					approachX: 136
					approachY: 123
					setScript: kevinScr
				)
				(kevLegs
					x: (kevin x:)
					y: (kevin y:)
					init:
					signal: (| (kevLegs signal:) $5000)
					approachVerbs: 4 2 27 ; Do, Talk, badge
					approachX: 136
					approachY: 123
				)
				(kevGlass
					view: 9114
					x: (- (kevin x:) 16)
					y: (- (kevin y:) 40)
					init:
					signal: (| (kevGlass signal:) $5000)
					approachVerbs: 4 2 27 ; Do, Talk, badge
					approachX: 136
					approachY: 123
				)
			)
			(if (> (Random 0 100) 50)
				(newsGuy
					init:
					signal: (| (newsGuy signal:) $5000)
					approachVerbs: 4 2 22 ; Do, Talk, handgun
				)
				(newsGuyHead
					init:
					signal: (| (newsGuyHead signal:) $5000)
					approachVerbs: 4 2 22 ; Do, Talk, handgun
				)
			)
			(toMap init:)
			(gGame handsOn:)
		)
		(videoGame init:)
		(if (and (!= gDay 3) (not (gCast contains: kevLight)))
			(videoGame approachVerbs: 4 20 29) ; Do, wallet, coins
		else
			(videoGame _approachVerbs: 0)
		)
		(soundScr register: 0 init:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 310)
			(self newRoom: 17) ; MapRoom
		)
	)

	(method (dispose)
		(gEgo put: 42) ; beer
		(soundScr dispose:)
		(gGlobalSound1 fade: 0 60 20 1)
		(super dispose:)
	)
)

(instance soundScr of Script
	(properties)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(super dispose:)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (not state) (== (gGlobalSound0 prevSignal:) 10))
			(gGlobalSound0 prevSignal: 0)
			(if (> (++ local2) 2)
				(= local2 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: (local1 at: register) loop: -1 play:)
			)
			(1
				(gGlobalSound0 fade: 0 10 10 1 self)
			)
			(2
				(if (== (local1 at: (++ register)) -1)
					(= register 0)
				)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance kevLight of Prop
	(properties
		view 9116
		loop 1
	)
)

(instance lights of Prop
	(properties
		x 161
		y 34
		view 916
		detailLevel 5
	)
)

(instance newsGuy of Prop
	(properties
		noun 18
		x 35
		y 145
		view 9112
		loop 2
	)

	(method (doVerb theVerb)
		(cond
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 2 4) ; Talk, Do
				(gGame handsOff:)
				(gCurRoom setScript: guyTalkScr 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance newsGuyHead of Prop
	(properties
		noun 18
		x 28
		y 90
		view 9112
	)

	(method (doVerb theVerb)
		(newsGuy doVerb: theVerb)
	)
)

(instance guyTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 2)
					(gMessager say: 18 register 0 1 self) ; "Hello, how are you?"
				else
					(= cycles 1)
				)
			)
			(1
				(newsGuyHead setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(if (== register 2)
					(gMessager say: 18 register 0 2 self) ; "Humph... I'm busy, pal."
				else
					(gMessager say: 18 register 0 0 self)
				)
			)
			(3
				(newsGuyHead cel: 3 setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kevin of Prop
	(properties
		noun 17
	)

	(method (doVerb theVerb)
		(cond
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 2 4) ; Talk, Do
				(cond
					((!= view 9116)
						(gGame handsOff:)
						(self setCycle: 0 setScript: 0)
						(gCurRoom setScript: kevinTalkScr 0 theVerb)
					)
					((Message msgGET gCurRoomNum noun theVerb 12 1)
						(gMessager say: noun theVerb 12 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kevGlass of Prop
	(properties
		noun 17
		view 9114
		loop 2
		cel 1
	)

	(method (doVerb theVerb)
		(kevin doVerb: theVerb)
	)
)

(instance kevLegs of Prop
	(properties
		noun 17
		view 9114
		loop 2
	)

	(method (doVerb theVerb)
		(kevin doVerb: theVerb)
	)
)

(instance kevinScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(kevin setLoop: 1 cel: 0 setCycle: End self)
				(kevGlass hide:)
			)
			(2
				(= cycles 5)
			)
			(3
				(kevin setCycle: Beg self)
			)
			(4
				(kevin setLoop: 0)
				(kevGlass show:)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance kevinTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (kevin loop:) 1)
					(kevin setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(kevGlass show:)
				(kevin setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 17 register 0 0 self)
			)
			(3
				(kevin setCycle: Beg self)
			)
			(4
				(kevin setScript: kevinScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance don of Prop
	(properties
		noun 15
		x 187
		y 165
		view 9109
	)

	(method (doVerb theVerb)
		(cond
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 2 4 27) ; Talk, Do, badge
				(gGame handsOff:)
				(self setCycle: 0 setScript: 0)
				(gCurRoom setScript: donTalkScr 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance donScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(don view: 9109 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(don view: 9110 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(don setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(don view: 9109 setLoop: 0 cel: 0)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance donTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (don view:) 9109) (don cel:))
						(don setCycle: Beg self)
					)
					((and (== (don view:) 9110) (== (don loop:) 0) (don cel:))
						(don setCycle: Beg self)
					)
					(
						(and
							(== (don view:) 9110)
							(== (don loop:) 1)
							(!= (don cel:) 8)
						)
						(don setCycle: End self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (== (don view:) 9109)
					(don setCel: 0 setLoop: 1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (and (== (don view:) 9110) (== (don loop:) 0))
					(don view: 9109)
					(don cel: (don lastCel:) setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== (don view:) 9108)
					(don setCycle: End self)
				else
					(don view: 9111 setLoop: 0 cel: 0 setCycle: End self)
				)
			)
			(4
				(if (== (don view:) 9108)
					(= cycles 1)
				else
					(don setLoop: 1 cel: 0 setCycle: End self)
				)
			)
			(5
				(cond
					((!= register 4)
						(gMessager say: 15 register 0 0 self)
					)
					(local4
						(gMessager say: 15 4 0 2 self) ; "Look, Jack, back off. I'm playing pool here."
					)
					(else
						(++ local4)
						(gMessager say: 15 4 0 1 self) ; "You trying to start something?"
					)
				)
			)
			(6
				(if (== (don view:) 9108)
					(don setCycle: Beg self)
				else
					(don view: 9111 setLoop: 0)
					(don cel: (don lastCel:) setCycle: Beg self)
				)
			)
			(7
				(if (!= (don view:) 9108)
					(don view: 9109 setLoop: 1 setCel: 0)
					(UpdateScreenItem don)
					(= cycles 3)
				else
					(= cycles 1)
				)
			)
			(8
				(if (!= (don view:) 9108)
					(don view: 9109 setLoop: 0 cel: 0 setScript: donScr)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance woman of Prop
	(properties
		noun 14
		approachX 230
		approachY 111
		x 211
		y 97
		view 9106
	)

	(method (doVerb theVerb)
		(cond
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 52 1 25 22) ; notebook, Look, emptyClip, handgun
				(super doVerb: theVerb &rest)
			)
			((Message msgGET gCurRoomNum noun theVerb 0 1)
				(gGame handsOff:)
				(woman setCycle: 0 setScript: 0)
				(gCurRoom setScript: womanTalkScr 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance womanGlass of Prop
	(properties
		view 9106
		loop 2
	)
)

(instance womanScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(woman setLoop: 1 cel: 0 setCycle: End self)
				(womanGlass hide:)
			)
			(2
				(= cycles 5)
			)
			(3
				(woman setCycle: Beg self)
			)
			(4
				(womanGlass show:)
				(woman setLoop: 0)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance womanTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (woman loop:) 1)
					(woman setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(womanGlass show:)
				(woman setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 14 register 0 0 self)
			)
			(3
				(woman setCycle: Beg self)
			)
			(4
				(woman setScript: womanScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toMap of ExitArrow
	(properties
		nsTop 66
		nsLeft 305
		nsBottom 119
		nsRight 320
		exitDir 2
	)
)

(instance careyBeer of View
	(properties
		noun 10
		x 57
		y 129
		z 49
		fixPriority 1
		view 915
		loop 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(gEgo get: 42) ; beer
			(gGame handsOff:)
			(gCurRoom setScript: drinkBeerScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance julieBeer of View
	(properties
		noun 11
		x 52
		y 120
		z 36
		priority 110
		fixPriority 1
		view 915
		loop 1
	)
)

(instance samBeer of View
	(properties
		noun 12
		x 45
		y 120
		z 40
		priority 8
		fixPriority 1
		view 915
		loop 1
	)
)

(instance egoHandleScr of Script
	(properties)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(gMessager say: 3 3 0 0) ; "Carey, how rude! We invited you out, now you stay and talk to us!"
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; beer
			(gGame handsOff:)
			(gCurRoom setScript: drinkBeerScr)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance drinkBeerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 4 1 self)
			)
			(1
				(careyBeer hide:)
				(gEgo setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo setCycle: CT 4 -1 self)
			)
			(4
				(careyBeer show:)
				(gEgo setCycle: Beg self)
			)
			(5
				(if (> (++ local0) 3)
					(self setScript: passOutScr)
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance passOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 62 3 0 self) ; "Carey, are you OK? You're really knocking back that beer."
			)
			(1
				(gPqFlags set: 178)
				(= gDay 4)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance julie of Prop
	(properties
		noun 3
		x 46
		y 96
		priority 6
		fixPriority 1
		view 910
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 22) ; handgun
				(gMessager say: 0 0 4 0) ; "There is no threat to limb or life! Holster your weapon!"
			)
			((== theVerb 2) ; Talk
				(switch (++ local5)
					(1
						(gMessager sayRange: noun theVerb 0 1 2) ; "You look really nice tonight, Chester."
					)
					(2
						(gMessager sayRange: noun theVerb 0 3 6) ; "Chester. What kind of name is that?"
					)
					(else
						(gMessager sayRange: noun theVerb 0 7 8) ; "Chester, how come you became a cop?"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance julieLegs of View
	(properties
		noun 3
		priority 6
		fixPriority 1
		view 910
		loop 1
	)

	(method (doVerb theVerb)
		(julie doVerb: theVerb &rest)
	)
)

(instance sam of Actor
	(properties
		noun 8
		x 54
		y 119
		view 9104
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 22) ; handgun
				(gMessager say: 0 0 4 0) ; "There is no threat to limb or life! Holster your weapon!"
			)
			((== theVerb 2) ; Talk
				(switch (++ local6)
					(1
						(gMessager sayRange: 8 2 0 1 2) ; "Sam, how many autopsies do you think you've performed?"
					)
					(2
						(gMessager sayRange: 8 2 0 3 4) ; "Sam, what do you like to do in your free time?"
					)
					(3
						(gMessager sayRange: 8 2 0 5 8) ; "Sam, how long have you and Chester known each other?"
					)
					(else
						(gMessager sayRange: 8 2 0 9 10) ; "Sam, have you ever dated Sherry Moore?"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance samScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 10 0 self) ; "Hisss, bitch!"
			)
			(2
				(newsGuyHead setCycle: Beg)
				(don setCycle: Beg)
				(sam setCycle: End self)
			)
			(3
				(careyBeer
					init:
					signal: (| (careyBeer signal:) $4000)
					setPri: (+ (gEgo priority:) 1)
				)
				(sam setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(sam setLoop: 2 cel: 0 setCycle: CT 1 1 self)
				(samBeer init: signal: (| (samBeer signal:) $4000))
			)
			(5
				(sam setCycle: End self)
			)
			(6
				(sam view: 9105 setLoop: 1 cel: 0)
				(gMessager say: 8 0 2 0 self) ; "Here's the cold one I promised you, John. Enjoy."
			)
			(7
				(gGame handsOn:)
				(self dispose:)
				(ltBlock init: setScript: blockScr 0 60)
			)
		)
	)
)

(instance ltBlock of Actor
	(properties
		x 343
		y 146
		view 912
	)
)

(instance egoHead of Prop
	(properties
		view 9915
		loop 1
	)
)

(instance blockScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(if (gCurRoom script:)
					(self register: 5 init:)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(= register (Narrator modeless:))
				(Narrator modeless: 2)
				(egoHead
					init:
					x: (+ (gEgo x:) 12)
					y: (- (gEgo y:) 58)
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(ltBlock
					setCycle: Walk
					setLoop: 0 1
					setMotion: PolyPath 164 133 self
				)
			)
			(3
				(ltBlock
					view: 914
					setLoop: 0 1
					cel: 0
					x: (- (ltBlock x:) 14)
					setCycle: End
				)
				(gMessager say: 7 0 0 1 self) ; "Carey! The Mayor has requested your presence at a City Council meeting first thing tomorrow. I want you outta here tonight before you have too much to drink. I need you alert and articulate tomorrow!"
			)
			(4
				(ltBlock setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(5
				(ltBlock setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(6
				(ltBlock view: 913 x: (+ (ltBlock x:) 14) setLoop: 2 1)
				(= cycles 2)
				(Narrator modeless: register)
				(gEgo setScript: egoStandScr)
			)
			(7
				(ltBlock setLoop: 3 1)
				(= cycles 2)
			)
			(8
				(ltBlock setLoop: 1 1)
				(= cycles 2)
			)
			(9
				(ltBlock
					view: 912
					setLoop: 1 1
					setCycle: Walk
					setMotion: PolyPath 343 146 self
				)
			)
			(10
				(= gDay 4)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance egoStandScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoHead dispose:)
				(= cycles 2)
			)
			(1
				(gMessager say: 7 0 0 3 self) ; "I guess it's time to pack it in, guys. See you later."
			)
			(2
				(gEgo view: 9054 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					normalize: 9120
					y: (- (gEgo y:) 3)
					setScaler: Scaler 90 66 145 108
				)
				(= cycles 2)
			)
			(4
				(gEgo setMotion: PolyPath 193 136 self)
			)
			(5
				(= gDay 4)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance videoGame of Feature
	(properties
		noun 13
		approachX 287
		approachY 118
		approachDist 20
		x 304
		y 95
	)

	(method (init)
		(self
			createPoly: 319 102 286 97 286 72 293 64 291 35 319 33
			approachVerbs: 29 ; coins
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((and (OneOf theVerb 29 20 4) global170 0) ; coins, wallet, Do
				(gMessager say: 1 4 0 0 0 745) ; "Nothing happens, Detective. It must be broken or not be plugged in."
			)
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 29 20 4) ; coins, wallet, Do
				(if (gCast contains: kevLight)
					(gMessager say: noun theVerb 12 0)
				else
					(gGame handsOff:)
					(gCurRoom setScript: playSkimmerScr 0 theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance playSkimmerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf register 4 20)
					(gMessager say: 13 register 0 0 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (OneOf register 4 20)
					(gGame handsOn:)
					(self dispose:)
				else
					(gMessager say: 13 register 0 0 self)
				)
			)
			(2
				(gGlobalSound0 fade: 0 10 10 1)
				(gCurRoom drawPic: -1 0)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(3
				((gTheIconBar plane:) priority: -1)
				(gCurRoom newRoom: 41) ; skimmerRoom
			)
		)
	)
)

(instance videoGame2 of Feature
	(properties
		noun 19
		approachX 174
		approachY 110
		x 162
		y 95
	)

	(method (init)
		(self
			createPoly:
				147
				103
				175
				103
				176
				67
				174
				61
				175
				30
				180
				30
				180
				24
				148
				23
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((and (OneOf theVerb 29 20 4) global170 0) ; coins, wallet, Do
				(gMessager say: 1 4 0 0 0 745) ; "Nothing happens, Detective. It must be broken or not be plugged in."
			)
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 29 20 4) ; coins, wallet, Do
				(gGame handsOff:)
				(gCurRoom setScript: playStroidsScr 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance playStroidsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf register 4 20)
					(gMessager say: 19 register 0 0 self)
				else
					(gEgo view: 9126 setLoop: 3 cel: 0 setCycle: End self)
				)
			)
			(1
				(if (OneOf register 4 20)
					(gGame handsOn:)
					(self dispose:)
				else
					(gMessager say: 19 register 0 0 self)
				)
			)
			(2
				(gGlobalSound0 fade: 0 10 10 1)
				(gCurRoom drawPic: -1 0)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 2010)
			)
		)
	)
)

(instance tv of Feature
	(properties
		noun 21
		x 304
		y 95
	)

	(method (init)
		(self createPoly: 249 37 272 37 272 17 249 17)
		(super init: &rest)
	)
)

(instance stools of Feature
	(properties
		noun 20
		x 200
		y 100
	)

	(method (init)
		(self createPoly: 191 75 217 78 219 101 196 103 187 100)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(if (== gDay 3)
				(gMessager say: noun theVerb 10) ; "Why sit over there when your friends are here?"
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pretzels0 of Feature
	(properties
		noun 1
		approachX 98
		approachY 124
		x 98
		y 120
	)

	(method (init)
		(self createPoly: 93 81 104 81 104 86 93 86)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((gEgo has: 21) ; pretzels
					(gMessager say: noun theVerb 1) ; "You already have some pretzels. How many do you need?"
				)
				((== (gEgo view:) 9913)
					(gMessager say: noun theVerb 11) ; "Seated where you are, you can't reach those pretzels."
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: standPretzelScr 0 self)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pretzels1 of Feature
	(properties
		noun 1
		approachX 75
		approachY 124
		x 50
		y 126
	)

	(method (init)
		(self createPoly: 54 79 54 85 45 85 45 80)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((gEgo has: 21) ; pretzels
					(gMessager say: noun theVerb 1) ; "You already have some pretzels. How many do you need?"
				)
				((== (gEgo view:) 9913)
					(gGame handsOff:)
					(gCurRoom setScript: sitPretzelScr)
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: standPretzelScr 0 self)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pretzels2 of Feature
	(properties
		noun 1
		approachX 75
		approachY 124
		x 64
		y 103
	)

	(method (init)
		(self createPoly: 70 97 70 103 58 103 58 98)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(cond
				((gEgo has: 21) ; pretzels
					(gMessager say: noun theVerb 1) ; "You already have some pretzels. How many do you need?"
				)
				((== (gEgo view:) 9913)
					(gMessager say: noun theVerb 11) ; "Seated where you are, you can't reach those pretzels."
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: standPretzelScr 0 self)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pretzels3 of Feature
	(properties
		noun 1
		approachX 104
		approachY 147
		x 87
		y 129
	)

	(method (init)
		(self createPoly: 95 122 95 129 80 129 80 122)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(cond
				((gEgo has: 21) ; pretzels
					(gMessager say: noun theVerb 1) ; "You already have some pretzels. How many do you need?"
				)
				((== (gEgo view:) 9913)
					(gMessager say: noun theVerb 11) ; "Seated where you are, you can't reach those pretzels."
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: standPretzelScr 0 self)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance standPretzelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(Face gEgo register self)
			)
			(2
				(gEgo get: 21) ; pretzels
				(gGame points: 2 104)
				(gMessager say: 1 4 0 0) ; "You take a few pretzels."
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitPretzelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 9914 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gEgo view: 9913 cel: 0 get: 21) ; pretzels
				(gGame points: 2 104)
				(gMessager say: 1 4 0 0) ; "You take a few pretzels."
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftPic of Feature
	(properties
		noun 6
		x 50
		y 58
	)

	(method (init)
		(self createPoly: 26 38 74 38 74 58 26 58)
		(super init: &rest)
	)
)

(instance rightPic of Feature
	(properties
		noun 6
		x 105
		y 58
	)

	(method (init)
		(self createPoly: 83 39 129 39 129 58 83 58)
		(super init: &rest)
	)
)

(instance poolTable of Feature
	(properties
		noun 4
		approachX 221
		approachY 129
		x 273
		y 150
	)

	(method (init)
		(self createPoly: 319 155 218 153 204 103 276 95 319 103)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== gDay 3)
			(if (Message msgGET gCurRoomNum noun theVerb 10 1)
				(gMessager say: noun theVerb 10 0)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance poolBalls of Feature
	(properties
		noun 5
		approachX 221
		approachY 129
		x 273
		y 151
	)

	(method (init)
		(self
			createPoly:
				274
				101
				284
				103
				308
				112
				300
				126
				279
				116
				276
				109
				249
				113
				245
				110
				258
				101
				266
				100
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== gDay 3)
			(if (Message msgGET gCurRoomNum noun theVerb 10 1)
				(gMessager say: noun theVerb 10 0)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bartender of Prop
	(properties
		noun 16
		approachX 233
		approachY 111
		x 237
		y 74
		view 9102
		loop 1
		detailLevel 5
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(if (== gDay 3)
					(gMessager say: noun theVerb 10 0) ; "Refrain from hollering at Neal. People will think you're intoxicated."
				else
					(switch (++ local3)
						(1
							(gMessager say: noun theVerb 5 0) ; "Hello, Neal. How are you?"
						)
						(2
							(gMessager say: noun theVerb 6 0) ; "Things are tough, Neal."
						)
						(3
							(gMessager say: noun theVerb 7 0) ; "I'm going to solve this case, Neal. I know I can do it."
						)
						(4
							(gMessager say: noun theVerb 8 0) ; "You know, Neal, this case is solvable. There are leads and clues and somewhere amidst all this evidence is the key which will turn the lock."
						)
						(else
							(gMessager say: noun theVerb 9 0) ; "Kid, before you start... Lemme ask you a question. What are you doing here wasting your time when you've got a murderer to find?"
						)
					)
				)
			)
			((== gDay 3)
				(if (Message msgGET gCurRoomNum noun theVerb 10 1)
					(gMessager say: noun theVerb 10 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barGlass of View
	(properties
		view 9103
		loop 3
	)
)

(instance bartScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender view: 9102 setLoop: 1 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(if (> (Random 0 99) 50)
					(= state -1)
				)
				(= cycles 1)
			)
			(2
				(bartender view: 9103 setLoop: 0 cel: 0 setCycle: End self)
				(barGlass hide:)
			)
			(3
				(bartender setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(bartender setLoop: 0)
				(bartender cel: (bartender lastCel:) setCycle: Beg self)
			)
			(5
				(barGlass show:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

