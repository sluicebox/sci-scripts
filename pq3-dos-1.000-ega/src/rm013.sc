;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	[local3 10]
	[local13 10]
	local23
	[local24 17] = [{0.00} {0.01} {0.02} {0.03} {0.04} {0.05} {0.06} {0.07} {0.08} {0.09} {0.10} {0.11} {0.12} {0.13} {0.14} {0.15} 0]
	local41
	local42
	local43
	local44
)

(procedure (localproc_0 param1 &tmp [temp0 3])
	(if local41
		(Display 13 0 dsRESTOREPIXELS local41)
		(= local41 0)
	)
	(if param1
		(= local41 (Display param1 dsCOORD 57 158 dsALIGN alLEFT dsFONT 4 dsCOLOR 0 dsSAVEPIXELS))
	)
)

(procedure (localproc_1 param1)
	(if local41
		(Display 13 0 dsRESTOREPIXELS local41)
		(= local41 0)
	)
	(if param1
		(= local41 (Display param1 dsCOORD 220 123 dsALIGN alLEFT dsFONT 4 dsCOLOR global125 dsSAVEPIXELS))
	)
)

(instance rm013 of PQRoom
	(properties
		picture 13
	)

	(method (init)
		(super init:)
		(eDoor init:)
		(breath init:)
		(cabinets init:)
		(floorAndWalls init:)
		(phone init:)
		(towelDispenser init:)
		(mainMusic play:)
		(if (!= gPrevRoomNum 890) ; dilema
			(gEgo
				view: (if (> gDay 1) 4 else 0)
				setStep: 3 2
				setPri: 12
				posn: 100 173
				init:
			)
			(self
				setRegions: 891 ; station
				posn: 105 125
				setScript: (ScriptID 896 1) ; sWI
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 132 0 0 319 0 319 189 53 189 211 119 214 107 183 83 135 81 115 87 98 90 96 102 2 123 10 0
						yourself:
					)
			)
		else
			(HandsOn)
			(gEgo view: (if (> gDay 1) 4 else 0) setStep: 3 2 init:)
			(self
				setRegions: 891 ; station
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 132 0 0 319 0 319 189 53 189 211 119 214 107 183 83 135 81 115 87 93 93 91 103 2 123 10 0
						yourself:
					)
				setScript: callDispatch
			)
		)
		(cond
			((IsFlag 5)
				(bOfficer setScript: promptScript)
				(nut
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					posn: 95 168
					setPri: 12
					setMotion: MoveTo 80 98
					ignoreActors: 1
					init:
				)
				(if (not (gEgo has: 17)) ; knife
					(sStabbing play:)
				)
			)
			((IsFlag 16)
				(drunk
					setCycle: SyncWalk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					posn: 95 168
					setPri: 12
					setMotion: MoveTo 82 98
					init:
				)
			)
		)
		(bDoor init:)
		(bOfficer init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((not local1)
				(= local1 1)
				(drunk setPri: -1)
				(nut setPri: -1)
			)
			((and (or (IsFlag 16) (IsFlag 5)) (gEgo has: 1)) ; gun
				(HandsOff)
				(self setScript: fineHim)
			)
			((& (gEgo onControl: 0) $0002)
				(if (or (IsFlag 16) (IsFlag 5))
					(HandsOff)
					(gCurRoom setScript: goBack)
				else
					(self posn: 59 159 setScript: (ScriptID 896 2) 0 12) ; sWO
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance releaseSuspect of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bOfficer setScript: 0)
				(= save1 1)
				(obInset init:)
				(Say obInset 13 1) ; "Sooo... what are we booking this fine upstanding citizen on anyway?"
				(= seconds 6)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(= local42 0)
				(= cycles 5)
			)
			(2
				(gGame setCursor: 20)
				(touchPad init: self)
				(= local2 0)
				(StrCpy @local3 {})
				(self register: -1)
				(= cycles 1)
			)
			(3
				(cond
					((== local2 5)
						(= cycles 3)
					)
					((== register -1)
						(-= state 1)
						(= cycles 1)
					)
					((< register 10)
						(++ local2)
						(StrCat @local3 (Format @local13 13 2 register)) ; "%d"
						(localproc_1 @local3)
						(self register: -1)
						(-= state 1)
						(= cycles 1)
					)
				)
			)
			(4
				(localproc_1 0)
				(touchPad dispose:)
				(Animate (gCast elements:) 0)
				(cond
					(
						(or
							(not (StrCmp @local3 {05150}))
							(not (StrCmp @local3 {12025}))
						)
						(SetScore 112 1)
					)
					((== local42 2)
						(EgoDead 28) ; "You need to refer to your officer's manual for the proper codes."
					)
					(else
						(switch local42
							(0
								(Print 13 3) ; "Quit clowning around Bonds. Give me a real code."
							)
							(1
								(Print 13 4) ; "You sure about that Bonds? Better dust off that Officer's Manual and bone up on your codes."
							)
						)
						(++ local42)
						(= state 1)
					)
				)
				(= cycles 1)
			)
			(5
				(if (gEgo has: 23) ; license
					(= save1 1)
					(obInset init:)
					(Say obInset 13 5) ; "You got any ID on this guy Sonny?"
					(= seconds 4)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(6
				(= save1 1)
				(obInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 13 6) ; "Yea, here you go."
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gEgo put: 23 13) ; license
				(self setScript: getTheStuff self)
			)
			(8
				(HandsOff)
				(if (gEgo has: 17) ; knife
					(= save1 1)
					(obInset init:)
					(Say obInset 13 7) ; "Any personal effects?"
					(= seconds 4)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(9
				(= save1 1)
				(obInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 13 8) ; "One knife, concealed weapon."
				(= seconds 3)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gEgo put: 17 13) ; knife
				(self setScript: getTheStuff self)
			)
			(11
				(HandsOff)
				(gEgo setMotion: PolyPath 82 105 self)
				(bOfficer loop: 1 setCycle: End self)
			)
			(12
				(sFX number: 946 play:)
			)
			(13
				(Face gEgo bDoor)
				(bDoor setCycle: End self)
				(sFX number: 907 play:)
			)
			(14
				(nut setMotion: MoveTo 106 88 self)
			)
			(15
				(nut setMotion: MoveTo 99 76 self)
			)
			(16
				(bDoor setCycle: Beg self)
			)
			(17
				(sFX number: 908 play: self)
			)
			(18
				(nut setMotion: MoveTo 90 76)
				(bOfficer setCel: 13 setMotion: MoveTo 122 61 self)
			)
			(19
				(if
					(and
						(not (gEgo has: 17)) ; knife
						(not (== ((gInventory at: 17) owner:) 13)) ; knife
					)
					(sStabbing play:)
					(+= state 7)
					(= cycles 1)
				else
					(nut dispose:)
					(bOfficer setStep: 2 1 setMotion: MoveTo 90 61 self)
				)
				(sFX number: 136 play:)
			)
			(20
				(= seconds 5)
			)
			(21
				(sFX number: 137 play: self)
			)
			(22
				(bOfficer setCel: 0 x: 115 y: 40 setMotion: MoveTo 147 46 self)
			)
			(23
				(nut dispose:)
				(= save1 1)
				(obInset init:)
				(Say obInset 13 9) ; "I'm returning your cuffs here through the drop box. Don't forget 'em!"
				(= seconds 6)
			)
			(24
				(= local43 (= save1 1))
				(obInset init:)
				(Say obInset 13 10) ; "Say, Bonds. Officer Morales is requesting a supervisor for a refusal to sign."
				((gInventory at: 2) moveTo: 13) ; handcuff
				(= seconds 5)
			)
			(25
				(= save1 1)
				(Say obInset 13 11) ; "She's waiting out on the freeway near the 7th Avenue on ramp."
				(= seconds 6)
			)
			(26
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global127 1)
				(obInset dispose:)
				(HandsOn)
				(ClearFlag 5)
				(SetFlag 69)
				(= global105 15)
				(self dispose:)
			)
			(27
				(nut dispose:)
				(bOfficer dispose:)
				(attack setCycle: End self init:)
				(sStabbing fade:)
			)
			(28
				(stabbingSting play:)
				(attack x: 103 y: 58 loop: 1 cel: 0 setCycle: End self)
			)
			(29
				(= seconds 5)
			)
			(30
				(EgoDead 2) ; "He might not have been wearing much, but it's amazing where people can hide things. ALWAYS search your prisoners."
			)
		)
	)
)

