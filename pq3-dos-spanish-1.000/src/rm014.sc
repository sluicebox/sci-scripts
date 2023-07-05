;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm014 0
)

(local
	local0
	local1
	local2
	local3
	[local4 6]
)

(instance rm014 of PQRoom
	(properties
		picture 14
	)

	(method (init)
		(gEgo
			view: (if (> gDay 1) 4 else 0)
			setStep: 3 2
			posn: 48 142
			init:
		)
		(inBasket init:)
		(clerk init:)
		(desk init:)
		(bookingRoom init:)
		(= local2 1)
		(self
			setRegions: 891 ; station
			posn: 88 119
			setScript: (ScriptID 896 1) ; sWI
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 90 88 0 121 0 0 319 0 319 189 246 189 90 189 90 169 181 147 105 89
					yourself:
				)
		)
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(self posn: 48 142 setScript: (ScriptID 896 2) 0 12) ; sWO
			)
		)
		(super doit:)
	)
)

(instance depositScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 130 116 self)
			)
			(1
				(gEgo normal: 0 view: 210 cel: 0 setCycle: End self)
				(soundFX init: play:)
			)
			(2
				(if (not local2)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gEgo normal: 1 view: 4 loop: 0 setCycle: Walk)
				(insetO init:)
				(headO cel: 0 setCycle: End self)
			)
			(4
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 0) ; "What case number, Sonny?"
				(= seconds 4)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(if (and (not (IsFlag 87)) (or (== local0 3) (== local0 4)))
					(self setScript: newCase self)
				else
					(self setScript: enterCase self)
				)
			)
			(6
				(switch local0
					(1
						(SetFlag 75)
						(= global142 local3)
					)
					(2
						(SetFlag 76)
						(= global141 local3)
					)
					(3
						(= global143 local3)
						(= global150 1)
					)
					(4
						(= global144 local3)
					)
					(5
						(= global145 local3)
					)
					(6
						(= global146 local3)
					)
					(7
						(= global147 local3)
					)
					(8
						(= global148 local3)
					)
					(9
						(= global149 local3)
					)
				)
				(insetO init:)
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 1) ; "Name?"
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(sonnyInset init:)
				(= save1 1)
				(if (== local0 6)
					(Say sonnyInset 14 2) ; "Unknown source."
				else
					(switch local3
						(1
							(Say sonnyInset 14 3) ; "Samuel Britt."
						)
						(2
							(Say sonnyInset 14 4) ; "Clifford Jones."
						)
						(3
							(Say sonnyInset 14 5) ; "Marie Bonds."
						)
						(4
							(Say sonnyInset 14 6) ; "Andrew Dent."
						)
						(else
							(Say sonnyInset 14 7) ; "John Doe."
						)
					)
				)
				(= seconds 3)
			)
			(8
				(sonnyInset dispose:)
				(insetO init:)
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 8) ; "Description of evidence?"
				(= seconds 3)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(sonnyInset init:)
				(= save1 1)
				(switch local0
					(1
						(Say sonnyInset 14 9) ; "Broken neck chain."
					)
					(2
						(Say sonnyInset 14 10) ; "Bronze Star."
					)
					(3
						(if (IsFlag 2)
							(Say sonnyInset 14 11) ; "Gold paint transfer."
						else
							(Say sonnyInset 14 12) ; "Light red paint transfer."
						)
					)
					(4
						(Say sonnyInset 14 13) ; "Skin and hair samples."
					)
					(5
						(Say sonnyInset 14 14) ; "Personal photo."
					)
					(6
						(Say sonnyInset 14 15) ; "Blood and hair samples."
					)
					(7
						(Say sonnyInset 14 16) ; "Insignia Ring."
					)
					(8
						(Say sonnyInset 14 17) ; "Cult book."
					)
					(9
						(Say sonnyInset 14 18) ; "White paint sample."
					)
				)
				(= seconds 3)
			)
			(10
				(sonnyInset dispose:)
				(insetO init:)
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 19) ; "Location found?"
				(= seconds 3)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(sonnyInset init:)
				(= save1 1)
				(switch local0
					(1
						(Say sonnyInset 14 20) ; "Clutched in victim's right hand."
					)
					(2
						(Say sonnyInset 14 21) ; "Scene of attack - mall parking lot."
					)
					(3
						(Say sonnyInset 14 22) ; "Left rear quarter panel of abandoned 1973 Ford Pinto."
					)
					(4
						(Say sonnyInset 14 23) ; "Under victim's fingernails."
					)
					(5
						(Say sonnyInset 14 24) ; "Burned-out house, 500 block West Peach."
					)
					(6
						(Say sonnyInset 14 24) ; "Burned-out house, 500 block West Peach."
					)
					(7
						(Say sonnyInset 14 25) ; "Left hand, murder suspect Steve Rocklin."
					)
					(8
						(Say sonnyInset 14 26) ; "On body of murder suspect Steve Rocklin."
					)
					(9
						(Say sonnyInset 14 27) ; "Left rear quarter panel of 1976 GTO."
					)
				)
				(= seconds 4)
			)
			(12
				(sonnyInset dispose:)
				(insetO init:)
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 28) ; "And disposition?"
				(= seconds 3)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(sonnyInset init:)
				(= save1 1)
				(cond
					((== 9 local0)
						(Say sonnyInset 14 29) ; "Analyze for possible match to with paint transfer in case #199145."
					)
					((== 3 local0)
						(Say sonnyInset 14 30) ; "Analyze for possible vehicle type."
					)
					((or (== 4 local0) (== 6 local0))
						(Say sonnyInset 14 31) ; "Analyze for DNA profile."
					)
					(else
						(Say sonnyInset 14 32) ; "Secure as evidence."
					)
				)
				(= seconds 3)
			)
			(14
				(= local2 0)
				(clerk setScript: clerkScript)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gTheIconBar enable:)
				(= local0 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance newCase of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 4)
				(SetFlag 87)
				(sonnyInset init:)
				(= save1 1)
				(Say sonnyInset 14 33) ; "This is a new case Gibbs. I need a new number."
				(= seconds 5)
			)
			(1
				(sonnyInset dispose:)
				(insetO init:)
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 34) ; "Ok Sonny, the next number is 199145."
				(= seconds 4)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance clerkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setCycle: End self)
			)
			(1
				(clerk setLoop: 2 setCycle: Walk setMotion: MoveTo 217 68 self)
			)
			(2
				(= seconds 5)
			)
			(3
				(clerk setLoop: 3 setMotion: MoveTo 182 98 self)
			)
			(4
				(clerk loop: 0 cel: 0)
				(self dispose:)
				(= local2 1)
			)
		)
	)
)

