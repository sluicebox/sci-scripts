;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm017 0
)

(local
	local0
	local1
	local2
	[local3 5]
	[local8 25]
	local33
	[local34 49]
	local83
	[local84 49]
	local133
	[local134 49]
	local183
	[local184 49]
	local233
)

(procedure (localproc_0 param1 param2 param3)
	(SaveSubLang)
	(if (< global598 16)
		(= param3 15)
	)
	(Display param1 dsFONT 600 dsWIDTH 280 dsCOLOR param3 dsCOORD 20 param2)
	(RedrawCast)
	(RestoreSubLang)
)

(procedure (localproc_1 param1 param2)
	(if param1
		(SaveSubLang)
		(Display param1 dsFONT 600 dsWIDTH 280 dsCOLOR 0 dsCOORD 20 param2)
		(RestoreSubLang)
	)
)

(procedure (localproc_2)
	(engine
		cel:
			(cond
				((!= global135 4) 2)
				((== global208 2) 1)
				(else 0)
			)
		draw:
	)
	(TLBut
		loop:
			(if (or (and (== global206 2) (!= global207 2)) (== global206 0))
				2
			else
				3
			)
		cel:
			(if
				(and
					(== global208 2)
					(!= global210 1)
					(not (== global214 62))
					(not global178)
				)
				0
			else
				2
			)
		draw:
	)
	(cruiseBut
		cel:
			(cond
				((== global209 2) 1)
				((or (!= global208 2) (not global217)) 2)
				(else 0)
			)
		draw:
	)
	(LSpeedBut
		cel:
			(cond
				((== global209 6) 1)
				((or (not global217) global179 (!= global208 2)) 2)
				(else 0)
			)
		draw:
	)
	(ASpeedBut
		cel:
			(cond
				((== global209 3) 1)
				((or (and (not global217) (not global218)) (!= global208 2)) 2)
				(else 0)
			)
		draw:
	)
	(radarBut cel: (if global207 1 else 0) draw:)
	(navBut
		cel:
			(if
				(and
					(== global208 2)
					(== global206 3)
					(not global178)
					(not local2)
				)
				0
			else
				2
			)
		draw:
	)
	(weaponBut cel: (if (and (> global206 0) (not local2)) 0 else 2) draw:)
)

(instance rm017 of Rm
	(properties
		style 0
	)

	(method (init &tmp [temp0 50])
		(self setRegions: 701) ; travrg
		(gTheMenuBar hide:)
		(SL disable:)
		(if (< global598 16)
			(Load rsPIC (LangSwitch 170 317))
			(self drawPic: (LangSwitch 170 317))
			(Load rsVIEW (LangSwitch 141 327))
		else
			(Load rsPIC (LangSwitch 17 310))
			(self drawPic: (LangSwitch 17 310))
			(Load rsVIEW (LangSwitch 41 306))
		)
		(Load rsSOUND 40)
		(Load rsSOUND 83)
		(Load rsSOUND 95)
		(Load rsSOUND 96)
		(super init:)
		(HandsOff)
		(gUser mapKeyToDir: 0)
		(= global592 1)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(= global193 1)
		(controls
			add:
				engine
				navBut
				TLBut
				cruiseBut
				LSpeedBut
				ASpeedBut
				radarBut
				weaponBut
			eachElementDo: #init
			draw:
		)
		(if (and global167 (not global178))
			(self setScript: arrivalScript)
		)
		(localproc_2)
		(if (and (== global206 2) (== global207 2))
			(= local33
				{ASCENT HALTED DUE TO OBSTRUCTION}
			)
			(localproc_0 local33 104 14)
		)
		(= local0
			(localproc_0
				(if global217
					(Format
						@local8
						{DESTINATION: SECTOR %d}
						global217
						global217
					)
				else
					{NO COURSE SELECTED}
				)
				154
				9
			)
		)
		(SaveSubLang)
		(Display 17 0 dsCOORD 20 144 dsFONT 600 dsWIDTH 250 dsCOLOR 10) ; "CURRENT SECTOR:"
		(Display ; "PRESS F6 FOR COCKPIT VIEW"
			17
			1
			dsCOORD
			(LangSwitch 97 72 97 72)
			67
			dsFONT
			600
			dsWIDTH
			(LangSwitch 180 240 180 240)
			dsCOLOR
			15
		)
		(RestoreSubLang)
		(if (and global179 (not global181))
			(Load rsSOUND 27)
			(self setScript: LightWarning)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_F6) (not local2))
					(event claimed: 1)
					(= global193 0)
					(gCurRoom newRoom: 14)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(<= 95 (event x:) 222)
						(<= 60 (event y:) 77)
						(not local2)
					)
					(event claimed: 1)
					(= global193 0)
					(gCurRoom newRoom: 14)
				)
			)
		)
	)

	(method (doit)
		(if (and global167 (not script))
			(self setScript: arrivalScript)
		)
		(SaveSubLang)
		(Display
			(Format @local3 17 2 global214) ; "%d"
			dsCOORD
			(LangSwitch 100 120 100 120)
			144
			dsWIDTH
			15
			dsCOLOR
			10
			dsBACKGROUND
			0
			dsFONT
			600
		)
		(RestoreSubLang)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(= local233 1)
		(RedrawCast)
		(gUser mapKeyToDir: 1)
		(gTimers eachElementDo: #dispose 84)
		(= global193 0)
		(super newRoom: newRoomNumber)
	)
)

