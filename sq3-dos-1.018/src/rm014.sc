;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Menu)
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
)

(procedure (localproc_0)
	(pilot loop: 1 setPri: 15 posn: 150 189 stopUpd:)
	(= global203 0)
)

(procedure (localproc_1)
	(pilot loop: 0 setPri: 10 posn: 161 114 stopUpd:)
	(= global203 1)
)

(instance rm014 of Rm
	(properties
		picture 14
		style 0
	)

	(method (init &tmp [temp0 150])
		(if
			(and
				(not (and (== global176 5) global179 global181))
				(not (and (== global206 2) (== global207 2) (== gPrevRoomNum 17)))
			)
			(self setRegions: 701) ; travrg
		)
		(Load rsVIEW 31)
		(Load rsVIEW 28)
		(Load rsVIEW 65)
		(Load rsSOUND 31)
		(Load rsSOUND 33)
		(Load rsSOUND 59)
		(Load rsSOUND 83)
		(pilot init:)
		(super init:)
		(if (!= gPrevRoomNum 31)
			(TheMenuBar draw:)
			(SL enable:)
		)
		(switch gPrevRoomNum
			(2
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_1)
			)
			(8
				(wallA init: setLoop: 1 setCel: 0)
				(wallB init: setLoop: 1 setCel: 1)
				(wallC init: setLoop: 1 setCel: 2)
				(localproc_0)
			)
			(16
				(localproc_0)
				(cond
					((== global210 0)
						(wallA init: setLoop: 1 setCel: 0)
						(wallB init: setLoop: 1 setCel: 1)
						(wallC init: setLoop: 1 setCel: 2)
					)
					(
						(or
							(== global210 1)
							(== global210 2)
							(== global210 3)
							(== global210 7)
							(== global210 4)
						)
						(wallA init: setLoop: 4 setCel: 0)
					)
					((== global210 5)
						(wallA init: setLoop: 2 stopUpd:)
					)
					((== global210 6)
						(wallA init: setLoop: 3 stopUpd:)
					)
					((== global210 8)
						(wallA init: setLoop: 5 stopUpd:)
					)
				)
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(gLongSong number: 69 loop: -1 play:)
				)
			)
			(17
				(localproc_1)
				(cond
					((== global210 0)
						(wallA init: setLoop: 1 setCel: 0)
						(wallB init: setLoop: 1 setCel: 1)
						(wallC init: setLoop: 1 setCel: 2)
					)
					(
						(or
							(== global210 1)
							(== global210 2)
							(== global210 3)
							(== global210 7)
							(== global210 4)
						)
						(wallA init: setLoop: 4 setCel: 0)
					)
					((== global210 5)
						(wallA init: setLoop: 2 stopUpd:)
					)
					((== global210 6)
						(wallA init: setLoop: 3 stopUpd:)
					)
					((== global210 8)
						(wallA init: setLoop: 5 stopUpd:)
					)
				)
				(if
					(and
						(== global210 1)
						(or (== global209 2) (== global209 3))
						(not (and (== global213 69) (== global214 82)))
						(not (and (== global213 82) (== global214 69)))
						(not (and (== global176 5) global179 global181))
						(not global178)
					)
					(RedrawCast)
					(if (== global209 2)
						(Print 14 0) ; "It's going to take quite awhile at this speed. You've got time to get up and make a sandwich or wax the car or something."
					else
						(Print 14 1) ; "This speed is great for astral combat, but not for jumping across the galaxy. This could take forever."
					)
				)
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(localproc_1)
					(gLongSong number: 69 loop: -1 play:)
				)
			)
			(20
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_1)
				(= global210 1)
				(= global207 1)
			)
			(21
				(localproc_1)
				(cond
					((== global210 5)
						(wallA init: setLoop: 2 stopUpd:)
						(= local3 {Ortega})
					)
					((== global210 6)
						(wallA init: setLoop: 3 stopUpd:)
						(= local3 {Phleebhut})
					)
					((== global210 8)
						(wallA init: setLoop: 5 stopUpd:)
						(= local3 {Pestulon})
					)
				)
				(RedrawCast)
				(gLongSong stop:)
				(powerDown play:)
				(= global208 0)
				(ShakeScreen 10 ssFULL_SHAKE)
				(Print (Format @temp0 14 2 local3)) ; "With a mighty whump you set the Aluminum Mallard down on the surface of %s."
			)
			(28
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_1)
				(= global158 1)
				(= global210 2)
			)
			(31
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(localproc_1)
					(gLongSong number: 69 loop: -1 play:)
				else
					(localproc_1)
					(wallA init: setLoop: 4 setCel: 0)
					(RedrawCast)
					(if (== global209 2)
						(Print 14 0) ; "It's going to take quite awhile at this speed. You've got time to get up and make a sandwich or wax the car or something."
					else
						(Print 14 1) ; "This speed is great for astral combat, but not for jumping across the galaxy. This could take forever."
					)
				)
			)
			(49
				(wallA init: setLoop: 3 stopUpd:)
				(localproc_0)
				(gLongSong fade:)
				(= local1 1)
				(= global210 6)
				(= global206 0)
				(self setScript: rampScript)
			)
			(62
				(wallA init: setLoop: 2 stopUpd:)
				(localproc_0)
				(gLongSong fade:)
				(= local1 1)
				(= global210 5)
				(= global206 0)
				(self setScript: rampScript)
			)
			(80
				(wallA init: setLoop: 5 stopUpd:)
				(localproc_0)
				(gLongSong fade:)
				(= local1 1)
				(= global210 8)
				(= global206 0)
				(self setScript: rampScript)
			)
			(94
				(= global178 1)
				(self setScript: (ScriptID 22 0)) ; TwoGuysFirst
				(= global102 22)
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_1)
				(Print 14 3) ; "Well, Roger, ya done good! You managed to rescue the Two Guys and escape from Pestulon alive. Looks like this'll be a milk run from here on out."
				(= global175 60)
				(= global218 1)
				(= global210 7)
				(= global206 3)
				(= global179 1)
				(= global208 2)
			)
		)
		(if (and global178 (!= gPrevRoomNum 94))
			(if (and (== global176 5) global179 global181)
				(self setScript: (ScriptID 24 0)) ; FixLSpeed
				(= global102 24)
			else
				(self setScript: (ScriptID 23 0)) ; Whining
				(= global102 23)
			)
		)
		(if (or (not (IsItemAt 3)) (not (IsItemAt 1))) ; Reactor, Wire
			(floorPanel init:)
		)
		(if (and (or (== global206 0) (== global206 3)) (!= global102 24))
			(HandsOn)
		)
		(= global100 0)
		(= global159 0)
	)

	(method (newRoom newRoomNumber)
		(if global102
			((ScriptID global102 0) dispose:)
			(DisposeScript 22)
			(DisposeScript 23)
			(DisposeScript 24)
		)
		(if (== (gLongSong number:) 69)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if local0
			(local0 dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((and (== global203 0) (not gHandsOff))
						(cond
							(
								(and
									(<= 143 (event x:) 180)
									(<= 63 (event y:) 117)
								)
								(event claimed: 1)
								(localproc_1)
							)
							(
								(and
									(<= 263 (event x:) 319)
									(<= 59 (event y:) 142)
								)
								(event claimed: 1)
								(cls)
								(gCurRoom newRoom: 16)
							)
							(
								(and
									(== global210 0)
									(<= 105 (event x:) 215)
									(<= 0 (event y:) 17)
								)
								(event claimed: 1)
								(gCurRoom newRoom: 8)
							)
							(
								(and
									(<= 276 (event x:) 301)
									(<= 160 (event y:) 177)
								)
								(event claimed: 1)
								(cls)
								(if (== global203 0)
									(cond
										(
											(or
												(== global210 5)
												(== global210 6)
												(== global210 8)
											)
											(self setScript: rampScript)
										)
										((== global210 0)
											(Print 14 4) ; "The ramp is immobilized by the junk it's laying in, so you exit through the hatch instead."
											(gCurRoom newRoom: 8)
										)
										(else
											(Print 14 5) ; "Please do not attempt to disembark until the ride has come to a complete stop!"
										)
									)
								else
									(Print 14 6) ; "First, you'll need to tear your buttocks away from that pilot's seat."
								)
							)
						)
					)
					(
						(and
							(== global203 1)
							(not gHandsOff)
							(not (== global209 6))
							(<= 105 (event x:) 215)
							(<= 131 (event y:) 189)
						)
						(event claimed: 1)
						(localproc_0)
					)
				)
			)
			(evSAID
				(cond
					((Said '/motivator')
						(Print 14 7) ; "You don't have a motivator, and there isn't one here."
					)
					(
						(Said
							'press,disembark,disembark,open,(get<out)[/ramp,door,button,craft]'
						)
						(if (== global203 0)
							(cond
								(
									(or
										(== global210 5)
										(== global210 6)
										(== global210 8)
									)
									(self setScript: rampScript)
								)
								((== global210 0)
									(Print 14 4) ; "The ramp is immobilized by the junk it's laying in, so you exit through the hatch instead."
									(gCurRoom newRoom: 8)
								)
								(else
									(Print 14 5) ; "Please do not attempt to disembark until the ride has come to a complete stop!"
								)
							)
						else
							(Print 14 6) ; "First, you'll need to tear your buttocks away from that pilot's seat."
						)
					)
					((Said 'close/door,door,ramp')
						(Print 14 8) ; "It's already closed."
					)
					(
						(or
							(Said '(turn<on),use,start,fly/engine,craft')
							(Said 'launch,land,park[/craft]')
							(Said 'shoot[/gun]')
						)
						(Print 14 9) ; "All ship systems are accessed through the pilot's computer."
					)
					((Said 'enter,go,(sit[<down,in]),get/chair<passenger')
						(cond
							((== global203 1)
								(Print 14 10) ; "You're already sitting."
							)
							(global178
								(Print 14 11) ; "Since the two guys are in the passenger seats, you have no choice but to sit in the pilot seat."
							)
							(else
								(Print 14 12) ; "The two passenger seats look quite comfortable. However, the pilot seat is where you'd rather plop your butt."
							)
						)
					)
					(
						(or
							(Said 'sit[<down]')
							(Said 'enter,go,(sit[<down,in]),get/chair,cabin')
						)
						(if (== global203 1)
							(Print 14 10) ; "You're already sitting."
						else
							(localproc_1)
						)
					)
					(
						(or
							(Said '(get<up),stand[<up]')
							(Said 'disembark/chair,cabin')
						)
						(cond
							((== global203 0)
								(Print 14 13) ; "You're already standing."
							)
							((== global209 6)
								(Print 14 14) ; "Please remain seated while vehicle is in motion."
							)
							(else
								(localproc_0)
							)
						)
					)
					((Said 'use,wear,drop[<on]/panties')
						(cond
							((not (gEgo has: 5)) ; ThermoWeave_Underwear
								(Print 14 15) ; "You don't have any."
							)
							(global182
								(Print 14 16) ; "They're so comfortable, you forget that you're already wearing them."
							)
							((== global203 1)
								(Print 14 17) ; "You'll have to stand up for that."
							)
							(else
								(Print 14 18) ; "After figuring out which side is the front, you put on the ThermoWeave underwear. They power up automatically, keeping you comfy at all temperatures."
								(gGame changeScore: 10)
								(= global182 1)
							)
						)
					)
					((Said 'remove,get[<off]/panties')
						(cond
							((not (gEgo has: 5)) ; ThermoWeave_Underwear
								(Print 14 15) ; "You don't have any."
							)
							(global182
								(Print 14 19) ; "They're so comfortable, you decide to leave them on."
							)
							(else
								(Print 14 20) ; "You're not wearing them."
							)
						)
					)
					((Said 'explore/cushion,chair')
						(cond
							((== global203 0)
								(Print 14 21) ; "You'll need to go sit down first."
							)
							((not global150)
								(Print 14 22) ; "Searching around the cushions you find, among variously colored wads of lint, seven buckazoids."
								(gGame changeScore: 10)
								(+= global154 7)
								(gEgo get: 8) ; Buckazoids
								(= global150 1)
							)
							(else
								(Print 14 23) ; "You find nothing of value."
							)
						)
					)
					(
						(Said
							'remove,hoist,open,get/tile,compartment,(console[<video])'
						)
						(if (!= global136 4)
							(Print 14 24) ; "The hole is already exposed."
						else
							(Print 14 25) ; "The tile is doing a nice job of covering the hole, just leave it alone."
						)
					)
					((Said 'close/tile,compartment,deck,(console[<video])')
						(if (!= global136 4)
							(Print 14 26) ; "But, you're not done in there."
						else
							(Print 14 27) ; "It's all closed up."
						)
					)
					((Said 'talk/man,man')
						(if global178
							(Print 14 28) ; "It seems like everyone ignores you. You'd think they'd be more grateful."
						else
							(Print 14 29) ; "Your voice echoes thinly off the interior walls. It gets a little lonely out here, doesn't it?"
						)
					)
					((Said 'look>')
						(cond
							((Said '/cavity,compartment')
								(switch global136
									(4
										(Print 14 27) ; "It's all closed up."
									)
									(3
										(Print 14 30) ; "You look into the cavity at the reactor.  It's currently non-functional."
									)
									(2
										(Print 14 31) ; "You look into the cavity. The wire is firmly attached to cable ends."
									)
									(else
										(Print 14 32) ; "You look into the cavity and notice only two cable ends. Someone has made off with the ship's power supply."
									)
								)
							)
							((Said '/tile')
								(if (!= global136 4)
									(Print 14 33) ; "It seems to be the tile which covered the hole in the floor."
								else
									(Print 14 34) ; "There are many of them organized in the shape of a floor."
								)
							)
							((or (Said '/deck') (Said '<down'))
								(if (!= global136 4)
									(Print 14 35) ; "The floor of the cabin consists mainly of a ramp that is currently shut. An access panel has been removed to reveal an empty reactor compartment."
								else
									(Print 14 36) ; "The floor of the cabin consists mainly of a ramp that is currently shut."
								)
							)
							((Said '/console')
								(cond
									((== global203 1)
										(Print 14 37) ; "The control panel contains a computer screen. All ship systems are accessed through the pilot's computer."
									)
									((<= global136 1)
										(Print 14 38) ; "The access panel has been removed to reveal an empty reactor compartment."
									)
									((== global136 3)
										(Print 14 30) ; "You look into the cavity at the reactor.  It's currently non-functional."
									)
									((== global136 2)
										(Print 14 31) ; "You look into the cavity. The wire is firmly attached to cable ends."
									)
									(else
										(Print 14 39) ; "The access panel is firmly in place."
									)
								)
							)
							((Said '/comp<access')
								(cond
									((== global209 6)
										(Print 14 40) ; "There is no need to look at the computer right now."
									)
									((== global203 0)
										(gCurRoom newRoom: 16)
									)
									(else
										(Print 14 41) ; "The diagnostic computer gives you detailed information about the ship's systems. However, you'll need to get up to use it."
									)
								)
							)
							(
								(or
									(Said '/(comp[<scum]),control')
									(Said '/comp[<comp]')
								)
								(cond
									((== global209 6)
										(Print 14 40) ; "There is no need to look at the computer right now."
									)
									((== global203 0)
										(cls)
										(gCurRoom newRoom: 16)
									)
									((and (IsItemAt 3) (IsItemAt 1)) ; Reactor, Wire
										(cls)
										(gCurRoom newRoom: 17)
									)
									(else
										(Print 14 42) ; "The pilot's computer is dead."
									)
								)
							)
							((Said '/partition')
								(Print 14 43) ; "It's your basic spaceship interior wall."
							)
							((Said '/man,prize,scott')
								(if global178
									(Print 14 44) ; "The Two Guys from Andromeda are a couple of really hip dudes. You wish you could be like them."
								else
									(Print 14 45) ; "Nobody here but you, Wilco."
								)
							)
							((Said '/cushion')
								(if (== global203 0)
									(Print 14 21) ; "You'll need to go sit down first."
								else
									(Print 14 46) ; "Yep, that's a seat cushion alright!"
								)
							)
							((Said '/cabin')
								(if (== global203 1)
									(Print 14 47) ; "You are sitting in the pilot's seat of this sporty little ship. In front of you is the control panel, which contains a computer screen."
								else
									(Print 14 48) ; "Why not go sit down and take a look."
								)
							)
							((Said '/pane')
								(switch global210
									(0
										(Print 14 49) ; "You can just see over the trash piled up against the cockpit window. Above you is the ceiling of the junk freighter."
									)
									(1
										(if (== global209 6)
											(Print 14 50) ; "Gosh! Isn't it amazing how big a spot those space gnats make when you're traveling at light speed!"
										else
											(Print 14 51) ; "Wow, a bunch of stars! Not exactly a new sight for your space-weary eyes."
										)
									)
									(2
										(Print 14 52) ; "The happy lights of Monolith Burger entice you to enter."
									)
									(3
										(Print 14 53) ; "You are currently orbiting Ortega."
									)
									(4
										(Print 14 54) ; "You are currently orbiting Phleebhut."
									)
									(7
										(Print 14 55) ; "You are currently orbiting Pestulon."
									)
									(5
										(Print 14 56) ; "Outside, the stark surface of Ortega stretches into the distance. A lava-lovers paradise, to be sure."
									)
									(6
										(Print 14 57) ; "Outside, the desert surface of Phleebhut stretches into the distance. Countless eons of howling winds have carved this dry planet."
									)
									(8
										(Print 14 58) ; "Outside, the strange surface of Pestulon stretches into the distance. Forces beyond your comprehension seem to have shaped this bizarre world."
									)
									(else
										(Print 14 59) ; "The window is transparent."
									)
								)
							)
							((Said '/chair<passenger')
								(if global178
									(Print 14 11) ; "Since the two guys are in the passenger seats, you have no choice but to sit in the pilot seat."
								else
									(Print 14 12) ; "The two passenger seats look quite comfortable. However, the pilot seat is where you'd rather plop your butt."
								)
							)
							((Said '/chair')
								(cond
									((== global203 1)
										(Print 14 60) ; "The pilot seat is covered in fine Vorlian pseudoleather. Ergonomically designed to be comfortable yet stylish."
									)
									(global178
										(Print 14 11) ; "Since the two guys are in the passenger seats, you have no choice but to sit in the pilot seat."
									)
									(else
										(Print 14 12) ; "The two passenger seats look quite comfortable. However, the pilot seat is where you'd rather plop your butt."
									)
								)
							)
							((Said '/star,eva')
								(if (== global210 1)
									(Print 14 61) ; "Yep, there's a bunch of 'em!"
								else
									(Print 14 62) ; "You'll have to go into space for that."
								)
							)
							((or (Said '/ceiling') (Said '<up'))
								(cond
									((== global203 0)
										(Print 14 63) ; "Looking up, you see a space docking hatch."
									)
									((== global210 0)
										(Print 14 64) ; "Through the window you see the ceiling of the junk frieghter."
									)
									(else
										(Print 14 65) ; "Through the window you see the sky above."
									)
								)
							)
							((Said '/ramp')
								(Print 14 66) ; "The landing ramp is currently closed."
							)
							((Said '/door')
								(Print 14 67) ; "The space docking hatch is currently closed."
							)
							((Said '/button')
								(Print 14 68) ; "The button is clearly labeled 'ramp open/close.'"
							)
							((or (Said '/hal[<cable]') (Said 'cable'))
								(if (gCast contains: floorPanel)
									(Print 14 69) ; "Whoever ripped out the reactor didn't treat the wires too well. The short cable's end is torn and frayed."
								else
									(Print 14 70) ; "The cables are snug in their compartment."
								)
							)
							((Said '[<around,at,in][/area,craft]')
								(cond
									((== global203 1)
										(Print 14 47) ; "You are sitting in the pilot's seat of this sporty little ship. In front of you is the control panel, which contains a computer screen."
									)
									((not global169)
										(= global169 1)
										(Print 14 71) ; "At first you are surprised at how intact the ship's interior is.  Immediately to your right is a panel with a red button.  At midship on the right wall is the ship's main diagnostic computer. Directly across are two passenger seats. Ahead of you is the cockpit."
									)
									(else
										(Print 14 72) ; "Immediately to your right is a panel with a red button. At midship on the right wall is the ship's main diagnostic computer.  Directly across are two passenger seats.  Ahead of you is the cockpit."
									)
								)
							)
						)
					)
					(
						(or
							(Said 'go,look,(turn<on)/(comp[<scum]),control')
							(Said '/comp')
						)
						(cond
							((== global203 0)
								(cls)
								(gCurRoom newRoom: 16)
							)
							((and (IsItemAt 3) (IsItemAt 1)) ; Reactor, Wire
								(cls)
								(gCurRoom newRoom: 17)
							)
							(else
								(Print 14 42) ; "The pilot's computer is dead."
							)
						)
					)
					(
						(Said
							'replace,use,fix,place,insert,drop,afix,cable/[/cavity,compartment,deck,console,generator,cable]>'
						)
						(cond
							((Said '/generator')
								(cond
									((IsItemAt 3) ; Reactor
										(Print 14 73) ; "You already did that."
									)
									((not (gEgo has: 3)) ; Reactor
										(DontHave) ; "You don't have it."
									)
									((== global203 0)
										(self setScript: reactorScript)
									)
									(else
										(Print 14 74) ; "You can't install it from here."
									)
								)
							)
							(
								(or
									(Said '/cable')
									(Said '<cable')
									(Said 'cable<use')
								)
								(cond
									((IsItemAt 1) ; Wire
										(Print 14 73) ; "You already did that."
									)
									((not (gEgo has: 1)) ; Wire
										(DontHave) ; "You don't have it."
									)
									((== global203 0)
										(self setScript: wireScript)
									)
									(else
										(Print 14 74) ; "You can't install it from here."
									)
								)
							)
							((or (Said '/crystal') (Said '<crystal'))
								(if (not (gEgo has: 0)) ; Glowing_Gem
									(DontHave) ; "You don't have it."
								else
									(Print 14 75) ; "That wouldn't do any good."
								)
							)
						)
					)
					((Said 'turn,switch[<on]/generator')
						(Print 14 76) ; "The reactor is automatic. Just put it in and forget it!"
					)
					((Said 'get/generator')
						(cond
							((gEgo has: 3) ; Reactor
								(Print 14 77) ; "You already have it."
							)
							((IsItemAt 3 14) ; Reactor
								(Print 14 78) ; "Now that it's in place, you hate to take it out again."
							)
							(else
								(Print 14 79) ; "There's no reactor here."
							)
						)
					)
					((Said 'get/cable')
						(if (gEgo has: 1) ; Wire
							(Print 14 77) ; "You already have it."
						else
							(Print 14 78) ; "Now that it's in place, you hate to take it out again."
						)
					)
					((Said 'drop,use,afix[<on]/belt')
						(if (== global203 1)
							(Print 14 80) ; "No seatbelts here. The original owner opted for the 'no-frills' package."
						else
							(Print 14 81) ; "You're not even sitting down!"
						)
					)
					((Said 'open/console[<video]')
						(if (!= global136 4)
							(Print 14 82) ; "It's already open."
						else
							(Print 14 83) ; "The panel is doing its job nicely, don't mess with it."
						)
					)
					((Said 'close,replace/console[<video]')
						(if (!= global136 4)
							(Print 14 84) ; "But you're not finished in there."
						else
							(Print 14 8) ; "It's already closed."
						)
					)
					((Said 'go/compartment,cavity')
						(Print 14 85) ; "Come on, you wouldn't fit in there!"
					)
				)
			)
		)
	)

	(method (doit)
		(if (and global167 (not script))
			(self setScript: arrivalScript)
		)
		(if global258
			(self newRoom: 99)
		)
		(super doit:)
	)
)

