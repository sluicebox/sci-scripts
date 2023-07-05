;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use Language)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm050 0
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

(procedure (localproc_0 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(instance rm050 of PQRoom
	(properties
		lookStr {This place always gives you the creeps. Just the thought of all those dead bodies. Leon keeps it so damn cold in here.}
		picture 50
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 155 113 183 154 146 161 123 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 76 189 103 163 228 163 251 149 251 123 154 104 161 91 132 84 60 123 60 143
					yourself:
				)
		)
		(LoadMany rsVIEW 4 526 525 527 529 530 531 532)
		(super init:)
		(mCoroner play:)
		(coronerInset init: hide:)
		(door1 init:)
		(door2 init:)
		(door3 init:)
		(door4 init:)
		(door5 init:)
		(door6 init:)
		(door7 init:)
		(door8 init:)
		(pentagram init: hide:)
		(embalmMachine init:)
		(sink init:)
		(table init:)
		(lamps init:)
		(floor init:)
		(instruments init:)
		(vent init:)
		(skeleton init:)
		(cabinets init:)
		(bottles init:)
		(chart init:)
		(toeTagFeat init:)
		(toeTagInset init: hide:)
		(shadow init:)
		(if (not (IsFlag 176))
			(envelope init:)
		)
		(gEgo view: 4 posn: 1 1 setPri: 12 setStep: 3 2 init:)
		(HandsOff)
		(gCurRoom setScript: enterRoom 0 gEgo)
	)

	(method (doit)
		(cond
			(script)
			((localproc_0 gEgo 16384)
				(if (or (not local0) (not local2))
					(HandsOff)
					(gCurRoom setScript: canNotExit)
				else
					(gCurRoom setScript: exitRoom)
				)
			)
		)
		(super doit:)
	)
)