(instance arrivalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global167 0)
				(HandsOff)
				(= local2 1)
				(= global209 1)
				(= global214 global217)
				(= global217 0)
				(localproc_2)
				(= local133
					(if (== global209 6)
						{CUTTING LIGHT ENGINES}
					else
						{THROTTLING ENGINES BACK}
					)
				)
				(localproc_0 local133 134 14)
				(= seconds 3)
			)
			(1
				(localproc_1 local133 134)
				(= cycles 2)
			)
			(2
				(= local133
					(cond
						((== global214 39) {ORBITING PLANET PHLEEBHUT})
						((== global214 62) {APPROACHING MONOLITH BURGER})
						((== global214 82) {ORBITING PLANET ORTEGA})
						((== global214 69) {ORBITING PESTULON})
					)
				)
				(localproc_0 local133 134 3)
				(= seconds 3)
			)
			(3
				(localproc_1 local133 134)
				(cond
					((== global214 62)
						(= global208 0)
						(= global193 0)
						(gCurRoom newRoom: 27)
					)
					((== global214 39)
						(= global210 4)
					)
					((== global214 82)
						(= global210 3)
					)
					((== global214 69)
						(= global210 7)
					)
				)
				(= local2 0)
				(localproc_2)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance LightWarning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global181 1)
				(localproc_0
					{** LIGHT SPEED NON-FUNCTIONAL **}
					174
					14
				)
				(beeper play: self)
			)
			(1
				(Print 17 3) ; "Those jokers back on Pestulon must have tampered with the lightspeed thingamajig!"
				(localproc_1
					{** LIGHT SPEED NON-FUNCTIONAL **}
					174
				)
				(client setScript: 0)
			)
		)
	)
)

(instance responseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{FULL THRUST NECESSARY BEFORE MANEUVERING}
				)
				(= local1 84)
				(localproc_0 local83 84 4)
				(self changeState: 13)
			)
			(2
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{A COURSE MUST BE SET BEFORE SELECTING SPEED}
				)
				(= local1 84)
				(localproc_0 local83 84 4)
				(self changeState: 13)
			)
			(3
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{NO LANDING SURFACE AVAILABLE}
				)
				(= local1 84)
				(localproc_0 local83 84 4)
				(self changeState: 13)
			)
			(4
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{** LIGHT SPEED NON-FUNCTIONAL **}
				)
				(= local1 164)
				(localproc_0 local83 164 4)
				(self changeState: 13)
			)
			(5
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{WEAPONS SYSTEM INOPERABLE WHILE NOT IN FLIGHT}
				)
				(= local1 114)
				(localproc_0 local83 114 6)
				(self changeState: 13)
			)
			(6
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83 local33)
				(= local1 104)
				(localproc_0 local83 104 2)
				(self changeState: 13)
			)
			(7
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{NAVIGATION SYSTEM INOPERABLE WHILE NOT IN FLIGHT}
				)
				(= local1 124)
				(localproc_0 local83 124 2)
				(self changeState: 13)
			)
			(8
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{** ERROR DETECTED: CONSULT DIAGNOSTIC COMPUTER **}
				)
				(= local1 164)
				(localproc_0 local83 164 4)
				(self changeState: 13)
			)
			(9
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83 local183)
				(= local1 84)
				(localproc_0 local83 84 2)
				(self changeState: 13)
			)
			(10
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{THRUST GENERATION UNDERWAY}
				)
				(= local1 94)
				(localproc_0 local83 94 14)
				(self changeState: 13)
			)
			(11
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{ADEQUATE THRUST ACHIEVED}
				)
				(= local1 94)
				(localproc_0 local83 94 2)
				(self changeState: 13)
			)
			(12
				(if local83
					(localproc_1 local83 local1)
				)
				(= local83
					{** NAVIGATION SYSTEM NON-FUNCTIONAL **}
				)
				(= local1 164)
				(localproc_0 local83 164 4)
				(self changeState: 13)
			)
			(13
				(Timer set: self 3)
			)
			(14
				(localproc_1 local83 local1)
				(= global100 0)
				(= local2 0)
			)
		)
	)
)

