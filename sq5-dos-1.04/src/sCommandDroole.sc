;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 217)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Print)
(use Sound)
(use System)

(public
	sCommandDroole 0
	sTalkToDroole 1
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
)

(procedure (localproc_0 param1)
	(= local6 0)
	(cond
		((IsFlag 38)
			(ClearFlag 38)
			(eureka destination: 0 state: 4 setScript: 0 warnings: 0 timer: 0)
			(switch (eureka curLocation:)
				(1
					(SetFlag 35)
				)
				(2
					(SetFlag 36)
				)
			)
			((ScriptID 201 12) talkWidth: 60) ; drooleTalker
			(gMessager say: 42 0 53 1 param1) ; "Aye, sir."
			(= local6 1)
		)
		((== (eureka puke:) 2)
			((ScriptID 201 12) talkWidth: 60) ; drooleTalker
			(gMessager say: 42 0 53 1 param1) ; "Aye, sir."
			(= local6 1)
		)
		((IsFlag 30)
			(gMessager say: 2 0 3 (Random 1 3) param1)
		)
		(else
			(gMessager say: 2 0 4 (Random 1 3) param1)
		)
	)
	((ScriptID 201 12) talkWidth: 120) ; drooleTalker
)

(procedure (localproc_1 param1)
	(cond
		((== global113 0)
			(if (not (eureka destination:))
				(gMessager say: 24 0 46 1 param1) ; "It might help if we picked a destination first, sir."
			else
				(gMessager say: 31 0 23 1 param1) ; "Alright sir, but I'm gonna put the pedal to the metal once we leave the station."
				(= local2 1)
			)
		)
		((IsFlag 32)
			(= local4 1)
			(ClearFlag 32)
			((ScriptID 201 12) talkWidth: 60) ; drooleTalker
			(gMessager say: 42 0 53 1 param1) ; "Aye, sir."
			(eureka warnings: 0 setScript: 0 timer: 0)
			(if (== (eureka state:) 2)
				(eureka curLocation: (eureka destination:))
			else
				(eureka setScript: (ScriptID 210 2) 0 30) ; sLiteSpeedTimer
			)
		)
		((IsFlag 30)
			(gMessager say: 31 0 3 (Random 1 3) param1)
		)
		(else
			(gMessager say: 31 0 4 (Random 1 3) param1)
		)
	)
	((ScriptID 201 12) talkWidth: 120) ; drooleTalker
)

(procedure (localproc_2 param1)
	(cond
		((== (eureka destination:) 0)
			(if (IsFlag 30)
				(gMessager say: 24 0 3 (Random 1 3) param1)
			else
				(gMessager say: 24 0 46 1 param1) ; "It might help if we picked a destination first, sir."
			)
		)
		((== global113 0)
			(gMessager say: 24 0 41 1 param1) ; "We'll go to warp as soon as we're clear of the station, sir."
			(= local2 1)
		)
		((IsFlag 32)
			(gMessager say: 24 0 45 1 param1) ; "We're already at lite speed, Captain."
		)
		((IsFlag 39)
			(gMessager say: 24 0 19 1 param1) ; "We can't go to light speed while we're cloaked, sir. We don't have enough power."
		)
		(else
			(SetFlag 32)
			(= local5 1)
			(eureka setScript: 0 timer: 0 warnings: 0)
			((ScriptID 201 12) talkWidth: 60) ; drooleTalker
			(gMessager say: 42 0 53 1 param1) ; "Aye, sir."
			(if (eureka curLocation:)
				(if
					(or
						(== (eureka curLocation:) 15)
						(== (eureka curLocation:) 6)
					)
					(DisposeScript 221)
				)
				(eureka prevLocation: (eureka curLocation:))
				(eureka curLocation: 0)
			)
		)
	)
	((ScriptID 201 12) talkWidth: 120) ; drooleTalker
)

