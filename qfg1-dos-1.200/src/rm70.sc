;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n104)
(use n106)
(use Interface)
(use LoadMany)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm70 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 8]
	[local13 8] = [62 119 91 145 134 104 75 40]
	[local21 8] = [109 108 108 107 101 98 97 101]
	[local29 5]
	[local34 5] = [74 143 52 90 110]
	[local39 5] = [109 120 122 99 108]
	[local44 5] = [1 11 6 5 8]
	[local49 5] = [14 2 10 15 12]
	[local54 5]
	[local59 5]
	[local64 5]
	local69
	[local70 5] = [35 250 265 140 225]
	[local75 5] = [30 35 125 50 45]
	local80
	local81
	local82
	local83
	local84
	local85 = 137
	local86 = 137
	local87
	local88
	local89 = -1
	local90
	local91 = 13
	local92 = 22
	local93 = 32
	local94 = 38
	local95 = 47
	local96 = 59
	local97 = 69
	local98 = 78
	local99 = 100
	local100 = 104
	local101 = 113
	local102 = 121
	local103 = 128
	local104 = 135
	local105 = 141
	local106 = 151
	local107
	local108
	local109
	local110
	local111
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local54 temp0] (aFaeryWindow new:))
		(if (< global211 8)
			([local54 temp0] color: 0 back: 15)
		else
			([local54 temp0] color: [local44 temp0] back: [local49 temp0])
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= local2 [local54 (Random 0 4)])
	(= temp0 (Random 5 210))
	(= temp1
		(if (< (gEgo y:) 140)
			(Random (gEgo y:) 140)
		else
			(Random 5 (- (gEgo y:) 80))
		)
	)
	(clr)
	(Print &rest #at temp0 temp1 #width 100 #mode 1 #dispose #time param1 #window local2)
)

(procedure (localproc_2 &tmp temp0)
	(SetFlag 188)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local64 temp0] (Clone aChaseScript))
		([local29 temp0] setStep: 6 4 setScript: [local64 temp0] 0 temp0)
	)
)

(procedure (localproc_3 &tmp temp0)
	(ClearFlag 188)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local59 temp0] (aFaeryScript new:))
		([local29 temp0] setStep: 3 2 setScript: [local59 temp0] 0 temp0)
	)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(if local1
		(ClearFlag 188)
		(= local69 80)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local59 temp0] (aFaeryScript new:))
			(= temp1 (Random 0 4))
			([local29 temp0]
				posn: [local70 temp1] [local75 temp1]
				setScript: [local59 temp0] 0 temp0
			)
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local29 temp0] (aFaery new:))
		(= [local59 temp0] (aFaeryScript new:))
		([local29 temp0]
			setLoop: temp0
			cel: 0
			ignoreActors:
			ignoreHorizon:
			posn: [local34 temp0] [local39 temp0]
			init:
			setCycle: Fwd
			setScript: [local59 temp0] 0 temp0
		)
	)
)

(procedure (localproc_6 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local5 temp0] (Clone aMush))
		([local5 temp0]
			setLoop: 5
			setCel: temp0
			posn: [local13 temp0] [local21 temp0]
			init:
			stopUpd:
		)
	)
)

(instance aFaery of Act
	(properties
		z 25
		view 70
		illegalBits 0
	)
)

(instance aMush of View
	(properties
		view 70
	)
)

(instance aFaeryWindow of SysWindow
	(properties)
)

(instance faeryMusic of Sound
	(properties
		number 40
		priority 1
		loop -1
	)
)

(instance egoBoogie of Sound
	(properties
		number 49
		priority 2
		loop -1
	)
)

(instance bopTilYouDrop of Sound
	(properties
		number 64
		priority 2
		loop -1
	)
)