(instance friskHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (- (nut x:) 15) (+ (nut y:) 9) self)
			)
			(1
				(gEgo
					normal: 0
					view: 285
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(sStabbing fade:)
			)
			(2
				(Print 13 12) ; "You find a knife concealed in the man's briefs. Good work!"
				(gEgo
					get: 17 ; knife
					normal: 1
					view: 0
					cel: 0
					cycleSpeed: (gEgo moveSpeed:)
					setCycle: Walk
					setMotion: PolyPath 88 111 self
				)
				(SetScore 108 5)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance removeCuffs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 93 103 self)
			)
			(1
				(Print 13 13) ; "You remove your cuffs from the drunk."
				(handcuffSnd play:)
				(drunk view: 231 setLoop: -1 loop: 4 setCycle: Walk)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance forgotPersonalEffects of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(obInset init:)
				(Say obInset 13 14) ; "You'd better have him dump out his pockets first."
				(= seconds 4)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(self setScript: putPersonalEffects self)
			)
			(2
				(HandsOff)
				(self setScript: inTheSlammer self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putPersonalEffects of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bOfficer setScript: 0)
				(gEgo setMotion: PolyPath 182 85 self)
			)
			(1
				(Face gEgo eDoor self)
			)
			(2
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 13 15) ; "Sir, please step over here and empty your pockets into this drawer."
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(Animate (gCast elements:) 0)
				(eDoor setCycle: End)
				(sFX number: 914 play: self)
			)
			(4
				(drunk setMotion: MoveTo 151 83 self)
			)
			(5
				(drunk view: 230 cel: 0 setCycle: End self)
				(sFX number: 916 play: self)
			)
			(6 0)
			(7
				(drunk
					view: 231
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 82 98 self
				)
				(eDoor setCycle: Beg)
				(sFX number: 915 play:)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inTheSlammer of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bOfficer setScript: 0)
				(= save1 1)
				(obInset init:)
				(Say obInset 13 1) ; "Sooo... what are we booking this fine upstanding citizen on anyway?"
				(= seconds 6)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(= cycles 5)
			)
			(2
				(gGame setCursor: 20)
				(touchPad init: self)
				(= local2 0)
				(StrCpy @local3 {})
				(self register: -1)
				(= cycles 1)
			)
			(3
				(cond
					((== local2 5)
						(= cycles 3)
					)
					((== register -1)
						(-= state 1)
						(= cycles 1)
					)
					((< register 10)
						(++ local2)
						(StrCat @local3 (Format @local13 13 2 register)) ; "%d"
						(localproc_1 @local3)
						(self register: -1)
						(-= state 1)
						(= cycles 1)
					)
				)
			)
			(4
				(localproc_1 0)
				(touchPad dispose:)
				(Animate (gCast elements:) 0)
				(cond
					(
						(or
							(not (StrCmp @local3 {23152}))
							(not (StrCmp @local3 {12951}))
						)
						(SetFlag 46)
						(SetScore 123 5)
					)
					((== local42 2)
						(EgoDead 28) ; "You need to refer to your officer's manual for the proper codes."
					)
					(else
						(switch local42
							(0
								(Print 13 3) ; "Quit clowning around Bonds. Give me a real code."
							)
							(1
								(Print 13 4) ; "You sure about that Bonds? Better dust off that Officer's Manual and bone up on your codes."
							)
						)
						(++ local42)
						(= state 1)
					)
				)
				(= cycles 1)
			)
			(5
				(gEgo setMotion: PolyPath 82 105 self)
				(bOfficer loop: 1 setCycle: End self)
			)
			(6
				(sFX number: 946 play:)
			)
			(7
				(Face gEgo bDoor)
				(bDoor setCycle: End self)
				(sFX number: 907 play:)
			)
			(8
				(drunk
					setLoop: (if (< (drunk x:) (bDoor x:)) 0 else 1)
					setMotion: MoveTo 106 88 self
				)
			)
			(9
				(drunk setLoop: 4 setMotion: MoveTo 99 76 self)
			)
			(10
				(bDoor setCycle: Beg self)
			)
			(11
				(sFX number: 908 play: self)
			)
			(12
				(bDoor stopUpd:)
				(drunk setMotion: MoveTo 90 72 self)
			)
			(13
				(drunk dispose:)
				(= seconds 5)
			)
			(14
				(bOfficer setCel: 0 x: 115 y: 40 setMotion: MoveTo 147 46 self)
			)
			(15
				(= save1 1)
				(obInset init:)
				(Say obInset 13 16) ; "Thanks, Sonny. Hope the rest of your patrol is less exciting."
				(= seconds 6)
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(HandsOn)
				(ClearFlag 16)
				(proc0_17 20)
				(self dispose:)
				(gCurRoom newRoom: 890) ; dilema
			)
		)
	)
)