(procedure (localproc_3 param1)
	(cond
		((or (IsFlag 32) (!= (eureka state:) 2))
			(if (IsFlag 30)
				(gMessager say: 35 0 3 (Random 1 3) param1)
			else
				(gMessager say: 35 0 4 (Random 1 3) param1)
			)
		)
		((and (OneOf (eureka curLocation:) 1 2) (== (eureka state:) 2))
			(gMessager say: 35 0 48 1 param1) ; "That's not part of our mission profile, Captain."
		)
		((IsFlag 37)
			(gMessager say: 35 0 4 3 param1) ; "We cannot go into orbit right now, sir."
		)
		((and (== (eureka state:) 2) (eureka curLocation:))
			(gMessager say: 35 0 0 1 param1) ; "Standard orbit, aye."
			(eureka destination: 0 state: 3 setScript: 0 warnings: 0 timer: 0)
			(= local7 1)
		)
		(else
			(gMessager say: 35 0 3 (Random 1 3) param1)
		)
	)
)

(procedure (localproc_4 param1)
	(cond
		((eureka damaged:)
			(gMessager say: 12 0 11 1 param1) ; "Weapons inoperative, shields depleted. Basically, we're screwed."
		)
		((== global113 14)
			(switch (eureka puke:)
				(1
					(gMessager say: 12 0 15 1 param1) ; "The Goliath is taking quite a beating, sir. If she blows when we're this close, the Eureka will go up with her."
				)
				(2
					(gMessager say: 12 0 18 1 param1) ; "Looks like the fecal material has struck the rotating blades, Captain."
					(param1 cue:)
				)
				(4
					(gMessager say: 12 0 16 1 param1) ; "The ship's holding together, sir, but just barely. Something's gonna give before long!"
				)
				(else
					(gMessager say: 12 0 3 (Random 1 3) param1)
				)
			)
		)
		((IsFlag 30)
			(gMessager say: 12 0 3 (Random 1 3) param1)
		)
		(else
			(gMessager say: 12 0 4 (Random 1 3) param1)
		)
	)
)

(procedure (localproc_5 param1)
	(= local3 0)
	(cond
		((IsFlag 40)
			(if (IsFlag 30)
				(gMessager say: 29 0 3 (Random 1 3) param1)
			else
				(gMessager say: 29 0 4 (Random 1 3) param1)
			)
		)
		((eureka hits:)
			(gMessager say: 29 0 11 1 param1) ; "We can't sir! They've been knocked out!"
		)
		(else
			(gMessager say: 29 0 0 1 param1) ; "Aye, aye, Captain."
			(SetFlag 40)
			(= local3 1)
		)
	)
)

(procedure (localproc_6 param1)
	(= local3 0)
	(cond
		((IsFlag 40)
			(gMessager say: 25 0 47 1 param1) ; "Lowering shields..."
			(ClearFlag 40)
			(= local3 1)
		)
		((IsFlag 30)
			(gMessager say: 25 0 3 (Random 1 3) param1)
		)
		(else
			(gMessager say: 25 0 4 (Random 1 3) param1)
		)
	)
)

(procedure (localproc_7 param1)
	(if (IsFlag 30)
		(gMessager say: 27 0 3 (Random 1 3) param1)
	else
		(gMessager say: 27 0 4 (Random 1 3) param1)
	)
)

