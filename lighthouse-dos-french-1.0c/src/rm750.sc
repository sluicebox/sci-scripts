;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use LightRoom)
(use Messager)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm750 0
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

(instance rm750 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(roomMusic play:)
		(gBackMusic setVol: 64)
		(= local5 1)
		(switch gPrevRoomNum
			(720
				(self changeScene: 2752 4)
			)
			(else
				(self changeScene: 2758 15)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(lirylProp2752 dispose:)
		(lirylFeat2752 dispose:)
		(lirylFeat2755 dispose:)
		(pedestal2752 dispose:)
		(button2752 dispose:)
		(cd2752 dispose:)
		(door2752 dispose:)
		(lirylControl2755 dispose:)
		(lirylLights2755 dispose:)
		(switch param1
			(2752
				(cond
					((and (== global236 750) (IsFlag 286) local5)
						(ClearFlag 286)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylEnter)
					)
					(local4
						(= local4 0)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylLeavePissed)
					)
					((or local0 (== global236 750))
						(= local0 1)
						(lirylFeat2752 init:)
						(lirylProp2752 init:)
					)
				)
				(= local5 0)
				(if (not local0)
					(door2752 init:)
				)
				(button2752 init:)
				(pedestal2752 init:)
				(if (IsFlag 284)
					(cd2752 init:)
				)
				((ScriptID 1 1) newPic: 2757 11 exitCode: cExitForward2752) ; exitForward
				((ScriptID 1 2) newPic: 2753 8 exitCode: cExitBack2752) ; exitBack
			)
			(2753
				((ScriptID 1 1) newRoom: 720) ; exitForward
				((ScriptID 1 2) newPic: 2752 4) ; exitBack
			)
			(2755
				(lirylFeat2755 init:)
				(lirylControl2755 init:)
				(lirylLights2755 init:)
				((ScriptID 1 7) newPic: 2752 4) ; exitBackUp
				((ScriptID 1 3) newPic: 2757 11) ; exitLeft
				(if local2
					(= local2 0)
					(lirylFeat2755 doVerb: 5)
				)
			)
			(2757
				((ScriptID 1 1) newRoom: 715) ; exitForward
				((ScriptID 1 2) newPic: 2758 15) ; exitBack
			)
			(2758
				((ScriptID 1 2) newPic: 2757 11) ; exitBack
				((ScriptID 1 1) newPic: 2753 8) ; exitForward
				(= local5 0)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(roomMusic fade: 0 10 7 0)
		(super newRoom: newRoomNumber)
	)
)

(instance roomMusic of Sound
	(properties
		number 752
		loop -1
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance cExitForward2752 of Code
	(properties)

	(method (doit)
		(if (== (gCurRoom script:) sDoHolo)
			(sDoHolo dispose:)
		else
			(gCurRoom changeScene: 2757 11)
		)
	)
)

(instance cExitBack2752 of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((== (gCurRoom script:) sDoHolo)
				(sDoHolo dispose:)
			)
			((not local0)
				(cond
					((< (= temp0 (Random 1 8)) 4)
						(= global236 750)
						(SetFlag 286)
					)
					((< temp0 7)
						(if (!= global236 740)
							(SetFlag 286)
						)
						(= global236 740)
					)
					(else
						(if (!= global236 765)
							(SetFlag 286)
						)
						(= global236 765)
					)
				)
				(gCurRoom changeScene: 2753 8)
			)
			(else
				(cond
					((< (= temp0 (Random 1 8)) 4)
						(= global236 750)
					)
					((< temp0 7)
						(if (!= global236 740)
							(SetFlag 286)
						)
						(= global236 740)
					)
					(else
						(if (!= global236 765)
							(SetFlag 286)
						)
						(= global236 765)
					)
				)
				(if (!= global236 750)
					(gGame handsOff:)
					(gCurRoom setScript: sLirylExit)
				else
					(gCurRoom changeScene: 2753 8)
				)
			)
		)
	)
)