(instance rm70 of Rm
	(properties
		picture 70
		style 0
		horizon 74
		north 62
		east 71
		south 77
		west 69
	)

	(method (dispose &tmp temp0)
		(if local1
			(clr)
			(for ((= temp0 0)) (< temp0 5) ((++ temp0))
				([local54 temp0] dispose:)
			)
		)
		(if local111
			(HighPrint 70 0) ; "Your senses gradually return to normal."
		)
		(super dispose:)
	)

	(method (init)
		(if (= local1 gNight)
			(LoadMany rsVIEW 70 71)
			(Load rsTEXT 296)
			(LoadMany rsSOUND 40 64)
		)
		(LoadMany rsVIEW 510 72)
		(if local1
			(localproc_5)
			(localproc_0)
			(gKeyHandler add: self)
			(gMouseHandler addToFront: self)
			(gDirHandler add: self)
			(gContMusic stop:)
			(faeryMusic init: play:)
			(egoBoogie init:)
			(bopTilYouDrop init:)
		else
			(= local3 1)
			(= global61 0)
		)
		(localproc_6)
		(super init:)
		(SL enable:)
		(= local80 -1)
		(NormalEgo)
		(switch gPrevRoomNum
			(62
				(gEgo posn: 130 75 init: setMotion: MoveTo 130 85)
			)
			(71
				(gEgo posn: 318 140 init: setMotion: MoveTo 240 140)
			)
			(69
				(gEgo posn: 1 140 init: setMotion: MoveTo 35 140)
			)
			(else
				(gEgo posn: 120 188 init: setMotion: MoveTo 120 170)
			)
		)
		(self setLocales: 804)
	)

	(method (doit)
		(cond
			((== local69 70)
				(-- local69)
				(= local107 1)
				(= local82 (+ (= local80 local97) 8))
				(= local81 8)
				(rm70 setScript: faeryTalk)
			)
			((> local69 1)
				(-- local69)
			)
			((== local69 1)
				(= local69 0)
			)
		)
		(cond
			((> local4 1)
				(-- local4)
			)
			((== local4 1)
				(= local4 0)
				(= local107 1)
				(= local82 (+ (= local80 local91) 8))
				(= local81 2)
				(self setScript: faeryTalk)
			)
		)
		(if
			(and
				(== (gEgo onControl: 1) 16384)
				(== (User canControl:) 1)
				(not local87)
				local1
			)
			(= local87 1)
			(localproc_2)
			(= local4 0)
			(= local107 1)
			(= local82 (+ (= local80 local96) 9))
			(= local81 7)
			(self setScript: faeryTalk)
		)
		(cond
			((and (> local80 local89) (not local3))
				(= local3 1)
			)
			((and (== local81 8) (== (rm70 script:) 0))
				(= local107 1)
				(= local82 (+ (= local80 local92) 9))
				(= local81 3)
				(self setScript: faeryTalk)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (== (event type:) $0040) (not local3)) ; direction
			(event claimed: 1)
			(= local3 1)
			(if (IsFlag 186)
				(= local82 (+ (= local80 local106) 9))
				(= local81 17)
			else
				(= local82 (+ (= local80 local90) 12))
				(= local81 1)
			)
			(localproc_2)
			(self setScript: faeryTalk)
		)
		(if (and (== (event type:) evMOUSEBUTTON) (not local3))
			(event claimed: 1)
			(= local3 1)
			(if (IsFlag 186)
				(= local82 (+ (= local80 local106) 9))
				(= local81 17)
			else
				(= local82 (+ (= local80 local90) 12))
				(= local81 1)
			)
			(localproc_2)
			(self setScript: faeryTalk)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN) script)
			(script cue:)
			(event claimed: 1)
		)
		(if (== (event type:) evSAID)
			(if (> local4 1)
				(cond
					((Said 'yes,please,dance')
						(= local4 0)
						(= local107 1)
						(= local82 (+ (= local80 local91) 8))
						(= local81 2)
						(self setScript: faeryTalk)
					)
					((Said 'no')
						(= local4 0)
						(= local107 1)
						(= local82 (+ (= local80 local92) 9))
						(= local81 3)
						(self setScript: faeryTalk)
					)
					(else
						(HighPrint 70 1) ; "Don't you want to dance?"
						(event claimed: 1)
					)
				)
			else
				(if (not local3)
					(event claimed: 1)
					(= local3 1)
					(if (IsFlag 186)
						(= local82 (+ (= local80 local106) 9))
						(= local81 17)
					else
						(= local82 (+ (= local80 local90) 12))
						(= local81 1)
					)
					(localproc_2)
					(self setScript: faeryTalk)
				)
				(cond
					((super handleEvent: event))
					((Said 'dance')
						(if local1
							(if (and (not script) (== (gEgo script:) 0))
								(gEgo setScript: cuteDance)
							)
						else
							(HighPrint 70 2) ; "What for? There's no one to dance with."
						)
					)
					((or (Said 'fight,kill,hit') (Said 'use/blade,dagger'))
						(if local1
							(localproc_2)
							(= local107 1)
							(= local82 (+ (= local80 local105) 9))
							(= local81 16)
							(self setScript: faeryTalk)
						else
							(HighPrint 70 3) ; "What for?"
						)
					)
					((Said 'talk')
						(if (and local1 (== local4 0))
							(if (IsFlag 188)
								(= local107 1)
								(= local82 (+ (= local80 local104) 5))
								(= local81 15)
								(self setScript: faeryTalk)
							else
								(HighPrint 70 4) ; "They seem to be ignoring you."
							)
						else
							(HighPrint 70 5) ; "Who are you talking to?"
						)
					)
					((Said 'ask>')
						(if (and local1 (== local4 0))
							(= local109 1)
							(cond
								((Said '//mushroom,toadstool,ring')
									(localproc_2)
									(= local107 1)
									(= local82 (+ (= local80 local100) 8))
									(= local81 11)
									(self setScript: faeryTalk)
								)
								((Said '//dust[<faerie,about]')
									(if (or local88 (IsFlag 689))
										(HighPrint 70 6) ; "You know all about it, now."
									else
										(localproc_2)
										(= local107 1)
										(= local82 (+ (= local80 local98) 22))
										(= local81 9)
										(self setScript: faeryTalk)
									)
								)
								((Said '//faerie,magic')
									(localproc_2)
									(= local107 1)
									(= local82 (+ (= local80 local101) 7))
									(= local81 12)
									(self setScript: faeryTalk)
								)
								((Said '//forest')
									(localproc_2)
									(= local107 1)
									(= local82 (+ (= local80 local102) 6))
									(= local81 13)
									(self setScript: faeryTalk)
								)
								((Said '//dryad')
									(localproc_2)
									(= local107 1)
									(= local82 (+ (= local80 local103) 6))
									(= local81 14)
									(self setScript: faeryTalk)
								)
								(else
									(event claimed: 1)
									(= local109 0)
									(if (IsFlag 188)
										(= local107 1)
										(= local82 (+ (= local80 local104) 5))
										(= local81 15)
										(self setScript: faeryTalk)
									else
										(HighPrint 70 4) ; "They seem to be ignoring you."
									)
								)
							)
							(if local109
								(SolvePuzzle 687 1)
							)
						else
							(event claimed: 0)
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(if local1
										(HighPrint 70 7) ; "There is much magic surrounding the fairies and their ring of mushrooms."
									else
										(HighPrint 70 8) ; "You detect faint emanations of magic near the ring of mushrooms."
									)
								)
							)
							(20
								(if (CastSpell temp0)
									(CastDazzle)
									(localproc_4)
								)
							)
							(22
								(if (CastSpell temp0)
									(CastCalm)
								)
							)
							(23
								(if (CastSpell temp0)
									(CastDart 0)
									(localproc_4)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(if (gEgo has: 7) ; dagger
							(ThrowKnife 0)
							(localproc_4)
						else
							(HighPrint 70 9) ; "You don't have a dagger."
						)
					)
					((Said 'lockpick,get,gather/mushroom')
						(if (and (== local4 0) (== (gEgo script:) 0))
							(= local0 0)
							(gEgo setScript: pickEm)
						else
							(HighPrint 70 1) ; "Don't you want to dance?"
						)
					)
					((Said 'eat/mushroom')
						(cond
							((IsFlag 327)
								(event claimed: 0)
							)
							((and (== local4 0) (== (gEgo script:) 0))
								(SetFlag 327)
								(gEgo setScript: eatShroom)
							)
							(else
								(HighPrint 70 1) ; "Don't you want to dance?"
							)
						)
					)
					((Said 'get>')
						(if (== local4 0)
							(cond
								((Said '/faerie')
									(if local1
										(HighPrint 70 10) ; "The fairies can avoid your grasp easily."
									else
										(HighPrint 70 11) ; "Huh?"
									)
								)
								((Said '/dust[<faerie]')
									(cond
										((IsFlag 689)
											(HighPrint 70 12) ; "Don't be greedy. We already gave you some."
										)
										(local88
											(HighPrint 70 13) ; "Perhaps you should be better prepared to get some fairy dust next time."
										)
										((not local1)
											(HighPrint 70 14) ; "Where could you possibly get that?"
										)
										((not local3)
											(HighPrint 70 15) ; "Maybe you should ask the Fairies for some. That would be the polite thing to do."
										)
										(else
											(= local107 1)
											(= local82
												(+ (= local80 local98) 22)
											)
											(= local81 9)
											(self setScript: faeryTalk)
										)
									)
								)
							)
						else
							(HighPrint 70 1) ; "Don't you want to dance?"
							(event claimed: 1)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,forest,greenery,clearing]')
								(HighPrint 70 16) ; "The trees look more vibrant than most of the forest."
								(HighPrint 70 17) ; "There is a ring of mushrooms on the northwest side of the clearing."
							)
							((Said '/ring,mushroom,toadstool')
								(if local1
									(HighPrint 70 18) ; "The fairy ring is luminous at night."
								else
									(HighPrint 70 19) ; "The ring of mushrooms contains mushrooms slightly larger than the ones you are used to."
								)
							)
							((Said '/faerie,creature,chandelier')
								(if local1
									(HighPrint 70 20) ; "The fairies look like little dancing lights, but you get a strong sense that they are female with butterfly wings."
								else
									(HighPrint 70 21) ; "There aren't any of those around."
								)
							)
							((Said '/south')
								(HighPrint 70 22) ; "The trees seem more dense and lush than the rest of the woods."
							)
							((Said '/tree')
								(HighPrint 70 16) ; "The trees look more vibrant than most of the forest."
							)
							((Said '/east,north')
								(HighPrint 70 23) ; "You see trees and brush."
							)
							((Said '/west')
								(HighPrint 70 24) ; "The trees here look thicker and healthier than in other parts of the forest."
							)
						)
					)
				)
			)
		)
	)
)