(instance boTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(insetO init:)
				(headO cel: 0 setCycle: End self)
			)
			(1
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(switch (Random 0 4)
					(0
						(Say insetO 14 35) ; "You got something to drop off or are you just here for the show?"
					)
					(1
						(Say insetO 14 36) ; "Yes, Sergeant? Can I do something for you?"
					)
					(2
						(Say insetO 14 37) ; "If you haven't got something for me, Bonds, do you mind clearing the path for officers that do?"
					)
					(3
						(Say insetO 14 38) ; "Are you here to book some evidence or are you just lost?"
					)
					(else
						(Say insetO 14 39) ; "If you don't want to make a 'deposit', Bonds, why the hell are you here?"
					)
				)
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(headO cel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterCase of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(User canInput: 1)
				(User mapKeyToDir: 0)
				(touchPad init: self)
				(= local1 0)
				(StrCpy @local4 {})
				(= cycles 2)
				(= register -1)
				(gGame setCursor: 20)
			)
			(1
				(cond
					((== local1 6)
						0
						(= cycles 5)
					)
					((== register -1)
						(= state 0)
						(= cycles 1)
					)
					((< register 11)
						(++ local1)
						(StrCat @local4 (Format @temp0 14 40 register)) ; "%d"
						(= register -1)
						(= state 0)
						(= cycles 1)
					)
				)
			)
			(2
				(cond
					((not (StrCmp @local4 {199124}))
						(= local3 1)
					)
					((not (StrCmp @local4 {199137}))
						(= local3 2)
					)
					((not (StrCmp @local4 {199144}))
						(= local3 3)
					)
					((not (StrCmp @local4 {199145}))
						(= local3 4)
					)
					(else
						(= local3 0)
					)
				)
				(touchPad dispose:)
				(if (== local3 -1)
					(= cycles 2)
				else
					(User mapKeyToDir: 1)
					(Animate (gCast elements:) 0)
					(self dispose:)
				)
			)
			(3
				(Print 14 41) ; "Invalid Entry."
				(self init:)
			)
		)
	)
)

