;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use KQ6Print)
(use n913)
(use Sound)
(use Motion)
(use User)
(use System)

(public
	openBook 0
	spellBookScr 1
	makeRainScript 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 4]
	local14 = 110
	local15 = 1
	[local16 200]
	[local216 200]
	[local416 200]
	local616
)

(instance openBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local616 (gEgo cel:))
				(= seconds 2)
			)
			(1
				(gEgo
					normal: 0
					view: 903
					cel: 0
					setLoop: 2
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(client setScript: (ScriptID 190 1)) ; spellBookScr
			)
		)
	)
)

(instance spellBookScr of Script
	(properties)

	(method (init)
		(gGame handsOff:)
		(User canInput: 1)
		(= local0 gCast)
		(= local1 gFeatures)
		(= local2 gAddToPics)
		(= local3 gMouseDownHandler)
		(= local4 gKeyDownHandler)
		(= local5 gDirectionHandler)
		(= local6 gWalkHandler)
		(= local7 (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gCast (EventHandler new:)) name: {newCast} add:)
		((= gFeatures (EventHandler new:)) name: {newFeatures} add: self)
		((= gAddToPics (EventHandler new:)) name: {newATPs} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {newMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {newKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {newDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {newWH} add:)
		(if register
			(gInventory hide:)
			(= register 0)
		)
		(gTheIconBar disable:)
		(DrawPic 98 10)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if local15
			(return)
		)
		(cond
			(
				(and
					(&
						(= temp0
							(OnControl
								CONTROL
								((User curEvent:) x:)
								((User curEvent:) y:)
							)
						)
						$0002
					)
					(!= local8 2)
				)
				(= local8 2)
				(SetCursor 190 0 1)
			)
			((and (& temp0 $0004) (!= local8 3))
				(= local8 3)
				(SetCursor 190 0 2)
			)
			((and (& temp0 $0008) (!= local8 4))
				(if (!= local8 4)
					(= local8 4)
					(SetCursor 190 0 0)
				)
			)
			((and (& temp0 $4000) (!= local8 1))
				(= local8 1)
				(gGame setCursor: ((gTheIconBar at: 2) cursor:))
			)
			((and (not (& temp0 $400e)) (!= local8 5))
				(= local8 5)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (event claimed:))
			)
			(switch local8
				(1
					(gMessager
						say:
							(switch local9
								(0 4)
								(1 5)
								(2 6)
							)
							1
							0
							0
							0
							190
					)
				)
				(2
					(if (> local9 0)
						(gGame handsOff:)
						(-- local9)
						(= state -1)
						(self cue:)
					else
						(gMessager say: 2 5 0 0 0 190) ; "This is the first page."
					)
				)
				(3
					(if (< local9 2)
						(gGame handsOff:)
						(++ local9)
						(= state -1)
						(self cue:)
					else
						(gMessager say: 1 5 0 0 0 190) ; "This is the last page."
					)
				)
				(4
					(self cue:)
				)
				(5
					(self dispose:)
				)
			)
			(= local8 -1)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(switch local9
					(0
						1
						(= register 12)
					)
					(1
						0
						(= register 16)
					)
					(2
						2
						(= register 18)
					)
				)
				(Message msgGET 190 3 0 register 1 @local16)
				(= cycles 1)
			)
			(1
				(switch local9
					(0
						1
						(= register 13)
					)
					(1
						0
						(= register 17)
					)
					(2
						2
						(= register 19)
					)
				)
				(Message msgGET 190 3 0 register 1 @local216)
				(= cycles 1)
			)
			(2
				(switch local9
					(0
						1
						(= register 14)
					)
					(1
						0
						(= register 20)
					)
					(2
						2
						(= register 21)
					)
				)
				(Message msgGET 190 3 0 register 1 @local416)
				(= register 0)
				(= cycles 1)
			)
			(3
				(DrawPic 190 10)
				(self cue:)
			)
			(4
				(Display @local416 dsCOORD 45 30 dsWIDTH local14 dsCOLOR 98 dsFONT 1111)
				(if (== local9 2)
					(= temp1 49)
				else
					(= temp1 40)
				)
				(Display @local16 dsCOORD 45 temp1 dsWIDTH local14 dsCOLOR 98 dsFONT 1111)
				(Display {INCANTATION:} dsCOORD 178 27 dsWIDTH 100 dsCOLOR 98 dsFONT 1111)
				(Display @local216 dsCOORD 178 37 dsWIDTH 100 dsCOLOR 98 dsFONT 1111)
				(User canInput: 1 canControl: 1)
				(= local8 999)
				(= local15 0)
			)
			(5
				(-- state)
				(switch local9
					(0
						(if
							(or
								(!= gCurRoomNum 230)
								(not (IsFlag 23))
								(and (IsFlag 23) (IsFlag 24))
							)
							(gMessager say: 4 2 5 0 0 190) ; "Speaking the incantation would do little good unless there was a painted object nearby to enchant."
						else
							(= register 1)
							(self dispose:)
						)
					)
					(2
						(= temp0 ((gInventory at: 11) state:)) ; skull
						(cond
							(
								(and
									(OneOf temp0 15 7)
									(or
										(!= gCurRoomNum 340)
										(and
											(== gCurRoomNum 340)
											(not
												(local0
													contains: (ScriptID 344 2) ; nightMare
												)
											)
										)
									)
								)
								(gMessager say: 6 2 2 0 0 190) ; "The incantation would do little good without a "Creature of the Night" to charm!"
							)
							(
								(and
									(OneOf temp0 15 7)
									(== gCurRoomNum 340)
									(local0 contains: (ScriptID 344 2)) ; nightMare
								)
								(= register 1)
								(self dispose:)
							)
							(else
								(gMessager say: 6 2 11 0 0 190) ; "This spell must be cast over a skull containing hot embers, a strand of hair, and brimstone (sulphur)."
							)
						)
					)
					(1
						(cond
							((and (gEgo has: 19) (== global161 15)) ; huntersLamp
								(gMessager say: 5 2 23 0 0 190) ; "The hunter's lamp is already as "enchanted" as it's ever going to get."
							)
							((== global161 7)
								(|= global161 $0008)
								(= register 4660)
								(SetFlag 31)
								(self dispose:)
							)
							(else
								(gMessager say: 5 2 11 0 0 190) ; "This spell must be cast over a teapot containing salt water, sacred water, and falling water."
							)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(gGame setCursor: gWaitCursor)
		(super dispose:)
		(gCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(gAddToPics dispose:)
		(gFeatures delete: self dispose:)
		(gMouseDownHandler delete: self dispose:)
		(gKeyDownHandler delete: self dispose:)
		(gDirectionHandler delete: self dispose:)
		(gWalkHandler delete: self dispose:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: local7)
		(= gCast local0)
		(= gFeatures local1)
		(= gMouseDownHandler local3)
		(= gKeyDownHandler local4)
		(= gDirectionHandler local5)
		(= gWalkHandler local6)
		(= gAddToPics local2)
		(gEgo reset: 2)
		(if (== gCurRoomNum 781)
			(gEgo setPri: 13)
		)
		(DrawPic (gCurRoom picture:) 100)
		(if gAddToPics
			(gAddToPics doit:)
		)
		(gTheIconBar enable:)
		(gGame handsOn:)
		(switch register
			(1
				(Animate (gCast elements:) 1)
				(if
					(not
						(and
							(== local9 2)
							(not (& ((gInventory at: 11) state:) $0008)) ; skull
						)
					)
					(gGame givePoints: 3)
				)
				(gCurRoom notify:)
			)
			(4660
				(gGame givePoints: 3)
				(Animate (gCast elements:) 1)
				(gCurRoom setScript: (ScriptID 190 2)) ; makeRainScript
			)
		)
		(if (!= (gCurRoom script:) makeRainScript)
			(DisposeScript 190)
		)
	)
)

(instance localSound of Sound
	(properties)
)

(instance makeRainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 59)
				(gMessager say: 3 0 9 1 self 0) ; "Alexander prepares to enchant the hunter's lamp with the "Make Rain Spell" incantation."
			)
			(1
				(KQ6Print say: 0 3 0 9 2 0 0 0 posn: 10 10 width: 289 init:) ; "Clouds of thunder, shafts of light, Come and sup with me tonight. Waters three have I for tea, Brew a tempest now for me!"
				(gEgo
					normal: 0
					view: 586
					cel: 0
					setLoop: 0
					cycleSpeed: 5
					setCycle: Fwd
				)
				(= seconds 13)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localSound number: 945 loop: 1 play:)
				(gEgo cel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: CT 0 -1 self)
			)
			(4
				(gEgo setCycle: CT 2 1 self)
			)
			(5
				(gEgo setCycle: CT 0 -1 self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(gMessager say: 3 0 9 3 self 0) ; "The lamp in Alexander's hand gives a little perk. He hopes the spell works despite his makeshift "teapot!""
			)
			(8
				(ClearFlag 59)
				(gEgo reset: local616)
				(if (== gCurRoomNum 781)
					(gEgo setPri: 13)
				)
				(localSound stop: dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 190)
	)
)