(instance runTest of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 211 103 self)
			)
			(1
				(Animate (gCast elements:) 0)
				(sonnyInset init:)
				(Say sonnyInset 13 17) ; "Step over here, Sir. Now!"
				(drunk setLoop: 0 setMotion: PolyPath 209 116 self)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyMouth dispose:)
				(Animate (gCast elements:) 0)
				(drunk loop: 5 cel: 0)
				(User canInput: 1)
				(gGame setCursor: 20)
				(gTheIconBar enable: 2)
				(breathInset init:)
				(onSwitch cel: 0)
			)
			(3
				(localproc_0 0)
				(Animate (gCast elements:) 0)
				(breathInset dispose:)
				(= save1 1)
				(HandsOff)
				(sonnyInset init:)
				(Say sonnyInset 13 18) ; "I want you to blow as hard as you can into this tube."
				(= seconds 4)
			)
			(4
				(breathInset init:)
				(onSwitch cel: 1)
				(tube dispose:)
				(Animate (gCast elements:) 0)
				(localproc_0 [local24 local23])
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(Animate (gCast elements:) 0)
				(drunkInset setCycle: End self init:)
				(sFX number: 134 play:)
			)
			(5
				(self setScript: runDigits self)
			)
			(6
				(doneLight cel: 1)
				(= cycles 5)
			)
			(7
				(drunkInset cel: 0)
				(paper
					setMotion: MoveTo (paper x:) (- (paper y:) 15) self
					show:
				)
				(paperSound play:)
			)
			(8
				(drunkInset dispose:)
				(User canInput: 1)
				(gTheIconBar enable: 2 curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(9
				(localproc_0 0)
				(= seconds 3)
			)
			(10
				(breathInset dispose:)
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 13 19) ; "According to this, your blood alcohol level is .15. That is well over the legal limit. I'll have to book you."
				(= seconds 9)
			)
			(11
				(bOfficer setScript: promptScript)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(drunk setLoop: -1)
				(HandsOn)
				(gGame setCursor: 20)
				(gTheIconBar enable: 2)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(self dispose:)
			)
		)
	)
)