(instance showBadge of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(insetO init:)
				(headO cel: 0 setCycle: End self)
			)
			(1
				(headO stopUpd:)
				(mouthO setCycle: RandCycle show:)
				(= save1 1)
				(Say insetO 14 42) ; "I KNOW who you are, Sergeant Bonds. Quit being a wiseass."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetO dispose:)
				(headO cel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clerk of Actor
	(properties
		x 182
		y 98
		description {evidence officer}
		view 212
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 14 43) ; "Officer Martha Gibbs has been the Evidence Officer for two years."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 14 44) ; "You could try it, but it would only get you suspended REAL fast."
					)
					(19 ; wallet
						(HandsOff)
						(gCurRoom setScript: showBadge)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(Print 14 45) ; "If you want to give Officer Gibbs something, use the evidence deposit slot."
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: boTalk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 166
		y 73
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 14 46) ; "That stuff belongs to Officer Gibbs' and is of no concern to you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookingRoom of Feature
	(properties
		x 166
		y 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 14 47) ; "This is Evidence Lockup. Physical evidence is deposited here for analysis and safekeeping."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBasket of Feature
	(properties
		x 166
		y 73
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 14 48) ; "This slot is where you put items you wish to check into Evidence."
			)
			(3 ; Do
				(Print 14 49) ; "Just put something in it."
			)
			(4 ; Inventory
				(if
					(or
						(== invItem 29) ; necklace
						(== invItem 32) ; bronzeStar
						(== invItem 31) ; goldPaint
						(== invItem 30) ; whitePaint
						(== invItem 33) ; skinHair
						(== invItem 6) ; photo
						(== invItem 41) ; bloodHair
						(== invItem 34) ; cultRing
						(== invItem 25) ; cultBook
					)
					(switch invItem
						(29 ; necklace
							(gEgo put: 29 14) ; necklace
							(= local0 1)
							(proc0_17 10)
						)
						(32 ; bronzeStar
							(gEgo put: 32 14) ; bronzeStar
							(= local0 2)
							(SetScore 132 5)
							(proc0_17 10)
						)
						(31 ; goldPaint
							(gEgo put: 31 14) ; goldPaint
							(= local0 3)
							(SetScore 154 5)
							(proc0_17 10)
						)
						(33 ; skinHair
							(gEgo put: 33 14) ; skinHair
							(= local0 4)
							(SetScore 155 5)
							(proc0_17 10)
						)
						(6 ; photo
							(gEgo put: 6 14) ; photo
							(= local0 5)
							(proc0_17 10)
						)
						(41 ; bloodHair
							(gEgo put: 41 14) ; bloodHair
							(= local0 6)
							(proc0_17 10)
						)
						(34 ; cultRing
							(gEgo put: 34 14) ; cultRing
							(= local0 7)
							(proc0_17 10)
						)
						(25 ; cultBook
							(gEgo put: 25 14) ; cultBook
							(= local0 8)
							(proc0_17 10)
						)
						(30 ; whitePaint
							(gEgo put: 30 14) ; whitePaint
							(= local0 9)
							(proc0_17 10)
						)
					)
					(HandsOff)
					(gCurRoom setScript: depositScript)
				else
					(Print 14 50) ; "Evidence doesn't want that."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance insetO of Prop
	(properties
		x 265
		y 189
		view 211
		priority 13
		signal 16400
	)

	(method (init)
		(headO x: (+ (self x:) 1) y: (self y:) z: 26 init:)
		(mouthO x: (self x:) y: (self y:) z: 44 init: hide:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(headO dispose:)
		(mouthO dispose:)
		(super dispose:)
	)
)

(instance headO of Prop
	(properties
		view 211
		loop 1
		priority 14
		signal 16401
	)
)

(instance mouthO of Prop
	(properties
		view 211
		loop 2
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance touchPad of View
	(properties
		x 105
		y 45
		view 90
		priority 14
		signal 16
	)

	(method (init param1)
		(no1 cel: 0 x: (+ (self x:) 21) y: (+ (self y:) 17) init: param1)
		(no2 cel: 0 x: (+ (self x:) 31) y: (+ (self y:) 17) init: param1)
		(no3 cel: 0 x: (+ (self x:) 41) y: (+ (self y:) 17) init: param1)
		(no4 cel: 0 x: (+ (self x:) 21) y: (+ (self y:) 27) init: param1)
		(no5 cel: 0 x: (+ (self x:) 31) y: (+ (self y:) 27) init: param1)
		(no6 cel: 0 x: (+ (self x:) 41) y: (+ (self y:) 27) init: param1)
		(no7 cel: 0 x: (+ (self x:) 21) y: (+ (self y:) 37) init: param1)
		(no8 cel: 0 x: (+ (self x:) 31) y: (+ (self y:) 37) init: param1)
		(no9 cel: 0 x: (+ (self x:) 41) y: (+ (self y:) 37) init: param1)
		(no10 cel: 0 x: (+ (self x:) 31) y: (+ (self y:) 47) init: param1)
		(super init:)
	)

	(method (dispose)
		(no1 dispose:)
		(no2 dispose:)
		(no3 dispose:)
		(no4 dispose:)
		(no5 dispose:)
		(no6 dispose:)
		(no7 dispose:)
		(no8 dispose:)
		(no9 dispose:)
		(no10 dispose:)
		(super dispose:)
	)
)

(instance no1 of keyPadBut
	(properties
		view 90
		loop 1
		number 1
		keyEquiv 49
		soundNum 922
		playSound 1
	)
)

(instance no2 of keyPadBut
	(properties
		view 90
		loop 2
		number 2
		keyEquiv 50
		soundNum 922
		playSound 1
	)
)

(instance no3 of keyPadBut
	(properties
		view 90
		loop 3
		number 3
		keyEquiv 51
		soundNum 922
		playSound 1
	)
)

(instance no4 of keyPadBut
	(properties
		view 90
		loop 4
		number 4
		keyEquiv 52
		soundNum 922
		playSound 1
	)
)

(instance no5 of keyPadBut
	(properties
		view 90
		loop 5
		number 5
		keyEquiv 53
		soundNum 922
		playSound 1
	)
)

(instance no6 of keyPadBut
	(properties
		view 90
		loop 6
		number 6
		keyEquiv 54
		soundNum 922
		playSound 1
	)
)

(instance no7 of keyPadBut
	(properties
		view 90
		loop 7
		number 7
		keyEquiv 55
		soundNum 922
		playSound 1
	)
)

(instance no8 of keyPadBut
	(properties
		view 90
		loop 8
		number 8
		keyEquiv 56
		soundNum 922
		playSound 1
	)
)

(instance no9 of keyPadBut
	(properties
		view 90
		loop 9
		number 9
		keyEquiv 57
		soundNum 922
		playSound 1
	)
)

(instance no10 of keyPadBut
	(properties
		view 90
		loop 10
		keyEquiv 48
		soundNum 922
		playSound 1
	)
)

(instance sonnyInset of Prop
	(properties
		x 64
		y 117
		description {Sonny}
		view 25
		priority 14
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(sonnyMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(sonnyClothes x: (+ (self x:) 3) y: (+ (self y:) 61))
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(if (> gDay 1)
			(sonnyClothes init:)
		)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
		(sonnyClothes dispose:)
		(sonnyEyes setScript: 0 dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 2)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sonnyClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 17
	)
)

(instance soundFX of Sound
	(properties
		number 916
	)
)