(instance toScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(1
				(= local2 1)
				(if (== global206 2)
					(= local183 {TAKEOFF IN PROGRESS})
				else
					(= local183
						{LANDING/DOCKING IN PROGRESS}
					)
				)
				(responseScript changeState: 9)
				(switch global210
					(3
						(= global206 0)
						(= global208 0)
						(= global210 5)
					)
					(4
						(= global206 0)
						(= global208 0)
						(= global210 6)
					)
					(7
						(= global206 0)
						(= global208 0)
						(= global210 8)
					)
					(2
						(= global208 0)
					)
					(5
						(= global206 3)
						(= global210 3)
					)
					(6
						(= global206 3)
						(= global210 4)
					)
					(8
						(= global206 3)
						(= global210 7)
					)
				)
				(= global193 0)
				(gCurRoom
					newRoom:
						(cond
							((== global210 2)
								(if (== global206 1) 28 else 31)
							)
							(
								(or
									(== global210 0)
									(== global210 3)
									(== global210 4)
									(== global210 7)
								)
								14
							)
							(
								(or
									(== global210 6)
									(== global210 5)
									(== global210 8)
								)
								21
							)
						)
				)
			)
		)
	)
)

(instance sbScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= global100 1)
				(powerUp play:)
				(responseScript changeState: 10)
				(= seconds 5)
			)
			(2
				(standBy setLoop: 8 setCel: 3)
				(= cycles 2)
			)
			(3
				(gLongSong number: 59 loop: -1 priority: 0 play:)
				(responseScript changeState: 11)
				(= global208 2)
				(= global100 0)
				(localproc_2)
			)
		)
	)
)

(instance StupidCrash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(= seconds 3)
			)
			(1
				(ShakeScreen 10 ssFULL_SHAKE)
				(Print 17 4) ; "With the engines off, the ship falls abruptly to the floor.  The resulting impact is too much for it and you."
				(EgoDead 0 0 5 7) ; "Your radar is designed to avoid just such an occurrence."
			)
		)
	)
)

(instance engine of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 26
		key 49
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(2
				(responseScript changeState: 8)
				(badBlip play:)
			)
			(1
				(goodBlip play:)
				(if (> global206 1)
					(= global220 0)
					(= global209 1)
					(= global206 3)
				)
				(= global208 0)
				(if (and (== global210 0) (== global207 2))
					(gCurRoom setScript: StupidCrash)
				)
				(gLongSong stop:)
				(powerDown play:)
			)
			(0
				(standBy dispose:)
				(goodBlip play:)
				(= global208 1)
				(standBy
					posn: (engine nsLeft:) (engine nsTop:)
					init:
					setScript: sbScript
				)
			)
		)
		(localproc_2)
	)
)