(instance door2752 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 339 118 371 115 407 139 418 187 398 225 321 211 305 176 306 145
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (== (gCurRoom script:) sDoHolo))
					(roomSfx number: 776 play:)
					(if
						(and
							(not local0)
							(IsFlag 256)
							(not (IsFlag 234))
							(== (Random 1 6) 1)
						)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylEnter)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylFeat2752 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 356 92 389 106 388 138 369 159 332 158 311 132 332 106
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (== (gCurRoom script:) sDoHolo))
					(= local2 1)
					(gCurRoom changeScene: 2755 10)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylProp2752 of Prop
	(properties
		x 239
		y 282
		view 2752
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance sLirylEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 286)
				(= register (gCurRoom picture:))
				(gCurRoom drawPic: 2752)
				(KillRobot 2752 0 0)
			)
			(1
				(= local0 1)
				(= global236 750)
				(gCurRoom drawPic: register)
				(if (== (gCurRoom scene:) 2752)
					(lirylFeat2752 init:)
					(lirylProp2752 init:)
					(door2752 dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 3752 0 0)
				(= local0 0)
			)
			(1
				(self dispose:)
				(gGame handsOn:)
				(gCurRoom changeScene: 2753 8)
			)
		)
	)
)

(instance sLirylLeavePissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(KillRobot 3752 0 0)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cd2752 of View
	(properties
		x 23
		y 257
		view 2753
	)
)

(instance pedestal2752 of Feature
	(properties
		nsBottom 274
		nsLeft 12
		nsRight 130
		nsTop 212
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; invCD
				(SetFlag 284)
				(roomSfx number: 779 play:)
				(cd2752 init:)
				(gInventory deleteItem: (ScriptID 9 51)) ; invCD
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button2752 of Feature
	(properties
		nsBottom 250
		nsLeft 106
		nsRight 128
		nsTop 233
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not (== (gCurRoom script:) sDoHolo)) (IsFlag 284))
					(gCurRoom setScript: sDoHolo)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holoFace of Prop
	(properties
		x 228
		y 196
		view 176
	)

	(method (init)
		(self cel: (self lastCel:))
		(super init: &rest)
	)
)

(instance holoRing of Prop
	(properties
		x 227
		y 205
		view 2760
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)
)

(instance holoScene of Prop
	(properties
		x 224
		y 151
		view 2763
	)

	(method (init)
		(super init: &rest)
		(self setPri: 202)
		(= cycleSpeed 8)
	)
)

(instance holoMusic of Sound
	(properties
		number 778
		loop -1
	)
)

