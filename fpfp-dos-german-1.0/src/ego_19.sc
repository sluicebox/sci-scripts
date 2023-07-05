;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use ROsc)
(use StopWalk)
(use Window)
(use Ego_988)
(use Sound)
(use Motion)
(use System)

(local
	[local0 120]
	local120 = 3
	local121 = 3
	local122
)

(class ego of Ego
	(properties
		noun 1
		modNum 19
		sightAngle 180
		state 2
		view 800
		wearingGuns 0
	)

	(method (normalize param1)
		(= local120 3)
		(= local121 3)
		(= view
			(cond
				(argc param1)
				((OneOf gCurRoomNum 730 740) 845)
				(wearingGuns 842)
				(else 800)
			)
		)
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 6 4
			z: 0
			illegalBits: -32768
			ignoreActors: 0
		)
	)

	(method (showInv &tmp temp0 temp1 temp2)
		(if (gInventory firstTrue: #ownedBy gEgo)
			(= temp1 gNormalCursor)
			(= gNormalCursor 999)
			(= temp0 gSystemWindow)
			(= gSystemWindow SysWindow)
			(gInventory showSelf: gEgo)
			(= gNormalCursor temp1)
			(if (== (= temp2 ((gTheIconBar curIcon:) cursor:)) 999)
				(gGame setCursor: gWaitCursor)
			else
				(gGame setCursor: temp2)
			)
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar disable: 5)
				(if (& ((gTheIconBar curIcon:) signal:) $0004)
					(gTheIconBar advanceCurIcon:)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(= gSystemWindow temp0)
			(gNarrator showTitle: 0 name: {Narrator})
		else
			(gMessager say: 988 0 1 0 0 19) ; MISSING MESSAGE
		)
	)

	(method (put param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory at: [param1 temp0])
				owner: ((gInventory at: [param1 temp0]) realOwner:)
			)
			((gInventory at: [param1 temp0]) realOwner: 0)
		)
		(super put: param1 &rest)
		(cond
			((not (gUser canControl:))
				(if (== global125 (gTheIconBar at: 5))
					(= global125 (gTheIconBar at: 0))
				)
				(gGame setCursor: gWaitCursor)
			)
			((== (gInventory state:) 2080)
				(gGame setCursor: 999)
			)
			(else
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar at: 0) cursor:))
			)
		)
	)

	(method (get param1 param2 param3 param4 &tmp temp0)
		(if (== param1 -1)
			((gInventory at: [param1 1]) moveTo: self)
			((gInventory at: [param1 1])
				realOwner: ((gInventory at: [param1 1]) owner:)
				owner: 0
			)
		else
			(super get: param1 &rest)
			((gInventory at: param1)
				realOwner: ((gInventory at: param1) owner:)
				owner: 0
			)
			(gMessager say: (param2 noun:) 4 0 0 0 gCurRoomNum)
		)
		(if (and (>= argc 3) param3)
			(if (and (== argc 4) param4)
				(= global140 param4)
			)
			(gEgo setScript: sReach 0 param3)
		)
	)

	(method (has param1)
		(return
			(or
				(== ((gInventory at: param1) realOwner:) self)
				(== ((gInventory at: param1) owner:) self)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= global133 theVerb)
		(switch theVerb
			(41 ; Baking_Soda
				(gMessager say: noun theVerb 0 0 self 19) ; "You foolishly ingest several sacks of the baking soda, creating a major eruption of the worst kind!"
			)
			(58 ; Boots
				(if (IsFlag 58)
					(gCurRoom newRoom: 630)
				else
					(gMessager say: noun theVerb 2 0 0 19) ; "You will want to wear them later, but only after you have completed your outfit."
				)
			)
			(49 ; Coffee
				(gEgo put: 11) ; Coffee
				(super doVerb: theVerb &rest)
			)
			(56 ; Clothes
				(if (IsFlag 58)
					(gCurRoom newRoom: 630)
				else
					(gMessager say: noun theVerb 2 0 0 19) ; "You wouldn't |c2|dream|c| of wearing your cowboy clothes around town until you have both your whole ensemble and a damn good reason!"
				)
			)
			(29 ; Deflatulizer
				(gMessager say: noun theVerb 0 0 self 19) ; "Unfortunately for you, this Deflatulizer is highly concentrated, far too powerful to be ingested in undiluted form!"
			)
			(5 ; Elixir
				(gMessager say: noun theVerb 0 0 self 19) ; "You uncork and swig the elixir, finishing the bottle before you know it."
			)
			(64 ; Filled_Sack
				(gMessager say: noun theVerb 0 0 self 19) ; "You are a sick, sick little pharmacist!"
			)
			(28 ; Gas_Mask
				(cond
					(
						(OneOf
							gCurRoomNum
							410
							600
							610
							620
							630
							640
							650
							660
							670
							690
							710
							720
							730
						)
						(gMessager say: noun theVerb 8 0 0 19) ; "Fortunately, the aroma hasn't permeated the interior of the building. You won't need to use that gas mask in here."
					)
					((IsFlag 45)
						(gMessager say: noun theVerb 6 0 0 19) ; "You can't fiddle with that while you're on the ladder."
					)
					((IsFlag 21)
						(gMessager say: noun theVerb 12 0 0 19) ; "You can't keep your balance up here AND use the gas mask properly at the same time, Freddy."
					)
					(else
						(gCurRoom setScript: sUseGasMask)
					)
				)
			)
			(66 ; Horse_Plop
				(gMessager say: noun theVerb 0 0 self 19) ; "How disgusting!!"
			)
			(71 ; Incorrect_Med
				(gMessager say: noun theVerb 0 0 self 19) ; "You take a sip of the medication."
			)
			(11 ; Med_1
				(gMessager say: noun theVerb 0 0 self 19) ; "You take a sip of the medication."
			)
			(13 ; Med_2
				(gMessager say: noun theVerb 0 0 self 19) ; "You take a sip of the medication."
			)
			(18 ; Med_3
				(gMessager say: noun theVerb 0 0 self 19) ; "You take a sip of the medication."
			)
			(59 ; Neckerchief
				(if (IsFlag 58)
					(gCurRoom newRoom: 630)
				else
					(gMessager say: noun theVerb 2 0 0 19) ; "You will want to wear it later, but only after you have completed your outfit."
				)
			)
			(40 ; Nitrous_Oxide
				(giggleSound play:)
				(gMessager say: noun theVerb 0 0 self 19) ; "You open the valve on the tank of nitrous oxide, and you soon die laughing!"
			)
			(47 ; Pistols
				(if (IsFlag 54)
					(Message msgGET 19 3 0 0 (Random 1 5) @local0)
					(SetQuitStr @local0)
					(= gQuit 1)
				else
					(gMessager say: noun theVerb 5 0 0 19) ; "Trying to hold yourself up? Who do you think you're trying to kid?"
				)
			)
			(39 ; Pure_Solution
				(gMessager say: noun theVerb 0 0 self 19) ; "You take a swig of the concentrated water purification solution."
			)
			(60 ; Sharp_Ear
				(if (IsFlag 81)
					(gCurRoom notify: 1)
				)
			)
			(55 ; Silver_Ear
				(cond
					((IsFlag 58)
						(gCurRoom newRoom: 630)
					)
					((== gCurRoomNum 730)
						(gMessager say: noun theVerb 9 0 0 19) ; "It's too late to wear that thing. Penelope's already seen through your disguise!"
					)
					(else
						(gMessager say: noun theVerb 2 0 0 19) ; "You will want to wear it later, but only after you have completed your outfit."
					)
				)
			)
			(30 ; Snails
				(gMessager say: noun theVerb 0 0 self 19) ; "What? No garlic butter? AUGGGH!"
			)
			(61 ; Sword
				(gMessager say: noun theVerb 0 0 self 19) ; "It's bad enough that Penelope's trying to kill you. Now you want to run yourself through?"
			)
			(23 ; Tower_H20
				(cond
					((IsFlag 45)
						(gMessager say: 1 23 6 0 0 19) ; "You're having enough trouble balancing on the ladder as it is; now's no time to juggle your inventory items."
					)
					((or (IsFlag 20) (IsFlag 21))
						(gMessager say: 1 23 7 0 0 19) ; "It's not a good idea to try that up here! Lose your balance and you'll be nothing more than a particularly large road apple."
					)
					((== gCurRoomNum 265)
						(gMessager say: 1 23 10 0 0 19) ; "You had a drink of water just before you went to bed!"
					)
					(else
						(gCurRoom setScript: sWaterSample)
					)
				)
			)
			(4 ; Do
				(cond
					(
						(or
							(IsFlag 82)
							(and (IsFlag 81) (== view 731) (== loop 0))
						)
						(if (<= cel 3)
							(= temp0 (-- local121))
							(= temp1 (++ local120))
							(if (< temp0 0)
								(if (== gCurRoomNum 730)
									(gCurRoom notify: 0)
								)
								(= temp0 0)
								(= local121 0)
							)
							(if (> temp1 (self lastCel:))
								(= temp1 (self lastCel:))
								(= local120 (self lastCel:))
							)
						else
							(= temp0 (++ local121))
							(= temp1 (-- local120))
							(if (> temp0 3)
								(= temp0 3)
								(= local121 3)
							)
							(if (< temp1 3)
								(= temp1 3)
								(= local120 3)
							)
						)
						(if
							(and
								(gEgo cycler:)
								((gEgo cycler:) isKindOf: ROsc)
							)
							((gEgo cycler:) firstC: temp0)
							((gEgo cycler:) lastC: temp1)
						else
							(self setCycle: ROsc -1 temp0 temp1)
						)
						(if
							(and
								(==
									((gEgo cycler:) firstC:)
									((gEgo cycler:) lastC:)
								)
								(!= (gEgo cel:) ((gEgo cycler:) firstC:))
							)
							(gEgo setCel: 3 setCycle: 0)
						)
					)
					((and (== gCurPuzzle 25) (gEgo has: 44) (== gCurRoomNum 720)) ; Pistols
						(gCurRoom notify:)
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

	(method (cue)
		(switch global133
			(41
				(= global122 3)
			)
			(29
				(= global122 3)
			)
			(5
				(= global122 4)
			)
			(64
				(= global122 0)
			)
			(66
				(= global122 0)
			)
			(71
				(= global122 3)
			)
			(11
				(= global122 3)
			)
			(13
				(= global122 3)
			)
			(18
				(= global122 3)
			)
			(40
				(= global122 5)
			)
			(39
				(= global122 3)
			)
			(30
				(= global122 2)
			)
			(61
				(= global122 14)
			)
		)
		(gCurRoom newRoom: 99) ; deathRoom
	)
)

(instance sReach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local122 (gEgo moveSpeed:))
				(gEgo setSpeed: 6)
				(= cycles 3)
			)
			(1
				(if (gEgo wearingGuns:)
					(gEgo view: 125)
				else
					(gEgo view: 124)
				)
				(switch register
					(3
						(if (> (gEgo heading:) 180)
							(gEgo setLoop: 1)
						else
							(gEgo setLoop: 0)
						)
					)
					(2
						(if (> (gEgo heading:) 180)
							(gEgo setLoop: 3)
						else
							(gEgo setLoop: 2)
						)
					)
					(1
						(if (> (gEgo heading:) 180)
							(gEgo setLoop: 5)
						else
							(gEgo setLoop: 4)
						)
					)
				)
				(gEgo
					cel: 0
					setCycle: CT (if (== register 3) 3 else 6) 1 self
				)
			)
			(2
				(if (IsObject global140)
					(global140 dispose:)
				)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize:
					setHeading:
						(if (OneOf (gEgo loop:) 1 3 5) 270 else 90)
				)
				(= global140 0)
				(gEgo setSpeed: local122)
				(UnLoad 128 124)
				(UnLoad 128 125)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseGasMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 70)
				(gGame points: 12 133)
				((ScriptID 0 14) setReal: (ScriptID 0 14) 40) ; gasMaskTimer, gasMaskTimer
				(= local122 (gEgo moveSpeed:))
				(gEgo setSpeed: 6)
				(if (not (or (== (gEgo cel:) 0) (== (gEgo cel:) 1)))
					(if (< 0 (gEgo heading:) 179)
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 270 self)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 143
					setLoop: (if (== (gEgo cel:) 0) 0 else 1)
					setCel: 0
					x:
						(if (== (gEgo cel:) 0)
							(gEgo x:)
						else
							(+ (gEgo x:) 1)
						)
					setCycle: End self
				)
			)
			(2
				(= ticks 75)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					normalize:
					loop: (if (== (gEgo loop:) 0) 0 else 1)
					x:
						(if (== (gEgo loop:) 0)
							(gEgo x:)
						else
							(- (gEgo x:) 1)
						)
				)
				(if (or (IsFlag 20) (IsFlag 21))
					(gEgo setPri: 9)
				)
				(gMessager say: 1 global133 0 0 0 19)
				(gEgo setSpeed: local122)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWaterSample of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 996 1)
				(gEgo get: -1 18) ; Empty_Bottles
				(gEgo put: 57) ; Tower_H20
				(= cycles 1)
			)
			(1
				(gGame points: 1 134)
				(gMessager say: 1 23 0 0 self 19) ; "You take a swig of the water from the water tower."
			)
			(2
				(if (!= gCurRoomNum 320)
					(SetFlag 74)
					(proc0_15 1 5 self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== gCurRoomNum 320)
					(gCurRoom notify:)
				else
					(gCurRoom newRoom: 320)
				)
				(self dispose:)
			)
		)
	)
)

(instance giggleSound of Sound
	(properties
		flags 1
		number 2140
	)
)