(instance cruiseBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 99
		key 52
		loop 4
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit &tmp [temp0 50])
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(self cel: 1 draw:)
				(goodBlip play:)
				(if
					(and
						(or
							(and (== global213 69) (== global214 82))
							(and (== global213 82) (== global214 69))
						)
						(not global218)
					)
					(= global220 10)
				else
					(= global220 180)
				)
				(= global209 2)
				(= global210 1)
				(= global193 0)
				(gCurRoom newRoom: (if global151 14 else 31))
			)
			(1
				(= global209 0)
				(goodBlip play:)
				(localproc_2)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 2)
			)
		)
	)
)

(instance ASpeedBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 160
		key 54
		loop 6
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(self cel: 1 draw:)
				(goodBlip play:)
				(if
					(and
						(or
							(and (== global213 69) (== global214 82))
							(and (== global213 82) (== global214 69))
						)
						(not global218)
					)
					(= global220 10)
				else
					(= global220 90)
				)
				(= global209 3)
				(= global210 1)
				(= global193 0)
				(if (not global218)
					(gCurRoom newRoom: (if global151 14 else 31))
				)
			)
			(1
				(goodBlip play:)
				(= global209 0)
				(localproc_2)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 2)
			)
		)
	)
)

(instance LSpeedBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 160
		key 53
		loop 5
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global220 2)
				(= global209 6)
				(= global210 1)
				(= global193 0)
				(gCurRoom newRoom: 31)
			)
			(1
				(goodBlip play:)
				(= global209 0)
				(localproc_2)
			)
			(2
				(badBlip play:)
				(if global179
					(responseScript changeState: 4)
				else
					(responseScript changeState: 2)
				)
			)
		)
	)
)

(instance navBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 26
		key 50
		loop 1
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global193 0)
				(gCurRoom newRoom: 19)
			)
			(2
				(badBlip play:)
				(cond
					((!= global208 2)
						(responseScript changeState: 1)
					)
					((or global218 (== global176 5))
						(responseScript changeState: 12)
					)
					(else
						(responseScript changeState: 7)
					)
				)
			)
		)
	)
)

(instance radarBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 231
		key 55
		loop 7
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= local33
					{RADAR IS NOW IN OPERATION}
				)
				(= global207 1)
				(responseScript changeState: 6)
			)
			(1
				(if global206
					(badBlip play:)
					(Print 17 5) ; "LEAVE RADAR SYSTEM ON WHILE IN FLIGHT"
				else
					(goodBlip play:)
					(self cel: 0 draw:)
					(= local33
						{RADAR IS NOW INOPERATIVE}
					)
					(= global207 0)
					(responseScript changeState: 6)
				)
			)
		)
	)
)

(instance weaponBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 231
		key 56
		loop 8
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global193 0)
				(gCurRoom newRoom: 18)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 5)
			)
		)
	)
)

(instance TLBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 99
		key 51
		loop 2
	)

	(method (init)
		(= view
			(if (> global598 4)
				(LangSwitch 41 306)
			else
				(LangSwitch 141 327)
			)
		)
	)

	(method (doit)
		(if (or global100 local233)
			(return)
		)
		(switch (self cel:)
			(0
				(goodBlip play:)
				(if (== (self loop:) 2)
					(self cel: 1 draw:)
					(= global206 2)
					(toScript changeState: 1)
					(= global194 1)
				else
					(self cel: 1 draw:)
					(= global206 1)
					(= global209 0)
					(if (== global207 2)
						(= global207 1)
						(if local33
							(localproc_1 local33 104)
						)
					)
					(toScript changeState: 1)
				)
			)
			(2
				(badBlip play:)
				(if (!= global208 2)
					(responseScript changeState: 1)
				else
					(responseScript changeState: 3)
				)
			)
		)
	)
)

(instance standBy of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view:
				(if (> global598 4)
					(LangSwitch 41 306)
				else
					(LangSwitch 141 327)
				)
			setLoop: 9
			cel: 0
			priority: 15
			cycleSpeed: 2
			setCycle: Fwd
		)
	)
)

(instance beeper of Sound
	(properties
		number 27
		priority 2
		loop 2
	)
)

(instance powerUp of Sound
	(properties
		number 40
		priority 2
	)
)

(instance powerDown of Sound
	(properties
		number 83
		priority 2
	)
)

(instance goodBlip of Sound
	(properties
		number 95
		priority 2
	)
)

(instance badBlip of Sound
	(properties
		number 96
		priority 2
	)
)