(instance holoMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(gNarrator modeless: 2)
		(if
			(= temp0
				(switch param1
					(4
						(ScriptID 15 0) ; lirylTalker
					)
					(7
						(ScriptID 15 0) ; lirylTalker
					)
					(6
						(ScriptID 15 0) ; lirylTalker
					)
					(3
						(ScriptID 380 1) ; krickTalker
					)
					(else gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance sDoHolo of Script
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gUser canInput: 1)
		(gInventory disable: 1)
		(gPanels delete: (ScriptID 9 1)) ; PlInterface
	)

	(method (dispose &tmp temp0)
		(gMouseDownHandler delete: self)
		(if local3
			(= gMessager local3)
		)
		(gPanels add: (ScriptID 9 1)) ; PlInterface
		(gInventory disable: 0)
		(SetFlag 199)
		(ClearFlag 253)
		(holoMusic stop:)
		(roomMusic setVol: 127)
		(holoFace dispose:)
		(holoRing dispose:)
		(holoScene dispose:)
		(gCurRoom changeScene: 2752 4)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((not (& (event type:) evMOUSEBUTTON))
				(return 0)
			)
			(else
				(self dispose:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local0 (not (IsFlag 199)))
					(lirylProp2752 hide:)
					(cd2752 hide:)
					(gCurRoom drawPic: 2755)
				)
				(= cycles 2)
			)
			(1
				(if (and local0 (not (IsFlag 199)))
					(gMessager say: 11 23 20 3 self 720) ; "(excited, triumphant)Now I can tell the storiessss(hiss)!"
				else
					(= cycles 2)
				)
			)
			(2
				(= local3 gMessager)
				(= gMessager holoMessager)
				(if (and local0 (not (IsFlag 199)))
					(lirylProp2752 show:)
					(cd2752 show:)
					(gCurRoom drawPic: 2752)
				)
				(= cycles 2)
			)
			(3
				(roomMusic setVol: 64)
				(holoMusic play:)
				(SetFlag 253)
				(holoFace view: 176 x: 228 y: 196 init: setCycle: Beg self)
			)
			(4
				(holoRing init: setCycle: Fwd)
				(holoFace view: 5173 loop: 0 x: 227 y: 198)
				(= ticks 180)
			)
			(5
				(Load rsVIEW 2763)
				(gMessager say: 13 0 22 1 self 720) ; "(The Hologram speaks in the clear, well-trained voice of the professional story-teller )I am Liryl, Guardian and Sacred Ward of the Temple of Ancient Machines. I came here when I was four years old. There was an accident... The priests put me in a machine to save my life. It is my heartbeat, my breath, and my blood. I have been trained in the art of the story, the remembrance of things past. Listen and learn our history."
				(= ticks 720)
			)
			(6
				(holoScene
					view: 2763
					init:
					cel: 0
					x: 224
					y: 151
					setCycle: End self
				)
			)
			(7
				(= ticks 300)
			)
			(8
				(holoScene setCycle: Beg self)
			)
			(9
				(holoScene dispose:)
			)
			(10
				(Load rsVIEW 2761)
				(gMessager say: 13 0 22 2 self 720) ; "A long time ago, a powerful people ruled this world. They were masters of machines. There was nothing they could not build in their factories. No obstacle nature put in their path could defeat them, but their blind desire for progress became their doom."
				(= ticks 360)
			)
			(11
				(holoScene
					view: 2761
					init:
					cel: 0
					x: 165
					y: 160
					setCycle: End self
				)
			)
			(12
				(holoScene setCycle: Beg self)
			)
			(13
				(if (not (holoScene cycler:))
					(holoScene dispose:)
				)
			)
			(14
				(holoScene dispose:)
				(= ticks 60)
			)
			(15
				(Load rsVIEW 2762)
				(gMessager say: 13 0 22 3 self 720) ; "The world became polluted. The animals died, and the oceans stank. The sky became yellow, and the sun shone through a sickly haze. Finally, the land itself died. All but the strongest and most isolated perished. Disease and famine consumed them. Those that remained lived only to survive, and the old ways were lost."
				(= ticks 360)
			)
			(16
				(holoScene
					view: 2762
					init:
					cel: 0
					x: 164
					y: 162
					setCycle: End self
				)
			)
			(17
				(holoScene dispose:)
			)
			(18
				(gMessager say: 13 0 22 4 self 720) ; "Many died during this Dark Age, but a new philosophy was born. Holy men gathered together and built this Temple. These priests, realizing the error of past ways, sought to integrate the ways of Nature in the resurrection, to foster rather than exploit. This acorn of thought took root and grew a philosophy of life which spread its branches over every aspect of the new time."
			)
			(19
				(gMessager say: 5 0 29 1 self 720) ; "This Temple is a storehouse for what little remains of the old technology, a sacred place in which to carefully study the remnants of a dead age. It is hoped that with wisdom and caution, some of the ancient ways might be incorporated into the technology of today. The priests scoured the land and brought the old machines here."
			)
			(20
				(Load rsVIEW 2764)
				(gMessager say: 13 0 22 5 self 720) ; "Generations passed. With guidance from the Temple, the people developed natural sources of energy. Slowly the land recovered, and the people regained their sense of purpose. Life improved, balanced in a carefully maintained harmony with Nature."
				(= ticks 240)
			)
			(21
				(holoScene
					view: 2764
					init:
					cel: 0
					x: 166
					y: 160
					setCycle: End self
				)
			)
			(22
				(holoScene dispose:)
			)
			(23
				(= ticks 120)
			)
			(24
				(holoRing dispose:)
				(holoFace view: 176 x: 228 y: 196 cel: 0 setCycle: End self)
			)
			(25
				(= gMessager local3)
				(= local3 0)
				(holoFace dispose:)
				(ClearFlag 253)
				(roomMusic setVol: 127)
				(holoMusic stop:)
				(= cycles 2)
			)
			(26
				(if (and local0 (not (IsFlag 199)))
					(= ticks 120)
				else
					(self cue:)
				)
			)
			(27
				(if (and local0 (not (IsFlag 199)))
					(gCurRoom drawPic: 2755)
					(lirylProp2752 hide:)
					(cd2752 hide:)
					(= cycles 2)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(28
				(gMessager say: 13 0 22 6 self 720) ; "(saner and clearer than before)That was(pop) me, my voice. That was how life(rattle) used to be.( She mournfully leaves, going to her room. The player is now free to explore the Temple, except for the Dome, and the Room of Ancient Machines. If the player returns to the Left Chamber at a later time, the history can be replayed by pushing the 'play' button on the machine.)"
			)
			(29
				(= ticks 120)
			)
			(30
				(gCurRoom drawPic: 2752)
				(lirylProp2752 show:)
				(cd2752 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lirylLights2755 of Prop
	(properties
		x 342
		y 127
		loop 2
		view 5172
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: Fwd)
	)
)

(instance lirylFeat2755 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 261 80 285 80 297 101 296 125 290 133 290 138 316 148 319 220 264 216 227 216 240 184 230 167 202 181 173 188 152 203 144 196 152 175 197 164 231 140 250 138 246 128 247 96
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(cond
					((IsFlag 234)
						(switch (++ local1)
							(1
								(gMessager say: 8 0 17 1 0 720) ; "Go (click) away! I do not trust you!"
							)
							(2
								(gMessager say: 8 0 18 1 0 720) ; "I am busy now, I will talk to you later.( Liryl turns away toward her work table)"
							)
							(3
								(gGame handsOff:)
								(gCurRoom setScript: sLirylLeaves)
							)
						)
					)
					((not (IsFlag 199))
						(gMessager say: 9 0 20 1 0 720) ; "You are not of this land. To understand what has happened here, you must first learn our history."
					)
					(else
						(gMessager say: 7 0 16 (Random 1 6) 0 720)
					)
				)
			)
			(60 ; invCD
				(gMessager say: 9 0 20 1 0 720) ; "You are not of this land. To understand what has happened here, you must first learn our history."
			)
			(96 ; invBeingInBottle
				(gMessager say: 8 96 0 1 0 720) ; "Thank for saving our land. I could not have stopped him by myself."
			)
			(19 ; invShell
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				)
			)
			(51 ; invBaubles
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				)
			)
			(94 ; invDooDads
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				)
			)
			(20 ; invFish
				(gMessager say: 6 20 0 1 0 720) ; "It stinks! Take it away!"
			)
			(21 ; invSparrow
				(gMessager say: 6 21 0 1 0 720) ; "It's beautifully made, but I don't need it."
			)
			(47 ; invBottleNote
				(gMessager say: 1 18 0 1 0 720) ; "This means they are dead! They will never return! I am alone here, with no-one to help me! No pretty stones for(click) Liryl(click) Nothing but tears, nothing but...(click) tears.( Liryl leaves )"
			)
			(else
				(if (OneOf theVerb 73 40 69 68 67 71 66 70) ; invCannon, invIonizer, invPowerSupply, invStock, invVacuumPump, invBarrel, invCrystalBottle, invFiringMechanism
					(gMessager say: 6 22 0 1 0 720) ; "That's part of the device! They called it a particle ionizing vacuum cannon! If you can assemble it, I think you can defeat him."
				else
					(gMessager say: 6 0 0 1 0 720) ; "Liryl: That's interesting. What is it for?"
				)
			)
		)
	)
)

(instance lirylControl2755 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 167 195 196 195 175 220 138 218 159 200)
	)

	(method (doVerb theVerb)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sLirylControl)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sLirylControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ global230)
					(1
						(gMessager say: 7 0 1 1 self 720) ; "I use those controls to move about. Please don't hinder me by touching them."
					)
					(2
						(gMessager say: 7 0 8 1 self 720) ; "(scared)Go away!(rattle). Don't touch that!"
					)
					(3
						(gMessager say: 7 0 9 1 self 720) ; "Leave me alone! (pod rattles badly, shaking the girl)D..D..on't touch my controls! (crackle, Liryl turns and exits through pod door. She will not return unless coaxed from her room with shells and baubles.)"
					)
				)
			)
			(1
				(if (== global230 3)
					(= global230 0)
					(SetFlag 234)
					(= local4 1)
					(gCurRoom changeScene: 2752 4)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLirylLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 0 19 1 self 720) ; "If you won't listen, I'm not going to help you. Go away!( She shuts the pod door, and will not come out unless coaxed.)"
				(= local0 0)
			)
			(1
				(self dispose:)
				(= local4 2752)
				(gCurRoom changeScene: 2752)
			)
		)
	)
)