(instance reactorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(pilot loop: 2 forceUpd:)
				(= cycles 15)
			)
			(1
				(if (IsItemAt 1) ; Wire
					(Print 14 86) ; "You drop the reactor into the hole, carefully reconnect the cables, and put the tile back in place."
					(= global136 4)
					(floorPanel dispose:)
				else
					(Print 14 87) ; "You drop the reactor into the hole. In attempting to reconnect the cables, you find that one is much too short."
					(= global136 3)
				)
				((gInventory at: 3) moveTo: 14) ; Reactor
				(gGame changeScore: 5)
				(= cycles 10)
			)
			(2
				(pilot loop: 1 forceUpd:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance wireScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(pilot loop: 2 forceUpd:)
				(= cycles 15)
			)
			(1
				(if (IsItemAt 3) ; Reactor
					(Print 14 88) ; "You carefully connect the wire between the ship and the reactor, putting the tile back in place once you've finished."
					(floorPanel dispose:)
					(= global136 4)
				else
					(Print 14 89) ; "You install the wire inside the reactor compartment."
					(= global136 2)
				)
				((gInventory at: 1) moveTo: 14) ; Wire
				(gGame changeScore: 5)
				(= cycles 10)
			)
			(2
				(pilot loop: 1 forceUpd:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance rampScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(ramp
						init:
						setLoop:
							(cond
								((== global210 5) 2)
								((== global210 6) 3)
								((== global210 8) 5)
							)
						setCel: 1
						stopUpd:
					)
					(= seconds 2)
				else
					(= cycles 10)
				)
			)
			(1
				(if local1
					(ramp dispose:)
					(= local1 0)
					(gCurRoom setScript: 0)
				else
					(ramp
						init:
						setCel: 1
						setLoop:
							(cond
								((== global210 5) 2)
								((== global210 6) 3)
								((== global210 8) 5)
							)
						setCel: 1
						stopUpd:
					)
					(= cycles 5)
				)
			)
			(2
				(gCurRoom
					newRoom:
						(cond
							((== global210 5) 62)
							((== global210 6) 49)
							((== global210 8) 80)
						)
				)
			)
		)
	)
)