(instance sLayInCourse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= cycles 1)
			)
			(1
				(cond
					((eureka damaged:)
						(if (eureka hits:)
							(if (IsFlag 30)
								(gMessager say: 23 0 38 (Random 1 3) self)
							else
								(gMessager say: 23 0 39 (Random 1 3) self)
							)
						else
							(gMessager say: 23 0 44 1 self) ; "We can't do that! System overloaded, sir!"
						)
					)
					((and (== global113 6) (IsFlag 45) (== global142 1))
						(gMessager say: 23 0 22 1 self) ; "We can't do that now, sir."
						(= local0 0)
					)
					((and (== global113 15) (not (IsFlag 87)))
						(= local0 0)
						(gMessager say: 23 0 40 1 self) ; "But Captain! We can't just leave Cliffy out there! You've gotta go after him!"
					)
					((== (eureka state:) 0)
						(if (IsFlag 31)
							(gMessager say: 23 0 36 1 self) ; "What coordinates, Captain?"
							(= local0 1)
						else
							(gMessager say: 23 0 37 1 self) ; "We need clearance before we do that, sir."
						)
					)
					((eureka destination:)
						(gMessager say: 23 0 41 1 self) ; "Course already laid in, Captain."
						(= local0 1)
					)
					(
						(and
							(== (eureka curLocation:) 5)
							(not (IsFlag 76))
							(IsFlag 30)
						)
						(gMessager say: 23 0 27 1 self) ; "Shouldn't we find out if the colonists are all right first, sir?"
						(= local0 1)
					)
					((or (IsFlag 37) (== (eureka curLocation:) 14))
						(gMessager say: 23 0 15 1 self) ; "But sir, everyone on the Goliath will die!"
					)
					(else
						(if (and (not (IsFlag 30)) (== global127 3))
							(gMessager say: 19 0 0 (Random 1 3) self 202)
						else
							(gMessager say: 23 0 36 1 self) ; "What coordinates, Captain?"
						)
						(= local0 1)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global113
					(0
						(gMessager say: 15 0 23 1 self) ; "I'm sure the Star Confederacy wouldn't appreciate it if you blew a hole in the side of one of their stations, Captain."
					)
					(6
						(if (IsFlag 45)
							(if (not (eureka hits:))
								(gMessager say: 15 0 22 1 self) ; "Speaking from personal experience, I've found that firing upon our own ships is generally frowned upon by StarCon Command, Captain."
							else
								(gMessager say: 15 0 11 1 self) ; "Weapons systems are not operational, Captain."
							)
						else
							(gMessager say: 15 0 3 (Random 1 3) self)
						)
					)
					(14
						(switch (eureka puke:)
							(0
								(if (IsFlag 39)
									(gMessager say: 15 0 19 1 self) ; "We have to de-cloak first, Captain. And I wouldn't recommend that--the Goliath would blast us to atoms before our weapons armed."
									(= cycles 1)
								else
									(gMessager say: 15 0 24 1 self) ; "Weapons lock inoperative sir--they're jamming us!"
									(= cycles 1)
								)
							)
							(1
								(eureka setScript: 0 timer: 0 warnings: 0)
								((ScriptID 201 12) talkWidth: 60) ; drooleTalker
								(gMessager say: 42 0 53 1 self) ; "Aye, sir."
								(ClearFlag 39)
								(= local1 1)
							)
							(else
								(gMessager say: 15 0 18 1 self) ; "I don't think that would be very helpful, Captain. It will probably just make him madder."
							)
						)
					)
					(else
						(cond
							((eureka damaged:)
								(gMessager say: 15 0 11 1 self) ; "Weapons systems are not operational, Captain."
							)
							((IsFlag 30)
								(gMessager say: 15 0 3 (Random 1 3) self)
							)
							(else
								(gMessager say: 15 0 4 (Random 1 3) self)
							)
						)
					)
				)
			)
			(1
				((ScriptID 201 12) talkWidth: 120) ; drooleTalker
				(self dispose:)
			)
		)
	)
)