(instance canNotExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 95 150 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(cond
					((!= local0 1)
						(Print 50 0) ; "You decide to stick around until the coroner shows up."
						(HandsOn)
						(self dispose:)
					)
					((not (IsFlag 176))
						(Print 50 1) ; "Oh yeah, I almost forgot Rocklin's personal effects."
						(gCurRoom setScript: getEnvelope)
						(self dispose:)
					)
					(else
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance coronerWaits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= seconds 60)
			)
			(2 0)
			(3
				(HandsOff)
				(if local4
					(local5 setScript: closeDrawer self)
				else
					(= cycles 1)
				)
			)
			(4
				(if (gEgo onControl: 4096)
					(HandsOff)
					(gEgo setMotion: PolyPath 115 130 self)
				else
					(= seconds 1)
				)
			)
			(5
				(Face gEgo coroner)
				(= local3 1)
				(HandsOff)
				(gCurRoom setScript: enterRoom self coroner)
				(SetFlag 36)
			)
			(6
				(HandsOff)
				(gCurRoom setScript: coronerConversation)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== state 1) local6)
			(HandsOff)
			(self cue:)
		)
		(if (and (== state 2) (or (not local4) (and local4 (IsObject local5))))
			(HandsOff)
			(self cue:)
		)
		(super doit:)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local3 1)
					(mCoronerAppear play:)
					(= seconds 4)
				else
					(= cycles 2)
				)
			)
			(1
				(if (== local3 1)
					(sDoorCreak play:)
					(shadow
						setPri: 1
						ignoreActors: 1
						cel: 0
						cycleSpeed: 12
						setCycle: CT 6 1
					)
					(= seconds 10)
				else
					(roomSFX number: 907 play:)
					(shadow setPri: 1 ignoreActors: 1 setCycle: End self)
				)
			)
			(2
				(if (== local3 1)
					(shadow setCycle: End self)
				else
					(= ticks 1)
				)
				(mCoronerAppear stop:)
			)
			(3
				(sDoorClose play:)
				(= cycles 30)
			)
			(4
				(if (== local3 1)
					(mComicRelief loop: -1 play:)
					(= local3 0)
				else
					(= local1 1)
				)
				(register setPri: 12 posn: 55 189 setMotion: MoveTo 91 145 self)
			)
			(5
				(if (== local1 1)
					(= local1 0)
					(HandsOn)
				)
				(register ignoreActors: 0 setPri: -1)
				(shadow stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance coronerConversation of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coronerInset show: eat: self)
			)
			(1
				(Face gEgo coroner self)
			)
			(2
				(= save1 1)
				(coronerInset talk:)
				(Say coronerInset 50 2) ; "Well, if it isn't Sergeant 'B'. I hadda hunch you might show up."
				(= seconds 5)
			)
			(3
				(coronerInset mute:)
				(= cycles 3)
			)
			(4
				(= save1 1)
				(coronerInset talk:)
				(Say coronerInset 50 3) ; "You might find this amusing. I found it on your dead suspect. Looks like you have a fan."
				(= seconds 6)
			)
			(5
				(coronerInset mute:)
				(= cycles 3)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo get: 35) ; article
				(coronerInset mute: eat: self)
			)
			(7
				(pentagram show: stopUpd:)
				(= seconds 3)
			)
			(8
				(= save1 1)
				(Print 50 4 #at 15 150 #width 230) ; "With a sinking feeling, you recognize the old news article covering your promotion."
				(= cycles 1)
			)
			(9
				(= save1 1)
				(Print 50 5 #at 60 150) ; "A red marking pen pentagram mars your photograph."
				(= cycles 1)
			)
			(10
				(= save1 1)
				(coronerInset talk:)
				(Say coronerInset 50 6) ; "I wouldn't worry about it, Bonds. You look GOOD in red."
				(= seconds 5)
			)
			(11
				(coronerInset mute:)
				(= cycles 3)
			)
			(12
				(pentagram dispose:)
				(= cycles 3)
			)
			(13
				(= save1 1)
				(coronerInset talk:)
				(Say coronerInset 50 7) ; "Not to worry. I've got a positive I.D. on your stiff. Name's Steven Rocklin. Last known address is 500 West Peach."
				(= seconds 5)
			)
			(14
				(coronerInset mute:)
				(= cycles 3)
			)
			(15
				(= save1 1)
				(coronerInset talk:)
				(if (not (IsFlag 176))
					(Say coronerInset 50 8) ; "I've got all of Rocklin's belongings in an envelope over on the counter for you."
				else
					(Say coronerInset 50 9) ; "I see you found that manilla envelope I put out for you. The stuff in there was Rocklin's."
				)
				(= seconds 8)
			)
			(16
				(coronerInset mute:)
				(= cycles 3)
			)
			(17
				(coronerInset eat: self)
			)
			(18
				(= save1 1)
				(if (not (IsFlag 38))
					(coronerInset talk:)
					(Say coronerInset 50 10) ; "I found this under the fingernails of your murder victim, Andrew Dent. A little skin, a little hair...  Think of it as my gift to you."
					(gEgo get: 33) ; skinHair
					(= seconds 5)
				else
					(= cycles 1)
				)
			)
			(19
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(coronerInset talk:)
				(Say coronerInset 50 11) ; "Hey, drop by for lunch some time! I'll slice us up some fresh pastrami!"
				(= seconds 5)
			)
			(20
				(= save1 1)
				(Say coronerInset 50 12) ; "Hey, Bonds... you ok? You look a little green around the gills!"
				(= seconds 5)
			)
			(21
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(coronerInset dispose:)
				(coroner
					view: 529
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 20 130 self
				)
			)
			(22
				(coroner dispose:)
				(mComicRelief fade:)
				(sDoorCreak play: self)
			)
			(23
				(= local0 1)
				(mCoroner loop: -1 play:)
				(HandsOn)
				(sDoorClose play:)
				(self dispose:)
				(if (== gDay 6)
					(SetFlag 60)
				)
			)
		)
	)
)