(instance runDigits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 [local24 local23])
				(= cycles 2)
			)
			(1
				(if (< local23 15)
					(++ local23)
					(= state -1)
					(= cycles 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance promptScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(HandsOff)
				(obInset init:)
				(Say obInset 13 20) ; "Well?.."
				(= seconds 3)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(HandsOn)
				(self init:)
			)
		)
	)
)

(instance fineHim of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(obInset init:)
				(Say obInset 13 21) ; "Bonds! You know better than to bring a prisoner in here without checking your gun first. That'll cost you a $2.50 fine."
				(= seconds 8)
			)
			(1
				(= save1 1)
				(Say obInset 13 22) ; "Put it here in the drop and you can get it back after you finished with the prisoner."
				(= seconds 6)
			)
			(2
				(Print 13 23) ; "You walk over, deposit your gun and grudgingly pay the $2.50 fine."
				(if (> ((gInventory at: 19) state:) 0) ; wallet
					((gInventory at: 19) state: (- ((gInventory at: 19) state:) 1)) ; wallet, wallet
				)
				(obInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo put: 1 13) ; gun
				(self setScript: getTheStuff self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getTheStuff of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 151 83 self)
			)
			(1
				(eDoor setCycle: End self)
				(sFX number: 914 play:)
			)
			(2
				(gEgo
					normal: 0
					view: 220
					cel: 0
					x: (+ (gEgo x:) 6)
					setCycle: End self
				)
				(sFX number: 916 play:)
			)
			(3
				(eDoor setCycle: Beg self)
				(sFX number: 915 play:)
			)
			(4
				(gEgo normal: 1 view: 0 x: (- (gEgo x:) 6) setCycle: Walk)
				(if local44
					(= save1 1)
					(obInset init:)
					(Say obInset 13 24) ; "You mean to tell me you fished that outta this guy's shorts? You've got some guts, Bonds."
					(= local44 0)
					(= seconds 7)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(obInset init:)
				(gEgo setMotion: 0)
				(Say obInset 13 25) ; "Hey Sonny, you want to book this guy?"
				(= seconds 4)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(gEgo setMotion: MoveTo 95 122 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance jailTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(obInset init:)
				(cond
					((or (IsFlag 5) (IsFlag 16))
						(switch (Random 0 2)
							(0
								(Say obInset 13 26) ; "Let's get this prisoner booked, Bonds."
							)
							(1
								(Say obInset 13 27) ; "Finish up and hand him over, Bonds."
							)
							(2
								(Say obInset 13 28) ; "I'm about ready for a break, Bonds. Let's hurry up and get this guy behind bars so I can eat my sandwich."
							)
						)
					)
					(local43
						(Say obInset 13 29) ; "I said I just got a message that you're to assist an officer on the freeway, Bonds. ASAP."
					)
					(else
						(switch (Random 0 2)
							(0
								(Say obInset 13 30) ; "You gonna go get me some bodies to lock up, or what?"
							)
							(1
								(Say obInset 13 31) ; "You on duty, Bonds? I got plenty of free cells to be filled up."
							)
							(2
								(Say obInset 13 32) ; "Go catch some criminals, Bonds. I'm getting lonely in here."
							)
						)
					)
				)
				(= seconds 6)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(obInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance callDispatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				((ScriptID 891 1) start: 1) ; briefMess
				((ScriptID 891 0) setScript: (ScriptID 891 1)) ; station, briefMess
				(self dispose:)
			)
		)
	)
)