(instance sEvasiveAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global113
					(3
						(gMessager say: 13 0 4 2 self) ; "You'd have better luck trying to bite an air biscuit, sir."
					)
					(6
						(if (eureka hits:)
							(self setScript: (ScriptID 220 0) self) ; sAsteroidChoices
						else
							(gMessager say: 13 0 3 3 self) ; "We don't have any reason to retreat at present, Captain."
						)
					)
					(14
						(if (IsFlag 39)
							(gMessager say: 13 0 19 1 self) ; "There's no need to do that while we're cloaked, Captain Wilco."
						else
							(gMessager say: 13 0 21 1 self) ; "There's nowhere to hide, Captain!"
						)
					)
					(else
						(if (IsFlag 30)
							(gMessager say: 13 0 3 (Random 1 3) self)
						else
							(gMessager say: 13 0 4 (Random 1 3) self)
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sShields of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(theMusic3 number: 106 loop: 1 play: self)
			)
			(2
				(theMusic3 number: 233 loop: 1 play: self)
			)
			(3
				(theMusic3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance navSound of Sound
	(properties
		number 211
	)
)

(instance sCoordsLocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (not (eureka destination:)) (== (proc201_22) -1))
					(self dispose:)
				else
					(navSound setLoop: 1 play:)
					(= seconds 3)
				)
			)
			(1
				(proc201_7 self)
			)
			(2
				(if (IsFlag 32)
					(gMessager say: 11 0 41 2 self) ; "Coordinates locked in, Captain."
				else
					(gMessager say: 11 0 41 1 self) ; "Coordinates locked in, sir. Ready to get underway!"
				)
			)
			(3
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
				(navSound dispose:)
			)
			(4
				(switch (eureka state:)
					(3
						(self setScript: (ScriptID 201 37) self) ; sOutOfOrbit
					)
					(1
						(if (== (eureka destination:) (eureka curLocation:))
							(self setScript: (ScriptID 201 38) self) ; sTurnAround
						else
							(= cycles 1)
						)
					)
					(2
						(if (== (eureka destination:) (eureka curLocation:))
							(self setScript: (ScriptID 201 38) self) ; sTurnAround
						else
							(= cycles 1)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sCommandDroole of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc201_7 self)
				(gEgo setLoop: 0 setCel: 0 posn: 134 95 show: stopUpd:)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				(Print
					mode: 1
					font: gUserFont
					window: (ScriptID 205 0) ; commandWindow
					width: 125
					addColorButton: 0 1 0 0 1 0 0 205 13 29 31 0 0 0 ; "Lay in a course"
					addColorButton: 1 1 0 0 2 0 10 205 13 29 31 0 0 0 ; "Activate RRS"
					addColorButton: 2 1 0 0 3 0 20 205 13 29 31 0 0 0 ; "Fire"
					addColorButton: 3 1 0 0 4 0 30 205 13 29 31 0 0 0 ; "Regular Speed"
					addColorButton: 4 1 0 0 5 0 40 205 13 29 31 0 0 0 ; "Lite Speed"
					addColorButton: 5 1 0 0 6 0 50 205 13 29 31 0 0 0 ; "Standard Orbit"
				)
				(= register
					(Print
						addColorButton: 6 1 0 0 7 0 60 205 13 29 31 0 0 0 ; "Status Report"
						addColorButton: 7 1 0 0 8 0 70 205 13 29 31 0 0 0 ; "Evasive Action"
						addColorButton: 8 1 0 0 9 0 80 205 13 29 31 0 0 0 ; "Raise Shields"
						addColorButton: 9 1 0 0 10 0 90 205 13 29 31 0 0 0 ; "Lower Shields"
						addColorButton: 10 1 0 0 11 0 100 205 13 29 31 0 0 0 ; "Never Mind"
						init:
					)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOff:)
				(switch register
					(0
						(self setScript: sLayInCourse self)
					)
					(1
						(localproc_0 self)
					)
					(2
						(self setScript: sFire self)
					)
					(3
						(localproc_1 self)
					)
					(4
						(localproc_2 self)
					)
					(5
						(localproc_3 self)
					)
					(6
						(localproc_4 self)
					)
					(7
						(self setScript: sEvasiveAction self)
					)
					(8
						(localproc_5 self)
					)
					(9
						(localproc_6 self)
					)
					(10
						(localproc_7 self)
					)
					(else
						(localproc_7 self)
					)
				)
			)
			(3
				(if local0
					(proc201_33)
					(self setScript: (ScriptID 203 0) self 0) ; keyStuff
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo hide:)
				((ScriptID 205 0) dispose:) ; commandWindow
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(5
				(= seconds 1)
			)
			(6
				(cond
					(local0
						(= local0 0)
						(self setScript: sCoordsLocked self)
					)
					(local6
						(if (== (eureka puke:) 2)
							(SetScore 199 200)
							(= next (ScriptID 207 3)) ; sSuckBlob
							(self dispose:)
						else
							(= next (ScriptID 232 3)) ; sTrashPickUp
							(self dispose:)
						)
					)
					(local7
						(= local7 0)
						(= next (ScriptID 201 36)) ; sInToOrbit
						(self dispose:)
					)
					(local1
						(= local1 0)
						(= next (ScriptID 207 1)) ; sFireOnBlob
						(SetScore 198 50)
						(self dispose:)
					)
					(local2
						(= local2 0)
						(= next (ScriptID 214 5)) ; sExitStarCon
						(self dispose:)
					)
					(local4
						(= local4 0)
						(= next (ScriptID 201 1)) ; sFlashRed
						(self dispose:)
					)
					(local5
						(= local5 0)
						(= next (ScriptID 201 35)) ; sFlashWhite
						(self dispose:)
					)
					(local3
						(self setScript: sShields self)
						(= local3 0)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(7
				(= seconds 1)
			)
			(8
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 205)
		(DisposeScript 217)
	)
)

(instance sTalkToDroole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(proc201_7 self)
				(gEgo setLoop: 0 posn: 134 95 setCel: 0 show:)
			)
			(2
				(cond
					((== global113 0)
						(self setScript: (ScriptID 220 2) self) ; sDStarconChoices
					)
					((and (not (IsFlag 111)) (== global126 1))
						(gMessager say: 26 0 31 0 self 202) ; "Yes, Captain?"
						(SetFlag 111)
					)
					(
						(and
							(IsFlag 36)
							(not (IsFlag 61))
							(not (IsFlag 30))
							(or
								(== (eureka prevLocation:) 2)
								(== (eureka curLocation:) 2)
							)
							(!= (eureka curLocation:) 1)
							(!= (eureka curLocation:) 3)
						)
						(self setScript: (ScriptID 220 3) self) ; sDAlienChoices
					)
					((and (not (IsFlag 30)) (not (IsFlag 61)))
						(self setScript: (ScriptID 220 16) self) ; sDDefaultChoices
					)
					((and (IsFlag 30) (not (IsFlag 93)))
						(self setScript: (ScriptID 220 9) self) ; sDCloroxChoices
					)
					(
						(and
							(== global113 5)
							(IsFlag 93)
							(not (IsFlag 76))
							(not (IsFlag 112))
						)
						(gMessager say: 26 0 63 0 self 202) ; "Sir?"
						(SetFlag 112)
					)
					((and (== global142 1) (not (IsFlag 94)))
						(self setScript: (ScriptID 220 15) self) ; sDAfterClorox
					)
					((and (== global113 15) (not (IsFlag 87)))
						(gMessager say: 10 2 59 1 self 202) ; "You'd better hurry up and rescue Cliffy, Captain. His air won't last forever."
					)
					((and (== global142 2) (not (IsFlag 75)))
						(self setScript: (ScriptID 220 11) self) ; sDThrakusChoices
					)
					((>= (eureka puke:) 4)
						(gMessager say: 13 0 6 2 self 202) ; "Well don't just sit there, Captain! |f8|do|f| something!"
					)
					((and (IsFlag 75) (!= global113 14))
						(gMessager say: 26 0 78 0 self 202) ; "We gotta stop the Goliath, sir. We can't let the pukoid mutants from hell slime the Star Confederacy."
					)
					((and (IsFlag 75) (== global113 14))
						(gMessager say: 26 0 14 0 self 202) ; "There's got to be a way to sneak aboard that ship."
					)
					(else
						(gMessager say: 10 2 7 1 self 202) ; "I don't feel like chatting at the moment, sir."
					)
				)
			)
			(3
				(gEgo hide:)
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(4
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 3))
				(gGame setCursor: 983 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 220)
		(DisposeScript 217)
	)
)