(instance aFaeryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> local69 0)
					(client
						setMotion:
							MoveTo
							(Random
								(- [local70 register] 25)
								(+ [local70 register] 25)
							)
							(Random
								(- [local75 register] 25)
								(+ [local75 register] 25)
							)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(Random
								(- [local34 register] 15)
								(+ [local34 register] 15)
							)
							(Random
								(- [local39 register] 15)
								(+ [local39 register] 15)
							)
							self
					)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance aChaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(local108
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 8)) 18)
								(- (Random (gEgo y:) (+ (gEgo y:) 8)) 16)
								self
						)
					)
					((IsFlag 187)
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 20)) 10)
								(- (Random (gEgo y:) (+ (gEgo y:) 30)) 15)
								self
						)
					)
					(else
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 80)) 40)
								(- (Random (gEgo y:) (+ (gEgo y:) 30)) 15)
								self
						)
					)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance faeryTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global104)
					(HandsOff)
				)
				(= seconds (if local107 4 else 3))
				(localproc_1 seconds 296 local80)
			)
			(1
				(= local107 0)
				(= seconds 0)
				(++ local80)
				(cond
					(
						(or
							(and local87 (== local80 (+ local96 7)))
							(and (== local81 3) (== local80 (+ local92 7)))
							(and (== local81 16) (== local80 (+ local105 7)))
						)
						(gEgo setScript: deathDance)
						(self changeState: 0)
					)
					((< local80 local82)
						(self changeState: 0)
					)
					(else
						(switch local81
							(1
								(SetFlag 186)
								(= local4 100)
								(HandsOn)
							)
							(17
								(= local4 100)
								(HandsOn)
							)
							(2
								(gEgo setScript: cuteDance)
							)
							(5
								(= local84 1)
							)
							(4
								(= local84 1)
							)
							(8
								(= local69 0)
								(localproc_2)
							)
							(9
								(gEgo setScript: getDust)
							)
							(10
								(getDust cue:)
							)
							(15
								(localproc_3)
							)
						)
						(if (== (gEgo script:) 0)
							(clr)
							(HandsOn)
						)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance cuteDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SolvePuzzle 688 3)
				(localproc_3)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo local85 local86 self
				)
			)
			(1
				(if (TrySkill 2 25) ; agility
					(self cue:)
				else
					(gEgo setScript: klutzDance)
					(egoBoogie play:)
				)
			)
			(2
				(gEgo
					view: 71
					setLoop: 6
					cel: 0
					cycleSpeed: 1
					moveSpeed: 3
					setCycle: Fwd
				)
				(self cue:)
			)
			(3
				(++ local83)
				(gEgo
					setMotion:
						MoveTo
						(Random (- local85 20) (+ local85 20))
						(Random (- local86 10) (+ local86 10))
						self
				)
			)
			(4
				(cond
					((== local83 2)
						(SetFlag 187)
						(localproc_2)
						(self changeState: 3)
					)
					((== local83 3)
						(= local107 1)
						(= local82 (+ (= local80 local94) 9))
						(= local81 5)
						(rm70 setScript: faeryTalk)
						(self changeState: 3)
					)
					(local84
						(= local84 0)
						(self cue:)
					)
					((>= local83 40)
						(self changeState: 13)
					)
					(else
						(self changeState: 3)
					)
				)
			)
			(5
				(localproc_3)
				(gEgo setLoop: 5 cel: 0 setCycle: 0)
				(= seconds 2)
			)
			(6
				(gEgo setCycle: End)
				(= cycles 10)
			)
			(7
				(gEgo setCycle: Beg)
				(= cycles 10)
			)
			(8
				(gEgo x: (+ (gEgo x:) 12) setLoop: 4 cel: 0 setCycle: End)
				(= cycles 10)
			)
			(9
				(localproc_1 2 {Wow!})
				(= seconds 2)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(NormalEgo)
				(gEgo x: (- (gEgo x:) 12) loop: 2)
				(= cycles 5)
			)
			(12
				(ClearFlag 187)
				(localproc_2)
				(= local107 1)
				(= local82 (+ (= local80 local95) 11))
				(= local81 6)
				(rm70 setScript: faeryTalk)
				(HandsOn)
				(self dispose:)
			)
			(13
				(HighPrint 70 25) ; "I'll bet you're sorry you said that."
				(= local83 0)
				(HandsOn)
				(NormalEgo)
				(gEgo x: (- (gEgo x:) 12) loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance klutzDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 71
					setLoop: (Random 0 4)
					cel: 0
					cycleSpeed: (if local87 0 else 1)
					setCycle: End self
				)
				(++ local83)
			)
			(1
				(cond
					((== local83 5)
						(= local107 1)
						(= local82 (+ (= local80 local93) 5))
						(= local81 4)
						(rm70 setScript: faeryTalk)
						(self changeState: 0)
					)
					(local84
						(= local84 0)
						(egoBoogie stop:)
						(self cue:)
					)
					((>= local83 40)
						(self changeState: 4)
					)
					(else
						(self changeState: 0)
					)
				)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(gEgo x: (- (gEgo x:) 12) loop: 2)
				(= cycles 10)
			)
			(3
				(localproc_2)
				(= local107 1)
				(= local82 (+ (= local80 local95) 11))
				(= local81 6)
				(rm70 setScript: faeryTalk)
				(self dispose:)
			)
			(4
				(HighPrint 70 25) ; "I'll bet you're sorry you said that."
				(= local83 0)
				(HandsOn)
				(NormalEgo)
				(gEgo x: (- (gEgo x:) 12) loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance deathDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local83 0)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 94 102 self
				)
			)
			(1
				(faeryMusic stop:)
				(bopTilYouDrop play:)
				(gEgo view: 71 x: (+ (gEgo x:) 12))
				(self cue:)
			)
			(2
				(gEgo setLoop: (Random 0 4) cel: 0 setCycle: End self)
				(++ local83)
			)
			(3
				(cond
					((== (mod local83 3) 0)
						(localproc_1 2 {Dance!})
						(self changeState: 2)
					)
					((== local83 19)
						(self cue:)
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(4
				(bopTilYouDrop stop:)
				(gEgo setLoop: 7 setCel: 1)
				(= cycles 10)
			)
			(5
				(gEgo cycleSpeed: 1 setCycle: End)
				(= cycles 35)
			)
			(6
				(localproc_1 4 {He's no fun!  He fell right over!})
				(= seconds 4)
			)
			(7
				(EgoDead 70 26 80 {Land of 1000 Dances} 82 71 2 5) ; "For such wimpy-looking creatures, those fairies sure can play rough! You never danced so hard in your entire life, which is now over."
			)
		)
	)
)

(instance pickEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo x:) 92)
					(gEgo illegalBits: 0 setMotion: MoveTo 175 109 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 19 109 self)
				)
			)
			(1
				(gEgo
					view: 510
					setLoop: (if (< (gEgo x:) 100) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(if local0
					(TimePrint 4 70 27) ; "You eat a few of the lovely mushrooms."
				else
					(HighPrint 70 28) ; "You pick a handful of the smaller mushrooms and carefully put them away in your backpack."
					(gEgo get: 30 3) ; magic mushroom
					(SetFlag 279)
					(SolvePuzzle 690 3)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(gEgo loop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getDust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local88 1)
				(gEgo view: 72 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(TimePrint 5 70 29) ; "You hold out your hand...what else could you do?"
				(= local108 1)
				(= seconds 6)
			)
			(2
				(= local81 10)
				(= local107 1)
				(= local82 (+ (= local80 local99) 3))
				(rm70 setScript: faeryTalk)
			)
			(3
				(= cycles 10)
				(= local108 0)
			)
			(4
				(cond
					((gEgo has: 26) ; empty bottle
						(TimePrint 8 70 30) ; "You place the dust carefully away in an empty flask."
						(gEgo use: 26 1) ; empty bottle
						(gEgo get: 28) ; faerie dust
						(SolvePuzzle 689 8)
					)
					(
						(or
							(gEgo has: 34) ; healing
							(gEgo has: 35) ; mana potion
							(gEgo has: 36) ; vigor potion
							(gEgo has: 39) ; grease
						)
						(TimePrint 8 70 31) ; "You realize that you need something such as an empty flask to put this fairy dust into."
					)
					(else
						(TimePrint 8 70 32) ; "As the fairy dust sifts through your fingers, you realize that you needed something to put it into."
					)
				)
				(= seconds 8)
			)
			(5
				(gEgo setCycle: End)
				(= cycles 15)
			)
			(6
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eatShroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(self setScript: pickEm self)
			)
			(1
				(HandsOff)
				(= local110 global61)
				(= global61 2)
				(DrawPic (gCurRoom curPic:) 100 1 global61)
				(Animate (gCast elements:) 0)
				(= seconds 3)
			)
			(2
				(HighPrint 70 33) ; "Wow! That was pretty wild! It's probably not a good idea to eat too many more of these mushrooms, though."
				(= local111 1)
				(= global61 local110)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

