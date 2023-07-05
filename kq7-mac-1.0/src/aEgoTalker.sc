;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use ExitButton)
(use scaryInvInit)
(use DuneMover)
(use OogaBooga)
(use Talker)
(use PolyPath)
(use StopWalk)
(use Ego)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	aEgoTalker 0
)

(local
	local0
)

(class KQEgo of Ego
	(properties
		state 2
		view 800
		old_hotspot 0
	)

	(method (setMotion param1)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(= mover
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
			(if (and looper (looper oldMover:))
				((looper oldMover:) dispose:)
				(looper oldMover: 0)
			)
		)
	)

	(method (dispose)
		(self setScale: 0)
		(super dispose:)
	)

	(method (disableHotspot)
		(if (not old_hotspot)
			(SetFlag 338)
			(= old_hotspot scratch)
			(= scratch 0)
			(if argc
				(self setHotspot: 0 &rest)
			)
		)
	)

	(method (enableHotspot)
		(if old_hotspot
			(ClearFlag 338)
			(if scratch
				(scratch dispose:)
			)
			(= scratch old_hotspot)
			(= old_hotspot 0)
		)
	)

	(method (cue)
		(kqEgoSound stop: dispose:)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) $0010) ; direction
				(return 0)
			)
			((not (gCast contains: self))
				(return 0)
			)
			((not (or (event type:) global308))
				(return 0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(if (and (gEgo has: 65) (== gChapter 5) (== gCurRoomNum 3150)) ; Were-beast_Salve
			(if scratch
				(self addRespondVerb: 72) ; Were-beast_Salve
			else
				(self setHotspot: 0 72) ; Were-beast_Salve
			)
		)
		(if (gEgo has: 61) ; Woolen_Stocking
			((gInventory at: 61) setHotspot: 8 10 37) ; Woolen_Stocking, Do, Exit, Silver_Pellet
		)
		(if (gEgo has: 28) ; Silver_Pellet
			((gInventory at: 28) setHotspot: 8 10 84) ; Silver_Pellet, Do, Exit, Woolen_Stocking
		)
		(if (gEgo has: 23) ; Toy_Rat
			((gInventory at: 23) setHotspot: 8 10) ; Toy_Rat, Do, Exit
		)
		(if (gEgo has: 10) ; Jackalope_Fur
			((gInventory at: 10) setHotspot: 8 10 72) ; Jackalope_Fur, Do, Exit, Were-beast_Salve
		)
		(if (gEgo has: 65) ; Were-beast_Salve
			((gInventory at: 65) setHotspot: 8 10 21) ; Were-beast_Salve, Do, Exit, Jackalope_Fur
		)
		(if (gEgo has: 0) ; Golden_Comb
			(if
				(and
					(or
						(and (== gChapter 3) (not (IsFlag 201)))
						(and (== gChapter 5) (not (IsFlag 550)))
					)
					(not (or (== gCurRoomNum 5150) (== gCurRoomNum 5100)))
				)
				((gInventory at: 47) setHotspot: 8 10 5) ; Magic_Statue, Do, Exit, Golden_Comb
			)
			(if
				(or
					(not (IsFlag 270))
					(and
						(== gCurRoomNum 1250)
						(not (IsFlag 31))
						(IsFlag 326)
						(< x 250)
						(IsFlag 24)
					)
				)
				(if scratch
					(self addRespondVerb: 5) ; Golden_Comb
				else
					(self setHotspot: 0 5) ; Golden_Comb
				)
			)
		)
		(if
			(and
				(gEgo has: 47) ; Magic_Statue
				(or
					(and (== gChapter 3) (not (IsFlag 201)))
					(and (== gChapter 5) (not (IsFlag 550)))
				)
				(not (or (== gCurRoomNum 5150) (== gCurRoomNum 5100)))
			)
			((gInventory at: 0) setHotspot: 8 10 61) ; Golden_Comb, Do, Exit, Magic_Statue
		)
		(if (gEgo has: 8) ; Hunting_Horn
			(if scratch
				(self addRespondVerb: 18) ; Hunting_Horn
			else
				(self setHotspot: 0 18) ; Hunting_Horn
			)
		)
		(if (gEgo has: 26) ; Baked_Beetles
			(if scratch
				(self addRespondVerb: 35) ; Baked_Beetles
			else
				(self setHotspot: 0 35) ; Baked_Beetles
			)
		)
		(if
			(and
				(gEgo has: 49) ; Grave_Digger_s_Horn
				(OneOf gCurRoomNum 4000 4050 4100 4101 4102 4250 4400 4350)
				(== gChapter 4)
			)
			(if scratch
				(self addRespondVerb: 65) ; Grave_Digger_s_Horn
			else
				(self setHotspot: 0 65) ; Grave_Digger_s_Horn
			)
		)
		(if (gEgo has: 48) ; Moon
			(if scratch
				(self addRespondVerb: 71) ; Moon
			else
				(self setHotspot: 0 71) ; Moon
			)
		)
		(if (gEgo has: 70) ; Tapestry_of_Dreams
			(if scratch
				(self addRespondVerb: 83) ; Tapestry_of_Dreams
			else
				(self setHotspot: 0 83) ; Tapestry_of_Dreams
			)
		)
		(if (gEgo has: 54) ; Veil
			(if scratch
				(self addRespondVerb: 70) ; Veil
			else
				(self setHotspot: 0 70) ; Veil
			)
		)
		(if
			(and
				(gEgo has: 76) ; Horseman_s_Fife
				(not (IsFlag 226))
				(OneOf
					gCurRoomNum
					1100
					1102
					1150
					1110
					1250
					1300
					1350
					1500
					1600
					3000
					3050
					3100
					3150
					3200
					3250
					3300
					4000
					4050
					4101
					4102
					4250
					4350
					4400
					4550
					5300
					5400
				)
			)
			(if scratch
				(self addRespondVerb: 94) ; Horseman_s_Fife
			else
				(self setHotspot: 0 94) ; Horseman_s_Fife
			)
		)
		(if (gEgo has: 43) ; Mask
			(if scratch
				(self addRespondVerb: 57) ; Mask
			else
				(self setHotspot: 0 57) ; Mask
			)
		)
		(if (gEgo has: 16) ; Fresh_Water
			(if scratch
				(self addRespondVerb: 28) ; Fresh_Water
			else
				(self setHotspot: 0 28) ; Fresh_Water
			)
		)
		(if (gEgo has: 15) ; Salt_Water
			(if scratch
				(self addRespondVerb: 27) ; Salt_Water
			else
				(self setHotspot: 0 27) ; Salt_Water
			)
		)
		(if (gEgo has: 40) ; Nectar_in_Pot
			(if scratch
				(self addRespondVerb: 54) ; Nectar_in_Pot
			else
				(self setHotspot: 0 54) ; Nectar_in_Pot
			)
		)
		(if (gEgo has: 12) ; Turquoise_Piece_b
			((gInventory at: 12) setHotspot: 8 10 20) ; Turquoise_Piece_b, Do, Exit, Turquoise_Piece_a
			((gInventory at: 5) setHotspot: 8 10 22) ; Turquoise_Piece_a, Do, Exit, Turquoise_Piece_b
		else
			((gInventory at: 5) setHotspot: 8 10) ; Turquoise_Piece_a, Do, Exit
		)
		(if (gEgo has: 5) ; Turquoise_Piece_a
			((gInventory at: 12) setHotspot: 8 10 20) ; Turquoise_Piece_b, Do, Exit, Turquoise_Piece_a
			((gInventory at: 5) setHotspot: 8 10 22) ; Turquoise_Piece_a, Do, Exit, Turquoise_Piece_b
		else
			((gInventory at: 12) setHotspot: 8 10) ; Turquoise_Piece_b, Do, Exit
		)
		(if
			(and
				(self has: 21) ; Salt_Crystals
				(or
					(and (== gValOrRoz -3) (IsFlag 166)) ; Roz
					(and (== gValOrRoz -4) (IsFlag 110)) ; Val
				)
			)
			(if scratch
				(self addRespondVerb: 51) ; Salt_Crystals
			else
				(self setHotspot: 0 51) ; Salt_Crystals
			)
			((gInventory at: 21) setHotspot: 8 10) ; Salt_Crystals, Do, Exit
		)
		(if (self has: 1) ; Ripped_Petticoat
			((gInventory at: 3) setHotspot: 8 10 6) ; Stick, Do, Exit, Ripped_Petticoat
			((gInventory at: 1) setHotspot: 8 10 11) ; Ripped_Petticoat, Do, Exit, Stick
		)
		(if (gEgo has: 3) ; Stick
			((gInventory at: 3) setHotspot: 8 10 6) ; Stick, Do, Exit, Ripped_Petticoat
			((gInventory at: 1) setHotspot: 8 10 11) ; Ripped_Petticoat, Do, Exit, Stick
		)
		(if
			(and
				(!= gCurRoomNum 5200)
				(gEgo has: 55) ; Scarab
				(not (IsFlag 338))
				(not (IsFlag 283))
				(not (OneOf gCurRoomNum 4010 4600 4700 4550 4200 4300))
			)
			((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
			((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
		)
		(if
			(and
				(!= gCurRoomNum 5200)
				(gEgo has: 53) ; Magic_Wand
				(not (IsFlag 338))
				(not (IsFlag 283))
				(not (OneOf gCurRoomNum 4010 4600 4700 4550 4200 4300))
			)
			((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
			((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
		)
		((ScriptID 13 0) client: self) ; aEgoTalker
		(= z 0)
		(super init: &rest)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(or
					(and (== (gUser message:) 71) (IsFlag 249))
					(== (gUser message:) 99)
					(== (gUser message:) 96)
				)
			)
			(return 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(18 ; Hunting_Horn
				(gEgo setScript: cleanHorn)
				(return 1)
			)
			(5 ; Golden_Comb
				(if
					(and
						(== gCurRoomNum 1250)
						(not (IsFlag 31))
						(IsFlag 326)
						(< x 250)
						(IsFlag 24)
					)
					(gEgo setScript: (ScriptID 1250 1)) ; cryInBowl
					(return 1)
				else
					(SetFlag 326)
					(gEgo setScript: combCry)
					(if (== gCurRoomNum 1250)
						(gCurRoom notify:)
					)
					(return 1)
				)
			)
			(65 ; Grave_Digger_s_Horn
				(++ global374)
				(if (and (!= gCurRoomNum 4350) (!= gCurRoomNum 4050) (< global374 4))
					(OogaBooga setScript: (ScriptID 4001 4)) ; diggerComes
				else
					(= temp0 global374)
					(++ temp0)
					(cond
						((== gCurRoomNum 4350)
							(gCurRoom notify:)
						)
						((>= temp0 4)
							(OogaBooga setScript: (ScriptID 4001 1)) ; wakeTheDead
						)
						((== gCurRoomNum 4050)
							(gCurRoom notify:)
						)
						(else
							(OogaBooga setScript: (ScriptID 4001 4)) ; diggerComes
						)
					)
				)
				(return 1)
			)
			(71 ; Moon
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 112 0)) ; takeABiteOutOfMoon
				)
				(return 1)
			)
			(72 ; Were-beast_Salve
				(cond
					((not (IsFlag 218))
						(gMessager say: 2 72 3 1 0 3150) ; "(THINKS TO HERSELF)Oh! That's right. The salesman said to add animal fur to the salve for it to work."
						(return 1)
					)
					((== gCurRoomNum 3150)
						(gCurRoom setScript: (ScriptID 3150 1)) ; putOnSalve
						(return 1)
					)
					(else
						(return 0)
					)
				)
			)
			(83 ; Tapestry_of_Dreams
				(cond
					((== gCurRoomNum 6500)
						(gCurRoom notify:)
					)
					(
						(and
							(not (gCurRoom script:))
							(not (gEgo script:))
							(!= gCurRoomNum 6350)
						)
						(gEgo setScript: tapestryScript)
					)
				)
				(return 1)
			)
			(70 ; Veil
				(SetFlag 151)
				(cond
					((== gCurRoomNum 4400)
						(gCurRoom notify:)
					)
					((== gCurRoomNum 4650)
						(gCurRoom notify:)
					)
					(else
						(gGame setScript: putOnVeil)
					)
				)
				(return 1)
			)
			(51 ; Salt_Crystals
				(if (IsFlag 110)
					(gGame setScript: eatSaltScript)
				else
					(super doVerb: theVerb)
				)
			)
			(94 ; Horseman_s_Fife
				(if
					(and
						(not (IsFlag 226))
						(OneOf
							gCurRoomNum
							1100
							1102
							1150
							1110
							1250
							1300
							1350
							1500
							1600
							3000
							3050
							3100
							3150
							3200
							3250
							3300
							4000
							4050
							4101
							4102
							4250
							4350
							4400
							4550
							5300
							5400
						)
					)
					(gGame setScript: flyHorseScript)
				)
			)
			(28 ; Fresh_Water
				(if (and (== gCurRoomNum 3250) (IsFlag 131))
					(gCurRoom notify:)
				else
					(if (== gCurRoomNum 1500)
						(SetFlag 47)
						((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
						((ScriptID 0 8) setReal: (ScriptID 0 8) 300) ; stormDeathTimer, stormDeathTimer
					)
					(if (== view 800)
						(gGame setScript: egoDrink)
					)
				)
			)
			(27 ; Salt_Water
				(cond
					((and (== gCurRoomNum 3250) (IsFlag 131))
						(gCurRoom notify:)
					)
					((== gCurRoomNum 1500)
						(SetFlag 46)
						(SetFlag 128)
						(gCurRoom cue:)
					)
					(else
						(gGame setScript: egoPourSaltW)
					)
				)
			)
			(12 ; Clay_Pot
				(if (and (== gCurRoomNum 3250) (IsFlag 131))
					(gCurRoom notify:)
				)
			)
			(57 ; Mask
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 57 2 0 0 800) ; "(THINKS TO HERSELF)There's no way I'm going to wear this thing all over the place."
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
			)
			(35 ; Baked_Beetles
				(gCurRoom setScript: eatBeetles)
			)
			(54 ; Nectar_in_Pot
				(gGame setScript: egoDrinkNectar)
			)
		)
	)

	(method (setScale)
		(= scaleX (= scaleY (= maxScale 128)))
		(super setScale: &rest)
	)

	(method (normalize param1 param2)
		(cond
			((> argc 0)
				(= loop param1)
				(= heading
					(switch loop
						(0 90)
						(1 270)
						(2 180)
						(3 0)
						(4 135)
						(5 225)
						(6 45)
						(7 315)
					)
				)
			)
			((< heading 15)
				(= loop 3)
			)
			((< heading 80)
				(= loop 6)
			)
			((< heading 100)
				(= loop 0)
			)
			((< heading 165)
				(= loop 4)
			)
			((< heading 195)
				(= loop 2)
			)
			((< heading 260)
				(= loop 5)
			)
			((< heading 280)
				(= loop 1)
			)
			((< heading 345)
				(= loop 7)
			)
			(else
				(= loop 3)
			)
		)
		(self
			view:
				(cond
					((> argc 1) param2)
					((OneOf gCurRoomNum 2206 2208) 2241)
					((== gValOrRoz -4) 800) ; Val
					((IsFlag 151)
						(switch gCurRoomNum
							(4550 9021)
							(3150 9022)
							(else 902)
						)
					)
					((IsFlag 55) 836)
					(else 870)
				)
			edgeHit: 0
			signal: 4129
			setLoop: -1
			setLooper: gGrooper
			setPri: -1
			setMotion: 0
			illegalBits: 0
			ignoreActors: 1
			setStep: 3 2
			setCycle: StopWalk -1
			setSpeed: (gGame currentSpeed:)
		)
	)

	(method (get param1 param2 &tmp temp0)
		(if (not (self has: param1))
			(= temp0 (gInventory at: param1))
			(proc18_1 temp0)
			(++ gInventoryCount)
			(if
				(and
					(not (OneOf gCurRoomNum 26 35 23)) ; chapEndRm, selectGameRoom
					(or (== argc 1) (and (== argc 2) (not param2)))
				)
				(kqEgoSound number: 12 setLoop: 1 play: self)
			)
			(switch param1
				(21
					(if
						(or
							(and (== gValOrRoz -4) (IsFlag 110)) ; Val
							(and (== gValOrRoz -3) (IsFlag 166)) ; Roz
						)
						(if scratch
							(self addRespondVerb: 51) ; Salt_Crystals
						else
							(self setHotspot: 0 51) ; Salt_Crystals
						)
					)
					((gInventory at: 21) setHotspot: 8 10) ; Salt_Crystals, Do, Exit
				)
				(1
					(if (gEgo has: 3) ; Stick
						((gInventory at: 3) setHotspot: 8 10 6) ; Stick, Do, Exit, Ripped_Petticoat
						((gInventory at: 1) setHotspot: 8 10 11) ; Ripped_Petticoat, Do, Exit, Stick
					else
						((gInventory at: 1) setHotspot: 8 10) ; Ripped_Petticoat, Do, Exit
					)
				)
				(65
					(if (self has: 10) ; Jackalope_Fur
						((gInventory at: 10) setHotspot: 8 10 72) ; Jackalope_Fur, Do, Exit, Were-beast_Salve
						((gInventory at: 65) setHotspot: 8 10 21) ; Were-beast_Salve, Do, Exit, Jackalope_Fur
					else
						((gInventory at: param1) setHotspot: 8 10) ; Do, Exit
					)
				)
				(10
					(if (self has: 65) ; Were-beast_Salve
						((gInventory at: 65) setHotspot: 8 10 21) ; Were-beast_Salve, Do, Exit, Jackalope_Fur
						((gInventory at: 10) setHotspot: 8 10 72) ; Jackalope_Fur, Do, Exit, Were-beast_Salve
					else
						((gInventory at: param1) setHotspot: 8 10) ; Do, Exit
					)
				)
				(3
					(if (gEgo has: 1) ; Ripped_Petticoat
						((gInventory at: 3) setHotspot: 8 10 6) ; Stick, Do, Exit, Ripped_Petticoat
						((gInventory at: 1) setHotspot: 8 10 11) ; Ripped_Petticoat, Do, Exit, Stick
					else
						((gInventory at: 3) setHotspot: 8 10) ; Stick, Do, Exit
					)
				)
				(5
					(if (gEgo has: 12) ; Turquoise_Piece_b
						((gInventory at: 12) setHotspot: 8 10 20) ; Turquoise_Piece_b, Do, Exit, Turquoise_Piece_a
						((gInventory at: 5) setHotspot: 8 10 22) ; Turquoise_Piece_a, Do, Exit, Turquoise_Piece_b
					else
						((gInventory at: 5) setHotspot: 8 10) ; Turquoise_Piece_a, Do, Exit
					)
				)
				(12
					(if (gEgo has: 5) ; Turquoise_Piece_a
						((gInventory at: 12) setHotspot: 8 10 20) ; Turquoise_Piece_b, Do, Exit, Turquoise_Piece_a
						((gInventory at: 5) setHotspot: 8 10 22) ; Turquoise_Piece_a, Do, Exit, Turquoise_Piece_b
					else
						((gInventory at: 12) setHotspot: 8 10) ; Turquoise_Piece_b, Do, Exit
					)
				)
				(28
					(if (gEgo has: 61) ; Woolen_Stocking
						((gInventory at: 61) setHotspot: 8 10 37) ; Woolen_Stocking, Do, Exit, Silver_Pellet
						((gInventory at: 28) setHotspot: 8 10 84) ; Silver_Pellet, Do, Exit, Woolen_Stocking
					else
						((gInventory at: 28) setHotspot: 8 10) ; Silver_Pellet, Do, Exit
					)
				)
				(61
					(if (gEgo has: 28) ; Silver_Pellet
						((gInventory at: 61) setHotspot: 8 10 37) ; Woolen_Stocking, Do, Exit, Silver_Pellet
						((gInventory at: 28) setHotspot: 8 10 84) ; Silver_Pellet, Do, Exit, Woolen_Stocking
					else
						((gInventory at: 61) setHotspot: 8 10) ; Woolen_Stocking, Do, Exit
					)
				)
				(0
					(if scratch
						(self addRespondVerb: 5) ; Golden_Comb
					else
						(self setHotspot: 0 5) ; Golden_Comb
					)
					(if (and (OneOf gChapter 3 5) (gEgo has: 47)) ; Magic_Statue
						((gInventory at: 0) setHotspot: 8 10 61) ; Golden_Comb, Do, Exit, Magic_Statue
						((gInventory at: 47) setHotspot: 8 10 5) ; Magic_Statue, Do, Exit, Golden_Comb
					)
					((gInventory at: 0) setHotspot: 8 10) ; Golden_Comb, Do, Exit
				)
				(47
					(if (and (OneOf gChapter 3 5) (gEgo has: 0)) ; Golden_Comb
						((gInventory at: 47) setHotspot: 8 10 5) ; Magic_Statue, Do, Exit, Golden_Comb
						((gInventory at: 0) setHotspot: 8 10 61) ; Golden_Comb, Do, Exit, Magic_Statue
					else
						((gInventory at: 47) setHotspot: 8 10) ; Magic_Statue, Do, Exit
					)
				)
				(55
					(if (and (gEgo has: 53) (not (IsFlag 338))) ; Magic_Wand
						((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
						((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
					else
						((gInventory at: 55) setHotspot: 8 10) ; Scarab, Do, Exit
					)
				)
				(53
					(if (and (gEgo has: 55) (not (IsFlag 338))) ; Scarab
						((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
						((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
					)
					((gInventory at: 53) setHotspot: 8 10) ; Magic_Wand, Do, Exit
				)
				(76
					(if
						(and
							(not (IsFlag 226))
							(OneOf
								gCurRoomNum
								1100
								1102
								1150
								1110
								1250
								1300
								1350
								1500
								1600
								3000
								3050
								3100
								3150
								3200
								3250
								3300
								4000
								4050
								4101
								4102
								4250
								4350
								4400
								4550
								5300
								5400
							)
						)
						(if scratch
							(self addRespondVerb: 94) ; Horseman_s_Fife
						else
							(self setHotspot: 0 94) ; Horseman_s_Fife
						)
					)
					((gInventory at: 76) setHotspot: 8 10) ; Horseman_s_Fife, Do, Exit
				)
				(26
					(if scratch
						(self addRespondVerb: 35) ; Baked_Beetles
					else
						(self setHotspot: 0 35) ; Baked_Beetles
					)
					((gInventory at: 26) setHotspot: 8 10) ; Baked_Beetles, Do, Exit
				)
				(8
					(if scratch
						(self addRespondVerb: 18) ; Hunting_Horn
					else
						(self setHotspot: 0 18) ; Hunting_Horn
					)
					((gInventory at: 8) setHotspot: 8 10) ; Hunting_Horn, Do, Exit
				)
				(70
					(if scratch
						(self addRespondVerb: 83) ; Tapestry_of_Dreams
					else
						(self setHotspot: 0 83) ; Tapestry_of_Dreams
					)
					((gInventory at: 70) setHotspot: 8 10) ; Tapestry_of_Dreams, Do, Exit
				)
				(16
					(if scratch
						(self addRespondVerb: 28) ; Fresh_Water
					else
						(self setHotspot: 0 28) ; Fresh_Water
					)
					((gInventory at: 16) setHotspot: 8 10) ; Fresh_Water, Do, Exit
				)
				(40
					(if scratch
						(self addRespondVerb: 54) ; Nectar_in_Pot
					else
						(self setHotspot: 0 54) ; Nectar_in_Pot
					)
					((gInventory at: 40) setHotspot: 8 10) ; Nectar_in_Pot, Do, Exit
				)
				(49
					(if
						(and
							(OneOf
								gCurRoomNum
								4000
								4050
								4100
								4101
								4102
								4250
								4400
								4350
							)
							(== gChapter 4)
						)
						(if scratch
							(self addRespondVerb: 65) ; Grave_Digger_s_Horn
						else
							(self setHotspot: 0 65) ; Grave_Digger_s_Horn
						)
					)
					((gInventory at: 49) setHotspot: 8 10) ; Grave_Digger_s_Horn, Do, Exit
				)
				(54
					(if scratch
						(self addRespondVerb: 70) ; Veil
					else
						(self setHotspot: 0 70) ; Veil
					)
					((gInventory at: 54) setHotspot: 8 10) ; Veil, Do, Exit
				)
				(15
					(if scratch
						(self addRespondVerb: 27) ; Salt_Water
					else
						(self setHotspot: 0 27) ; Salt_Water
					)
					((gInventory at: 15) setHotspot: 8 10) ; Salt_Water, Do, Exit
				)
				(43
					(if scratch
						(self addRespondVerb: 57) ; Mask
					else
						(self setHotspot: 0 57) ; Mask
					)
					((gInventory at: 43) setHotspot: 8 10) ; Mask, Do, Exit
				)
				(else
					((gInventory at: param1) setHotspot: 8 10) ; Do, Exit
				)
			)
		)
	)

	(method (put param1 param2 &tmp temp0)
		(-- gInventoryCount)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(temp0 hide:)
			(if (== temp0 global308)
				(gUser message: 10)
				(if (gUser canInput:)
					(gGame setCursor: (gNormalCursor cel: 0 yourself:))
				else
					(gGame oldCurs: gNormalCursor)
				)
				(= global311 0)
				(= global308 0)
			)
			((ScriptID 18 2) doit:) ; reposition
			(if (global124 contains: temp0)
				(global124 delete: temp0)
			)
			(switch param1
				(1
					(if (gEgo has: 3) ; Stick
						((gInventory at: 3) deleteHotspot:) ; Stick
						((gInventory at: 1) deleteHotspot:) ; Ripped_Petticoat
					)
				)
				(3
					(if (gEgo has: 1) ; Ripped_Petticoat
						((gInventory at: 3) deleteHotspot:) ; Stick
						((gInventory at: 1) deleteHotspot:) ; Ripped_Petticoat
					)
				)
				(5
					(if (gEgo has: 12) ; Turquoise_Piece_b
						((gInventory at: 12) deleteHotspot:) ; Turquoise_Piece_b
						((gInventory at: 5) deleteHotspot:) ; Turquoise_Piece_a
					)
				)
				(12
					(if (gEgo has: 5) ; Turquoise_Piece_a
						((gInventory at: 12) deleteHotspot:) ; Turquoise_Piece_b
						((gInventory at: 5) deleteHotspot:) ; Turquoise_Piece_a
					)
				)
				(28
					(if (gEgo has: 61) ; Woolen_Stocking
						((gInventory at: 61) deleteHotspot:) ; Woolen_Stocking
						((gInventory at: 28) deleteHotspot:) ; Silver_Pellet
					)
				)
				(61
					(if (gEgo has: 28) ; Silver_Pellet
						((gInventory at: 61) deleteHotspot:) ; Woolen_Stocking
						((gInventory at: 28) deleteHotspot:) ; Silver_Pellet
					)
				)
				(0
					(if (gEgo has: 47) ; Magic_Statue
						((gInventory at: 47) deleteHotspot:) ; Magic_Statue
					)
				)
				(47
					(if (gEgo has: 0) ; Golden_Comb
						((gInventory at: 47) deleteHotspot:) ; Magic_Statue
					)
				)
				(55
					(if (gEgo has: 53) ; Magic_Wand
						((gInventory at: 55) deleteHotspot:) ; Scarab
					)
				)
				(53
					(if (gEgo has: 55) ; Scarab
						((gInventory at: 55) deleteHotspot:) ; Scarab
					)
				)
				(else
					((gInventory at: param1) deleteHotspot:)
				)
			)
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: gValOrRoz)
		)
	)

	(method (doit &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (& signal $0001)
			(if mover
				(mover doit:)
			)
			(if cycler
				(cycler doit:)
			)
			(if (& -info- $0008)
				(if scaler
					(scaler doit:)
				)
				(= xLast x)
				(= yLast y)
				(if (self isNotHidden:)
					(UpdateScreenItem self)
				)
				(if
					(and
						(& scaleSignal $0001)
						(not (& scaleSignal $0004))
						(!= scaleX oldScaleX)
					)
					(= oldScaleX scaleX)
					(= temp2
						(if
							(>=
								(= temp4
									(>>
										(+ (* (>> origStep $0008) scaleX) 64)
										$0007
									)
								)
								2
							)
							temp4
						else
							2
						)
					)
					(= temp3
						(if
							(>=
								(= temp4
									(>>
										(+ (* (& origStep $00ff) scaleY) 64)
										$0007
									)
								)
								2
							)
							temp4
						else
							2
						)
					)
					(if (or (!= temp2 xStep) (!= temp3 yStep))
						(self setStep: temp2 temp3 1)
					)
				)
				(cond
					((not (& signal $0020)))
					(baseSetter
						(baseSetter doit: self)
					)
					(else
						(BaseSetter self)
					)
				)
			)
		)
		(= edgeHit
			(cond
				((not (gGame isHandsOn:)) 0)
				((<= x (gCurRoom edgeW:)) 4)
				((>= x (gCurRoom eastSide:)) 2)
				((> y (gCurRoom edgeS:)) 3)
				((<= y (+ (gCurRoom horizon:) (gEgo yStep:))) 1)
				(else 0)
			)
		)
	)

	(method (setHeading param1 param2 &tmp [temp0 4])
		(if argc
			(cond
				((<= 15 param1 80)
					(= param1 45)
				)
				((<= 100 param1 165)
					(= param1 135)
				)
				((<= 195 param1 260)
					(= param1 225)
				)
				((<= 280 param1 345)
					(= param1 315)
				)
			)
			(if (== heading param1)
				(if (and (> argc 1) param2)
					(param2 cue:)
				)
				(return heading)
			)
		)
		(if argc
			(= heading param1)
		)
		(if looper
			(looper doit: self heading (and (>= argc 2) param2))
		else
			(DirLoop self heading)
			(if cycler
				(cycler clientLastCel: (self lastCel:))
			)
			(if (and (>= argc 2) param2)
				(param2 cue: &rest)
			)
		)
		(return heading)
	)
)

(instance aEgoTalker of KQTalker
	(properties)

	(method (init)
		(cond
			(
				(and
					(not
						(OneOf
							(client view:)
							2241
							800
							836
							870
							902
							9021
							9022
						)
					)
					(== view -1)
				)
				0
			)
			((and (!= (client loop:) 8) (== view -1) (!= (client signal:) 8))
				(client cel: (client loop:) setLoop: 8)
				(UpdateScreenItem client)
			)
		)
		(super init: &rest)
	)
)

(instance combCry of Script
	(properties)

	(method (dispose)
		(kqEgoSound stop: dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 8241
					setLoop: (if (< 0 (gEgo heading:) 180) 0 else 1)
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 21 1 self
				)
			)
			(1
				(kqEgoSound number: 1256 setLoop: -1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo setCycle: CT 20 -1 self)
			)
			(3
				(kqEgoSound setLoop: 1 stop:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo deleteHotVerb: 5 normalize: 5 cycleSpeed: register) ; Golden_Comb
				(if (and (OneOf gCurRoomNum 1600 1500) global312)
					(gCurRoom notify:)
				)
				(SetFlag 270)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cleanHorn of Script
	(properties)

	(method (dispose)
		(kqEgoSound stop: dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				(= register (gEgo heading:))
				(gEgo
					view: 1205
					setLoop: (if (< 0 (gEgo heading:) 179) 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(if (IsFlag 325)
					(= cycles 1)
				else
					(gMessager say: 2 18 1 0 self 800) ; "Oh Dear, the horn is clogged with sand."
				)
			)
			(3
				(if (IsFlag 325)
					(gEgo
						setLoop: (if (< 0 (gEgo heading:) 179) 3 else 2)
						setCel: 0
						setCycle: CT 2 1 self
					)
				else
					(gEgo
						view: 1206
						setLoop: (if (< 0 (gEgo heading:) 179) 1 else 0)
						setCel: 0
						setCycle: CT 2 1 self
					)
				)
			)
			(4
				(if (IsFlag 325)
					(gEgo setCycle: End self)
					(kqEgoSound number: 1210 play: self)
				else
					(gEgo setCycle: End self)
					(kqEgoSound number: 1215 setLoop: 1 play: self)
				)
			)
			(5 0)
			(6
				(gEgo
					view: 1205
					setLoop: (if (< 0 (gEgo heading:) 179) 1 else 0)
					setCel: 12
					setCycle: Beg self
				)
			)
			(7
				(gEgo normalize: 2)
				(if (and (OneOf gCurRoomNum 1600 1500) global312)
					(gCurRoom notify:)
				)
				(= cycles 2)
			)
			(8
				(if (IsFlag 325)
					(= cycles 1)
				else
					(gMessager say: 2 18 0 0 self 800) ; "(Coughs) Being long-winded comes in handy sometimes."
				)
			)
			(9
				(SetFlag 325)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eatBeetles of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(if
					(and
						(== gCurRoomNum 2500)
						(!= (gEgo x:) 95)
						(!= (gEgo y:) 116)
					)
					(-- state)
					(gEgo setMotion: PolyPath 95 116 self)
				else
					(gEgo setMotion: 0 setHeading: 225 self)
				)
				(Load 140 (+ 2518 global319)) ; WAVE
				(kqEgoSound number: (+ 2518 global319))
				(Load rsVIEW 9080)
				(Load rsVIEW (+ 9080 global319))
			)
			(1
				(gEgo
					cycleSpeed: 10
					view: 9080
					setLoop: 1
					setCel: 0
					setCycle: 0
				)
				(= ticks 1)
			)
			(2
				(gEgo setCycle: CT 4 1 self)
			)
			(3
				(kqEgoSound setLoop: -1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setCycle: CT (- (gEgo lastCel:) 4) -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setCycle: CT (- (gEgo lastCel:) 3) -1 self)
			)
			(7
				(if global319
					(gEgo
						view: (+ 9080 global319)
						setCel: 0
						setCycle: End self
					)
					(if (== global319 2)
						(kqEgoSound stop:)
						(kqEgoSound number: 2521 setLoop: -1 play:)
					)
				else
					(= cycles 1)
				)
			)
			(8
				(kqEgoSound setLoop: 1 stop:)
				(if (== (++ global319) 3)
					(= global319 0)
					(if (OneOf gCurRoomNum 2000 2550)
						(EgoDead 61 self 1)
					else
						(EgoDead 61 self)
					)
					(UpdateScreenItem
						((gInventory at: 26) ; Baked_Beetles
							loop: 0
							cView: 991
							cLoop: 0
							cCel: 7
							yourself:
						)
					)
				else
					(= temp0 (gInventory at: 26)) ; Baked_Beetles
					(temp0
						loop: global319
						cView: 991
						cLoop: 6
						cCel: (if (== global319 1) 1 else 3)
					)
					(gTheInvCursor
						view: (temp0 cView:)
						loop: (temp0 cLoop:)
						cel: (- (temp0 cCel:) 1)
					)
					(if (== global319 1)
						(gMessager say: 1 35 1 1 self 800) ; "Mmmmmm!"
					else
						(self cue:)
					)
				)
			)
			(9
				(gEgo normalize: 2 cycleSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tapestryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(SetFlag 213)
				(gEgo
					view: (if (== gCurRoomNum 4550) 45500 else 6155)
					loop: 0
					cel: 0
					cycleSpeed: 6
					setMotion: 0
					setCycle: CT 39 1 self
				)
			)
			(1
				(kqEgoSound number: 831 loop: 1 play:)
				(gEgo
					view: (if (== gCurRoomNum 4550) 45500 else 6155)
					loop: 0
					setCycle: End self
				)
			)
			(2
				(gEgo cycleSpeed: register hide:)
				(= cycles 3)
			)
			(3
				(if (gEgo has: 68) ; Dream_Catcher
					(gCurRoom newRoom: 6350)
				else
					(gCurRoom newRoom: 6500)
				)
			)
		)
	)
)

(instance egoDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 9090
					loop: (if (< (gEgo heading:) 180) 0 else 1)
					cel: 0
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(1
				(kqEgoSound number: 892 setLoop: 1 play:)
				(= ticks 150)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo put: 16 get: 2 cycleSpeed: register normalize:) ; Fresh_Water, Clay_Pot
				(if (and (OneOf gCurRoomNum 1600 1500) global312)
					(gCurRoom notify:)
				)
				(gUser canInput: 1 canControl: 1)
				((gInventory at: 2) doVerb: 8) ; Clay_Pot
				(self dispose:)
			)
		)
	)
)

(instance egoDrinkNectar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 9090
					loop: (if (< (gEgo heading:) 180) 0 else 1)
					cel: 0
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(1
				(= ticks 90)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: (if (gEgo loop:) 1 else 0))
				(= cycles 2)
			)
			(4
				(gMessager say: 1 8 1 0 self 6300) ; "Mmmmmmm!"
			)
			(5
				(gEgo cycleSpeed: register)
				(if (and (OneOf gCurRoomNum 1600 1500) global312)
					(gCurRoom notify:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eatSaltScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: (if (== gValOrRoz -4) 9016 else 9023) ; Val
					loop: (if (< (gEgo heading:) 180) 0 else 1)
					cel: 0
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(1
				(gEgo put: 21 cycleSpeed: register normalize:) ; Salt_Crystals
				(= cycles 2)
			)
			(2
				(if (and (OneOf gCurRoomNum 1600 1500) global312)
					(gCurRoom notify:)
				)
				(if (== gValOrRoz -4) ; Val
					(SetFlag 122)
					(gMessager say: 2 51 0 0 self 800) ; "(Cough, cough) That's salty!"
				else
					(SetFlag 149)
					(gMessager say: 1 51 0 0 self 800) ; "(Cough, cough) That's salty!"
				)
			)
			(3
				(if (== gCurRoomNum 5300)
					(gCurRoom notify:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoPourSaltW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo heading:))
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 9193 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(kqEgoSound number: 836 setLoop: 1 play:)
			)
			(3
				(gEgo put: 15 get: 2 normalize: 2) ; Salt_Water, Clay_Pot
				(gGame handsOn:)
				((gInventory at: 2) doVerb: 8) ; Clay_Pot
				(self dispose:)
			)
		)
	)
)

(instance putOnVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(SetFlag 151)
				(gEgo view: 4112 loop: 0 cel: 0 setCycle: End self put: 54) ; Veil
			)
			(2
				(gEgo put: 54 normalize:) ; Veil
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flyHorseScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= scratch 1)
				(switch gCurRoomNum
					(4000
						(= temp0 33)
						(= temp2 113)
						(= temp3 9017)
						(= temp4 1)
					)
					(4050
						(= temp0 33)
						(= temp2 113)
						(= temp3 9017)
						(= temp4 1)
					)
					(4101
						(= temp0 290)
						(= temp2 126)
						(= temp3 9017)
						(= temp4 0)
					)
					(4102
						(= temp0 290)
						(= temp2 126)
						(= temp3 9017)
						(= temp4 0)
					)
					(4250
						(= temp0 30)
						(= temp2 117)
						(= temp3 9017)
						(= temp4 1)
					)
					(4350
						(= temp0 290)
						(= temp2 108)
						(= temp3 9017)
						(= temp4 0)
					)
					(4400
						(= temp0 30)
						(= temp2 103)
						(= temp3 9017)
						(= temp4 1)
					)
					(4550
						(if
							(<
								(Abs (- (gEgo x:) 290))
								(Abs (- (gEgo x:) 620))
							)
							(= temp0 290)
							(= temp2 105)
							(= temp3 45560)
							(= temp4 0)
							(= scratch 0)
						else
							(= temp0 620)
							(= temp2 115)
							(= temp3 45560)
							(= temp4 0)
							(= scratch -319)
						)
					)
					(5300
						(if
							(<
								(Abs (- (gEgo x:) 290))
								(Abs (- (gEgo x:) 560))
							)
							(= temp0 290)
							(= temp2 100)
							(= temp3 9018)
							(= temp4 0)
							(= scratch 0)
						else
							(= temp0 560)
							(= temp2 129)
							(= temp3 9018)
							(= temp4 0)
							(= scratch -319)
						)
					)
					(5400
						(= temp0 290)
						(= temp2 111)
						(= temp3 9018)
						(= temp4 0)
					)
					(1100
						(= temp0 30)
						(= temp2 130)
						(= temp3 9019)
						(= temp4 1)
					)
					(1102
						(= temp0 30)
						(= temp2 130)
						(= temp3 9019)
						(= temp4 1)
					)
					(1150
						(= temp0 290)
						(= temp2 125)
						(= temp3 9019)
						(= temp4 0)
					)
					(1110
						(= temp0 290)
						(= temp2 125)
						(= temp3 9019)
						(= temp4 0)
					)
					(1250
						(cond
							((< (gEgo x:) 450)
								(= temp0 300)
								(= temp2 135)
								(= temp3 9019)
								(= temp4 0)
								(= scratch 0)
							)
							((< (gEgo x:) 750)
								(= temp0 612)
								(= temp2 144)
								(= temp3 9019)
								(= temp4 0)
								(= scratch -319)
							)
							(else
								(= temp0 925)
								(= temp2 128)
								(= temp3 9019)
								(= temp4 0)
								(= scratch 64897)
							)
						)
					)
					(1300
						(= temp0 30)
						(= temp2 129)
						(= temp3 9019)
						(= temp4 1)
					)
					(1350
						(= temp0 30)
						(= temp2 129)
						(= temp3 9019)
						(= temp4 1)
					)
					(1500
						(= temp0 30)
						(= temp2 129)
						(= temp3 9019)
						(= temp4 1)
					)
					(1600
						(= temp0 290)
						(= temp2 121)
						(= temp3 9019)
						(= temp4 0)
					)
					(3000
						(= temp0 290)
						(= temp2 135)
						(= temp3 9018)
						(= temp4 0)
					)
					(3050
						(= temp0 290)
						(= temp2 80)
						(= temp3 9018)
						(= temp4 0)
					)
					(3100
						(= temp0 30)
						(= temp2 125)
						(= temp3 9018)
						(= temp4 1)
					)
					(3150
						(if
							(<
								(Abs (- (gEgo x:) 290))
								(Abs (- (gEgo x:) 620))
							)
							(= temp0 290)
							(= temp2 125)
							(= temp3 9018)
							(= temp4 0)
							(= scratch 0)
						else
							(= temp0 620)
							(= temp2 105)
							(= temp3 9018)
							(= temp4 0)
							(= scratch -319)
						)
					)
					(3200
						(= temp0 290)
						(= temp2 106)
						(= temp3 9018)
						(= temp4 0)
					)
					(3250
						(= temp0 43)
						(= temp2 102)
						(= temp3 9018)
						(= temp4 1)
					)
					(3300
						(= temp0 303)
						(= temp2 130)
						(= temp3 9018)
						(= temp4 1)
					)
				)
				((= register (Prop new:)) view: temp3 loop: temp4)
				(if (or (and global312 (== gCurRoomNum 1500)) (== gCurRoomNum 1600))
					(gEgo setMotion: DuneMover temp0 temp2 self)
				else
					(gEgo setMotion: PolyPath temp0 temp2 self)
				)
			)
			(1
				(if (< scratch 1)
					(gCurRoom centerScreen: scratch self 10)
				else
					(self cue:)
				)
			)
			(2
				(if (register loop:)
					(gEgo setHeading: 225 self)
				else
					(gEgo setHeading: 135 self)
				)
			)
			(3
				(gEgo
					view: 9024
					loop: (register loop:)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gSounds eachElementDo: #pause 1)
				(gEgo loop: (+ (gEgo loop:) 2) cel: 0 setCycle: Fwd)
				(kqEgoSound number: 946 setLoop: 1 play: self)
			)
			(5
				(gEgo loop: (- (gEgo loop:) 2))
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(6
				(gEgo normalize:)
				(UpdateScreenItem gEgo)
				(register
					x: (gEgo x:)
					y: (- (gEgo y:) 1)
					z: 1
					scaleSignal: 1
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					init:
					setPri: (gEgo priority:)
					setCycle: CT 3 1 self
				)
				(if (register loop:)
					(gEgo setHeading: 45)
				else
					(gEgo setHeading: 315)
				)
			)
			(7
				(kqEgoSound number: 6202 setLoop: 1 play:)
				(register setCycle: CT 11 1 self)
			)
			(8
				(gKqSound1 number: 4104 setLoop: 1 play:)
				(register setCycle: End self)
			)
			(9
				(gEgo hide:)
				(register loop: (+ (register loop:) 2) cel: 0)
				(UpdateScreenItem register)
				(register setCycle: CT 18 1 self)
			)
			(10
				(gKqSound1 number: 4107 setLoop: 1 play:)
				(register setCycle: CT 24 1 self)
			)
			(11
				(register setCycle: End self)
				(kqEgoSound number: 6203 setLoop: 1 play:)
			)
			(12
				(register dispose:)
				(= register 0)
				(gSounds eachElementDo: #pause 0)
				(gCurRoom newRoom: 6200)
			)
		)
	)

	(method (dispose)
		(if register
			(register dispose:)
		)
		(= register 0)
		(super dispose:)
	)
)

(instance kqEgoSound of Sound
	(properties)
)