(instance bOfficer of Actor
	(properties
		x 147
		y 46
		lookStr {Behind the protective glass is Officer Smith, the booking officer.}
		view 221
		loop 1
		signal 2048
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 13 33) ; "The booking officer can't help you unless you give him something to work with."
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: jailTalk)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 13 34) ; "Officer Bonds! It's extremely tacky to point your gun at a fellow officer, even in jest!"
					)
					(19 ; wallet
						(Print 13 35) ; "He already knows who you are! Geez!"
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nut of Actor
	(properties
		lookStr {You idly wonder if this guy will even make it through one night in the jail, or whether they'll ship him right out to the mental institute.}
		view 225
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(5 ; Talk
				(switch (= temp0 (Random 0 3))
					(0
						(Print 13 36) ; "Ah, tell it to your mother."
					)
					(1
						(Print 13 37) ; "I bet you like the strip search best of all."
					)
					(2
						(Print 13 38) ; "I hear a night stick is a cop's best friend."
					)
					(else
						(Print 13 39) ; "Just get on with it unless you want a puddle."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 13 40) ; "You're so close to handing him over to the jailer.  Surely you can hold your temper for another few minutes."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(if (or (gEgo has: 17) (== ((gInventory at: 17) owner:) 13)) ; knife, knife
					(Print 13 41) ; "You've already searched him - and you didn't enjoy it much the first time."
				else
					(HandsOff)
					(gCurRoom setScript: friskHim)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drunk of Actor
	(properties
		x 179
		y 72
		lookStr {You'll be glad when this prisoner's through booking and in a cell where he can sleep it off.}
		view 224
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 13 42) ; "How dry I am. How wet I'll be. If I don't find a place to p....."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 13 43) ; "You're so close to handing him over to the jailer. Surely you can hold your temper for another few minutes."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(if (not (gEgo has: 2)) ; handcuff
					(HandsOff)
					(gEgo get: 2) ; handcuff
					(gCurRoom setScript: removeCuffs)
				else
					(Print 13 44) ; "You've already removed his cuffs."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eDoor of Prop
	(properties
		x 165
		y 64
		description {chute}
		lookStr {You pass a prisoner's personal items in through the drop drawer.}
		view 220
		loop 1
		priority 3
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:) 0)
					((== ((gInventory at: 2) owner:) 13) ; handcuff
						(HandsOff)
						(gCurRoom setScript: getTheStuff)
						(Print 13 45) ; "You take your handcuffs."
						(gEgo get: 2) ; handcuff
						(if (== ((gInventory at: 1) owner:) 13) ; gun
							(Print 13 46) ; "You take your gun, embarrassed that you didn't check it outside."
							(gEgo get: 1) ; gun
						)
					)
					((IsFlag 5)
						(Print 13 47) ; "What do you wish to put in the drop?"
					)
					((and (IsFlag 16) (not local0))
						(if (gEgo has: 2) ; handcuff
							(HandsOff)
							(= local0 1)
							(gCurRoom setScript: putPersonalEffects)
							(SetScore 124 2)
						else
							(Print 13 48) ; "You'll have to take the cuffs off first."
						)
					)
					((== ((gInventory at: 1) owner:) 13) ; gun
						(HandsOff)
						(gCurRoom setScript: getTheStuff)
						(Print 13 46) ; "You take your gun, embarrassed that you didn't check it outside."
						(gEgo get: 1) ; gun
					)
					(else
						(Print 13 49) ; "You don't have anything to put in the drop."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; knife
						(HandsOff)
						(bOfficer setScript: 0)
						(= local44 1)
						(gEgo put: 17 13) ; knife
						(Print 13 50) ; "You put the suspect's knife into the drawer."
						(SetScore 110 2)
						(gCurRoom setScript: getTheStuff)
						(gTheIconBar curIcon: (gTheIconBar at: 0))
					)
					(23 ; license
						(HandsOff)
						(Print 13 51) ; "You put the suspect's license into the drawer."
						(bOfficer setScript: 0)
						((gInventory at: 23) state: 0) ; license
						(gEgo put: 23 0) ; license
						(SetScore 111 2)
						(gCurRoom setScript: getTheStuff)
						(gTheIconBar curIcon: (gTheIconBar at: 0))
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bDoor of Prop
	(properties
		x 93
		y 86
		lookStr {That door leads to the transfer holding cell. Once you walk through that door you're officially a prisoner of Lytton county until a judge decides otherwise.}
		view 227
		loop 1
		signal 16385
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:) 0)
					((IsFlag 5)
						(HandsOff)
						(gCurRoom setScript: releaseSuspect)
					)
					((IsFlag 16)
						(cond
							((not (gEgo has: 2)) ; handcuff
								(Print 13 48) ; "You'll have to take the cuffs off first."
							)
							((not local0)
								(HandsOff)
								(gCurRoom setScript: forgotPersonalEffects)
							)
							(else
								(HandsOff)
								(gCurRoom setScript: inTheSlammer)
							)
						)
					)
					(else
						(Print 13 52) ; "Only prisoners are allowed through that door."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance attack of Prop
	(properties
		x 104
		y 60
		view 228
		cycleSpeed 8
	)
)

(instance breath of Feature
	(properties
		description {intocilizer}
		onMeCheck 16384
		lookStr {The "Gas Chromatograph." This machine measures the blood alcohol content of breath samples.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 16)
						(cond
							((gCurRoom script:) 0)
							((IsFlag 68)
								(Print 13 53) ; "One test is enough."
							)
							((gEgo has: 2) ; handcuff
								(HandsOff)
								(SetFlag 68)
								(gCurRoom setScript: runTest)
							)
							(else
								(Print 13 54) ; "You need to remove his cuffs first."
							)
						)
					)
					((IsFlag 5)
						(Print 13 55) ; "There's no reason to test this guy. His problems run deeper than alcohol!"
					)
					(else
						(Print 13 56) ; "There's no one to test."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance breathInset of Prop
	(properties
		x 88
		y 188
		view 222
		priority 14
		signal 16401
	)

	(method (init)
		(onSwitch posn: (- (self x:) 39) (- (self y:) 9) init:)
		(paper posn: (- (self x:) 21) (- (self y:) 26) init: hide:)
		(topInset posn: (+ (self x:) 2) (- (self y:) 60) init:)
		(tube posn: (+ (self x:) 56) (self y:) init:)
		(doneLight posn: (+ (self x:) 38) (- (self y:) 7) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(onSwitch dispose:)
		(paper dispose:)
		(topInset dispose:)
		(tube dispose:)
		(doneLight dispose:)
		(drunkInset dispose:)
		(super dispose:)
	)
)

(instance topInset of Prop
	(properties
		view 222
		cel 1
		priority 13
		signal 16401
	)
)

(instance tube of Prop
	(properties
		view 222
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (onSwitch cel:) 1)
					(self hide:)
					(runTest cycles: 1)
				else
					(Print 13 57) ; "You need to turn the machine on first."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doneLight of Prop
	(properties
		view 222
		loop 3
		priority 15
		signal 16400
	)
)

(instance onSwitch of Prop
	(properties
		view 222
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (not cel)
					(self cel: 1 forceUpd:)
					(localproc_0 [local24 local23])
					(Print 13 58) ; "You turn on the Gas Chromatograph."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance paper of Actor
	(properties
		yStep 1
		view 222
		loop 4
		priority 13
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self dispose:)
				(runTest cycles: 1)
				(SetScore 122 5)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drunkInset of Prop
	(properties
		x 188
		y 109
		view 223
		priority 15
		signal 16401
	)
)

(instance obInset of Prop
	(properties
		x 51
		y 114
		view 226
		priority 15
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(obmInset x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(super init:)
	)

	(method (dispose)
		(obmInset dispose:)
		(super dispose:)
	)
)

(instance obmInset of Prop
	(properties
		x 51
		y 114
		view 226
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyInset of Prop
	(properties
		x 264
		y 107
		description {Sonny}
		view 25
		priority 14
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(sonnyMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
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
				(= seconds 4)
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
				(self init:)
			)
		)
	)
)

(instance cabinets of Feature
	(properties
		x 236
		y 80
		description {cabinets}
		onMeCheck 2048
		lookStr {A counter and storage cabinets line one wall of the booking room.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 13 59) ; "There's nothing except cleaning supplies and paper in the cabinets, none of which you need."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floorAndWalls of Feature
	(properties
		x 163
		y 22
		description {the room}
		onMeCheck 1024
		lookStr {The booking room is clean and sparsely furnished.}
	)
)

(instance phone of Feature
	(properties
		x 201
		y 43
		description {phone}
		onMeCheck 8192
		lookStr {A pay phone provides a means for outside calls.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 13 60) ; "You don't need to use the pay phone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance towelDispenser of Feature
	(properties
		x 224
		y 56
		description {towel dispenser}
		onMeCheck 4096
		lookStr {There's a towel dispenser for cleanups. It's not uncommon for prisoners to leave bodily fluids of one kind or another on the floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 13 61) ; "You don't need any paper towels at the moment."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance touchPad of Feature
	(properties)

	(method (init param1)
		(no1 init: param1)
		(no2 init: param1)
		(no3 init: param1)
		(no4 init: param1)
		(no5 init: param1)
		(no6 init: param1)
		(no7 init: param1)
		(no8 init: param1)
		(no9 init: param1)
		(no10 init: param1)
		(enterBox init: stopUpd:)
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
		(enterBox dispose:)
		(super dispose:)
	)
)

(instance no1 of keyPadBut
	(properties
		x 231
		y 150
		view 198
		loop 1
		cycleSpeed 0
		number 1
		keyEquiv 49
		soundNum 922
		playSound 1
	)
)

(instance no2 of keyPadBut
	(properties
		x 251
		y 150
		view 198
		loop 2
		cycleSpeed 0
		number 2
		keyEquiv 50
		soundNum 922
		playSound 1
	)
)

(instance no3 of keyPadBut
	(properties
		x 271
		y 150
		view 198
		loop 3
		cycleSpeed 0
		number 3
		keyEquiv 51
		soundNum 922
		playSound 1
	)
)

(instance no4 of keyPadBut
	(properties
		x 291
		y 150
		view 198
		loop 4
		cycleSpeed 0
		number 4
		keyEquiv 52
		soundNum 922
		playSound 1
	)
)

(instance no5 of keyPadBut
	(properties
		x 311
		y 150
		view 198
		loop 5
		cycleSpeed 0
		number 5
		keyEquiv 53
		soundNum 922
		playSound 1
	)
)

(instance no6 of keyPadBut
	(properties
		x 231
		y 165
		view 198
		loop 6
		cycleSpeed 0
		number 6
		keyEquiv 54
		soundNum 922
		playSound 1
	)
)

(instance no7 of keyPadBut
	(properties
		x 251
		y 165
		view 198
		loop 7
		cycleSpeed 0
		number 7
		keyEquiv 55
		soundNum 922
		playSound 1
	)
)

(instance no8 of keyPadBut
	(properties
		x 271
		y 165
		view 198
		loop 8
		cycleSpeed 0
		number 8
		keyEquiv 56
		soundNum 922
		playSound 1
	)
)

(instance no9 of keyPadBut
	(properties
		x 291
		y 165
		view 198
		loop 9
		cycleSpeed 0
		number 9
		keyEquiv 57
		soundNum 922
		playSound 1
	)
)

(instance no10 of keyPadBut
	(properties
		x 311
		y 165
		view 198
		cycleSpeed 0
		keyEquiv 48
		soundNum 922
		playSound 1
	)
)

(instance enterBox of Prop
	(properties
		x 257
		y 134
		view 198
		loop 10
		priority 15
		signal 17
	)
)

(instance sFX of Sound
	(properties)
)

(instance sStabbing of Sound
	(properties
		flags 1
		number 130
		loop -1
	)
)

(instance stabbingSting of Sound
	(properties
		number 131
	)
)

(instance catCalls of Sound ; UNUSED
	(properties
		flags 1
		number 133
		loop -1
	)
)

(instance paperSound of Sound
	(properties
		number 135
		loop 2
	)
)

(instance handcuffSnd of Sound
	(properties
		number 917
	)
)

(instance mainMusic of Sound
	(properties
		flags 1
		number 132
		loop -1
	)
)