(instance openDrawer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local4 1)
				(if (== (client drawerLevel:) 0)
					(= temp0 46)
				else
					(= temp0 27)
				)
				(gEgo
					setMotion:
						PolyPath
						(+ (client x:) 20)
						(+ (client y:) temp0)
						self
				)
			)
			(1
				(client open: 1 setCycle: End self)
				(gEgo
					view: 525
					normal: 0
					cycleSpeed: 7
					x: (- (gEgo x:) 7)
					y: (- (gEgo y:) 4)
					cel: 0
					setLoop: (client drawerLevel:)
					setCycle: CT 5 1 self
				)
				(sSlabOpen play:)
			)
			(2 0)
			(3
				(client loop: 2)
				(gEgo setCycle: CT 7 1 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(client cel: 1)
				(gEgo cel: 11)
				(= cycles 3)
			)
			(6
				(client cel: 2)
				(gEgo cel: 12)
				(= cycles 3)
			)
			(7
				(gEgo cel: 13)
				(= cycles 3)
			)
			(8
				(= local5 client)
				(toeTagInset show:)
				(HandsOn)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance closeDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(toeTagInset hide:)
				(gEgo setCycle: CT 7 -1 self)
				(client setCycle: Beg self)
				(sSlabClose play:)
			)
			(1
				(gEgo setCycle: Beg self)
				(client loop: 1 cel: (client lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo x: (+ (gEgo x:) 7) y: (+ (gEgo y:) 4))
				(NormalEgo 4 7)
				(client open: 0 stopUpd:)
				(= local4 0)
				(= local5 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 12 setMotion: PolyPath 52 185 self)
			)
			(1
				(shadow setCycle: Beg self)
				(roomSFX number: 907 play:)
			)
			(2
				(sDoorClose play:)
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance getEnvelope of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(gEgo setMotion: PolyPath 223 169 self)
			)
			(1
				(gEgo
					normal: 0
					view: 527
					posn: 231 160
					loop: 0
					cel: 0
					setPri: 14
					setCycle: CT 4 1 self
				)
			)
			(2
				(fileSound play:)
				(envelope dispose:)
				(gEgo setCycle: CT (gEgo lastCel:) 1 self)
			)
			(3
				(gEgo
					get: 11 ; envelope
					view: 4
					normal: 1
					posn: 223 169
					setLoop: 4
					setCel: 1
					setCycle: Walk self
				)
				(= save1 1)
				(NormalEgo 4 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance roomSFX of Sound
	(properties)
)

(instance mCoroner of Sound
	(properties
		flags 1
		number 500
		priority 14
		loop -1
	)
)

(instance mCoronerAppear of Sound
	(properties
		flags 1
		number 501
		priority 14
	)
)

(instance mComicRelief of Sound
	(properties
		flags 1
		number 502
		priority 14
		loop -1
	)
)

(instance mBodyLook of Sound ; UNUSED
	(properties
		flags 1
		number 503
		priority 14
	)
)

(instance mFindTag of Sound ; UNUSED
	(properties
		flags 1
		number 504
		priority 14
	)
)

(instance sSlabOpen of Sound
	(properties
		number 505
		priority 15
	)
)

(instance sSlabClose of Sound
	(properties
		number 506
		priority 15
	)
)

(instance sAirConditioner of Sound ; UNUSED
	(properties
		number 507
		priority 15
	)
)

(instance sWaterDrip of Sound ; UNUSED
	(properties
		number 508
		priority 15
	)
)

(instance sDoorCreak of Sound
	(properties
		number 509
		priority 15
	)
)

(instance sDoorClose of Sound
	(properties
		number 908
	)
)

(instance fileSound of Sound
	(properties
		number 232
	)
)

(class coronerInset of Prop
	(properties
		x 267
		y 127
		sightAngle 90
		view 530
		priority 14
		signal 16
		cycleSpeed 12
	)

	(method (init)
		(mouthInset cycleSpeed: cycleSpeed posn: x y init: hide:)
		(coroner
			setCycle: Walk
			setScript: coronerWaits
			posn: 62 220
			setPri: 12
			setStep: 2 1
			init:
		)
		(super init:)
	)

	(method (hide)
		(mouthInset hide:)
		(super hide:)
	)

	(method (talk)
		(self setCel: (self lastCel:))
		(mouthInset show: setCycle: RandCycle)
	)

	(method (mute)
		(self cel: 0)
		(mouthInset hide: setCycle: 0)
	)

	(method (eat param1)
		(self cel: 0 setCycle: End param1)
		(coroner view: 528 setLoop: 1 cel: 0 setCycle: CT 4 1)
	)
)

(class Drawer of Prop
	(properties
		view 531
		loop 1
		signal 16385
		open 0
		toeStr 0
		corpseType 0
		drawerLevel 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if open
					(switch corpseType
						(0
							(Print 50 13) ; "Nope. Nobody you know. There's a toe tag, though."
						)
						(1
							(Print 50 14) ; "Nope. Nobody you know. There's a toe tag, though."
						)
						(2
							(Print 50 15) ; "You notice a toe tag."
						)
						(3
							(Print 50 16) ; "This corpse's feet look particularly unattractive. You notice a toe tag."
						)
					)
				else
					(Print 50 17) ; "The drawers store bodies. You wonder if there's anyone you know in there."
				)
			)
			(5 ; Talk
				(if open
					(Print 50 18) ; "I'm starting to worry about you Bonds."
				)
			)
			(3 ; Do
				(if (and open local4)
					(HandsOff)
					(self setScript: closeDrawer)
				)
				(if (and (not open) (not local4))
					(HandsOff)
					(self setScript: openDrawer)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mouthInset of Prop
	(properties
		sightAngle 90
		view 530
		loop 1
		priority 15
		signal 16
	)
)

(instance shadow of Prop
	(properties
		x 90
		y 159
		view 531
		cel 11
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(floor doVerb: theVerb invItem)
	)
)

(instance coroner of Actor
	(properties
		view 529
		loop 5
		signal 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 50 19) ; "Leon Mandel is the County Coroner. It's rare to see him without something or other in his mouth. He's a little strange, but you've come to appreciate his sense of humor."
			)
			(5) ; Talk
			(3 ; Do
				(Print 50 20) ; "Leon's not about to share his sandwich."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 50 21) ; "Nah. He might enjoy it."
					)
					(7 ; camera
						(Print 50 22) ; "Hey, you want a picture? I'll send you an autographed one. Me in my polka dot swim trunks. No problem."
					)
					(33 ; skinHair
						(Print 50 23) ; "Whaddaya want from me, a medal? Your evidence boys down at the station have the time and equipment for all that lab analysis stuff. Me, I'm busy enough with just the stiffs."
					)
					(11 ; envelope
						(Print 50 24) ; "Better hang on to it!"
					)
					(2 ; handcuff
						(Print 50 25) ; "Nah. He might enjoy it."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toeTagInset of View
	(properties
		x 265
		y 111
		view 526
		priority 15
		signal 16657
	)

	(method (doVerb theVerb invItem)
		(toeTagFeat doVerb: theVerb invItem)
	)
)

(instance envelope of View
	(properties
		x 245
		y 158
		view 527
		loop 1
		priority 13
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== local4 0)
					(gCurRoom setScript: getEnvelope)
					(SetScore 176 2)
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Look
				(Print 50 26) ; "There's a large manilla envelope on the counter."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pentagram of View
	(properties
		x 80
		y 120
		view 532
		priority 15
		signal 16
	)
)

(instance door1 of Drawer
	(properties
		x 60
		y 75
		toeStr {Deedee Suffermuch}
		corpseType 1
	)
)

(instance door2 of Drawer
	(properties
		x 60
		y 94
		toeStr {Jason Harper}
		drawerLevel 1
	)
)

(instance door3 of Drawer
	(properties
		x 76
		y 68
		toeStr {Steven Rocklin}
		corpseType 3
	)
)

(instance door4 of Drawer
	(properties
		x 76
		y 87
		toeStr {Diane Goadahevin}
		corpseType 1
		drawerLevel 1
	)
)

(instance door5 of Drawer
	(properties
		x 92
		y 61
		toeStr {Philip Ness}
	)
)

(instance door6 of Drawer
	(properties
		x 92
		y 80
		toeStr {Ted N. Burried}
		corpseType 1
		drawerLevel 1
	)
)

(instance door7 of Drawer
	(properties
		x 107
		y 53
		toeStr {Andrew Dent}
		corpseType 2
	)
)

(instance door8 of Drawer
	(properties
		x 107
		y 72
		toeStr {Patrick Palmer}
		drawerLevel 1
	)
)

(instance floor of Feature
	(properties
		description {floor}
		onMeCheck 20482
		lookStr {The tiled floor is freshly cleaned and waxed.}
	)
)

(instance cabinets of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 27) ; "Knowing what a strange individual Leon is, you decide to stay out of his cabinets."
			)
			(2 ; Look
				(Print 50 28) ; "Leon certainly has a lot of storage space in here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chart of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 29) ; "Even if Leon GAVE you that chart, you wouldn't take it."
			)
			(2 ; Look
				(Print 50 30) ; "You'd rather not look at that chart on the wall. You see enough of that stuff at accident scenes."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottles of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 31) ; "You don't have much call for embalming fluid, Sergeant."
			)
			(2 ; Look
				(Print 50 32) ; "The bottles contain embalming fluid."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 33) ; "There'll be time enough for you to be on the table when you're dead."
			)
			(2 ; Look
				(Print 50 34) ; "The sight of the cold, stainless steel autopsy table sends a chill through the spine as you recall the many times you've come close to ending up on one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance instruments of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 35) ; "This isn't "Life & Death". There's a REASON you didn't go into forensics. Just looking at those instruments makes you queasy."
			)
			(2 ; Look
				(Print 50 36) ; "A number of cruel-looking stainless steel instruments lie on a towel on the counter."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lamps of Feature
	(properties
		description {lamps}
		onMeCheck 4
		lookStr {The office lamps give off bright, clinical-looking light.}
	)
)