(instance arrivalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Print 14 90 #at -1 130 #width 280 #dispose)) ; "A flashing message on your monitor attracts your attention."
				(gLongSong fade:)
				(= seconds 4)
			)
			(1
				(cls)
				(= local0 0)
				(gCurRoom newRoom: 17)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(self changeState: 1)
	)
)

(instance wallCScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global206 2)
					(HandsOff)
					(if (== global207 2)
						(wallA dispose:)
						(wallB dispose:)
						(wallC setLoop: 1 setCel: 2 posn: 161 98)
						(RedrawCast)
						(Print 14 91) ; "Your ship hovers between the garbage below and the ceiling above. This will never do."
						(gCurRoom setScript: 0)
						(gCurRoom newRoom: 17)
					else
						(= cycles 3)
					)
				)
				(if (== global206 1)
					(HandsOff)
					(self changeState: 2)
				)
			)
			(1
				(thunder play:)
				(ShakeScreen 15)
				(if global601
					(Print 14 92 #at -1 130 #width 280) ; "Once again you try to bring the ship from the rubble. You wonder how many times the ship can take this."
				else
					(Print 14 93 #at -1 130 #width 280) ; "You feel a strong rumbling as the ship strains to loosen itself from the confines of the junk heap accumulated at its base. Finally, it begins to rise."
					(= global601 1)
				)
				(= cycles 15)
			)
			(2
				(wallC
					setMotion: MoveTo 161 (if (== global206 2) 98 else 67) self
				)
				(wallB setMotion: MoveTo 161 (if (== global206 2) 181 else 119))
				(wallA setMotion: MoveTo 161 (if (== global206 2) 209 else 118))
			)
			(3
				(if (== global206 2)
					(if global207
						(Print 14 94 #at -1 130 #width 280) ; "The ship rises several meters, then stops abruptly. An alarm from the computer attracts your attention."
						(= global207 2)
						(gCurRoom newRoom: 17)
					else
						(blowUp play:)
						(ShakeScreen 30)
						(Print 14 95) ; "The ship rises successfully, but collides with the top of the freighter. The resulting explosion sends a potpourri of flesh and metal fragments careening in all directions."
						(EgoDead 0 0 5 7) ; "Your radar is designed to avoid just such an occurrence."
					)
				else
					(Print 14 96) ; "The ship settles back down into the nest of debris."
					(wallA stopUpd:)
					(wallB stopUpd:)
					(wallC stopUpd:)
					(= global206 0)
					(HandsOn)
					(= global100 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== global206 2)
			(if (> (wallA y:) 161)
				(wallA stopUpd:)
			)
			(if (> (wallB y:) 166)
				(wallB stopUpd:)
			)
		)
		(if (== global206 1)
			(if (< (wallA y:) 120)
				(wallA stopUpd:)
			)
			(if (< (wallB y:) 123)
				(wallB stopUpd:)
			)
		)
	)
)

(instance pilot of View
	(properties)

	(method (init)
		(super init:)
		(self view: 31 ignoreActors: 1)
	)
)

(instance floorPanel of View
	(properties)

	(method (init)
		(super init:)
		(self view: 28 setLoop: 0 setCel: 0 ignoreActors: posn: 95 190 stopUpd:)
	)
)

(instance ramp of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 28 setCel: 1 setPri: 14 ignoreActors: 1 posn: 159 189)
	)
)

(instance lp1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 0
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 2
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 1
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp4 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 3
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance wallA of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 28
			setCel: 0
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 210 else 117)
			setPri: 6
			setStep: 1 3
			stopUpd:
		)
	)
)

(instance wallB of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 28
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 182 else 120)
			setPri: 5
			setStep: 1 2
			stopUpd:
		)
	)
)

(instance wallC of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 28
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 98 else 67)
			setPri: 4
			setStep: 1 1
			stopUpd:
			setScript: wallCScript
		)
	)
)

(instance blowUp of Sound
	(properties
		number 33
		priority 1
	)
)

(instance thunder of Sound
	(properties
		number 31
		priority 1
	)
)

(instance powerDown of Sound
	(properties
		number 83
		priority 2
	)
)