(instance vent of Feature
	(properties
		description {vent}
		onMeCheck 8
		lookStr {The air vent circulates the air in the office. Nevertheless, it always smells like formaldehyde in here.}
	)
)

(instance skeleton of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 37) ; "You'd better leave "Demi" alone. You know how Leon is about his bones."
			)
			(2 ; Look
				(Print 50 38) ; "That's Leon's 'girlfriend', Demi Bones."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toeTagFeat of Feature
	(properties
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local4
					(switch (local5 corpseType:)
						(0
							(if 1
								(= global186
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(= global192
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(StrSplitInTwo global186 global192 (local5 toeStr:))
								(Printf 50 39 global186 global192) ; "The toe tag reads "%s"."
								(Memory memFREE global186)
								(Memory memFREE global192)
							)
						)
						(1
							(if 1
								(= global186
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(= global192
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(StrSplitInTwo global186 global192 (local5 toeStr:))
								(Printf 50 39 global186 global192) ; "The toe tag reads "%s"."
								(Memory memFREE global186)
								(Memory memFREE global192)
							)
							(Printf 50 40) ; "Good old Leon. He has so much fun naming the John Does."
						)
						(2
							(if 1
								(= global186
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(= global192
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(StrSplitInTwo global186 global192 (local5 toeStr:))
								(Printf 50 41 global186 global192) ; "The toe tag reads "%s" - the poor stiff you found in the alley."
								(Memory memFREE global186)
								(Memory memFREE global192)
							)
						)
						(3
							(if 1
								(= global186
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(= global192
									(Memory memALLOC_CRIT (StrLen (local5 toeStr:)))
								)
								(StrSplitInTwo global186 global192 (local5 toeStr:))
								(Printf 50 39 global186 global192) ; "The toe tag reads "%s"."
								(Memory memFREE global186)
								(Memory memFREE global192)
							)
							(mCoroner stop:)
							(roomSFX number: 504 loop: 1 flags: 1 play:)
							(Printf 50 42) ; "Underneath the name is a note: "Bonds - Caught you peeking! Stepped out for a bite. Be back soon - Leon.""
							(= local6 1)
						)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance sink of Feature
	(properties
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 43) ; "This place does have a way of making you want to wash your hands, doesn't it?"
			)
			(2 ; Look
				(Print 50 44) ; "The Coroner's office is equipped with a sink. You hate to think about what washes down those drains!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance embalmMachine of Feature
	(properties
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 50 45) ; "I don't think Leon would appreciate your playing with his toys."
			)
			(2 ; Look
				(Print 50 46) ; "The embalming machine is a kind of mechanical vampire. Out with the old, in with the new..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

