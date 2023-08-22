;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n030)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm250 0
	sherryTalker 1
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

(instance rm250 of Room
	(properties
		noun 1
		picture 250
	)

	(method (cue)
		(gGlobalSound0 number: 522 loop: -1 setVol: 100 play:)
	)

	(method (doVerb theVerb)
		(cond
			((not (gCast contains: sherry))
				(super doVerb: theVerb)
			)
			((and (== theVerb 27) (not local1) (!= gPrevRoomNum 270)) ; badge
				(gMessager say: 8 27 25 0) ; "You should be direct when displaying your badge."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(gGlobalSound0 fade:)
		(proc0_4 1)
		(gGame handsOff:)
		(super init: &rest)
		(theSign init:)
		(inBoxes init:)
		(cabinets init:)
		(partition init:)
		(if (== gPrevRoomNum 270)
			(gGlobalSound0 number: 522 loop: -1 setVol: 100 play:)
			(gEgo
				view: 9254
				setLoop: -1
				setLoop: 0
				setCel: 0
				setScale: 0
				signal: (| (gEgo signal:) $1000)
				posn: 258 161
				setTalker: egoTalker
				show:
				init:
			)
		else
			(gEgo
				view: 9250
				setLoop: -1
				setLoop: 0
				setCel: 0
				setScale: 0
				signal: (| (gEgo signal:) $1000)
				posn: 170 168
				setTalker: egoTalker
				show:
				init:
			)
		)
		(if (and (gEgo has: 23) (== gDay 4) (< global123 2)) ; boneBaggie
			(gEgo setCycle: End)
		else
			(cond
				((!= gPrevRoomNum 270)
					(if (== gDay 3)
						(LoadMany rsVIEW 250)
						(sherry view: 250 loop: 0 cel: 0 posn: 215 99)
					else
						(LoadMany rsVIEW 255)
						(sherry view: 255 loop: 0 cel: 8 posn: 209 99)
					)
				)
				((== gDay 5)
					(sherry view: 255 loop: 0 cel: 8 posn: 209 99)
				)
			)
			(sherry init:)
		)
		(if (gCast contains: sherry)
			(self setScript: egoComeIn)
		else
			(gGlobalSound0 number: 522 loop: -1 setVol: 100 play:)
			(sherryArea init:)
			(gGame handsOn:)
		)
		(gWalkHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(cond
				((> (event x:) (+ (gEgo x:) 50))
					(cond
						((== gPrevRoomNum 270)
							(if (gCast contains: sherry)
								(local0 actions: 0)
							)
							(gCurRoom newRoom: 270)
						)
						(
							(and
								local1
								(not
									(or
										(and
											(or
												(gEgo has: 4) ; hickmanStuff
												(==
													((gInventory at: 4) owner:) ; hickmanStuff
													790
												)
											)
											(or
												(gEgo has: 40) ; washStuff
												(==
													((gInventory at: 40) owner:) ; washStuff
													190
												)
											)
											(== gDay 2)
										)
										(and
											(gPqFlags test: 35)
											(== gDay 3)
										)
										(and
											(not (gEgo has: 17)) ; newspaper
											(== gDay 4)
										)
										(and
											(== ((gInventory at: 23) owner:) 275) ; boneBaggie
											(== gDay 4)
										)
										(and (== gDay 5) (!= gPrevRoomNum 270))
									)
								)
							)
							(self setScript: leaveRoom)
						)
						((gCast contains: sherry)
							(self setScript: comeBack)
						)
						(else
							(self setScript: leaveRoom)
						)
					)
				)
				((or (> (event y:) (gEgo y:)) (< (event x:) 160))
					(self setScript: leaveMorgue)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gGlobalSound0 loop: 1 setVol: 127 fade:)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance leaveMorgue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 9256)
				(if (gCast contains: sherry)
					(local0 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 9250)
				(if (== gPrevRoomNum 270)
					(if (gCast contains: sherry)
						(local0 actions: 0 dispose:)
					)
					(gEgo
						posn: 258 161
						view: 9256
						loop: 0
						cel: 0
						setCycle: End self
					)
				else
					(if (gCast contains: sherry)
						(local0 actions: 0 dispose:)
					)
					(gEgo view: 9250 loop: 0)
					(gEgo setCel: (gEgo lastCel:) posn: 170 168)
					(= cycles 3)
				)
			)
			(2
				(if (gPqFlags test: 11)
					(switch gDay
						(2
							(gPqFlags set: 9)
						)
						(4
							(gPqFlags set: 10)
						)
					)
					(gPqFlags clear: 11)
				)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: sherry)
					(local0 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (gCast contains: sherry)
					(local0 actions: 0 dispose:)
				)
				(if (and (gCast contains: sherry) (not (sherry script:)))
					(LoadMany rsVIEW 251 9253)
					(sherry
						view: 251
						loop: 0
						cel: 6
						posn: 216 100
						setCycle: Beg
					)
				)
				(gEgo
					view: 9253
					loop: 0
					cel: 0
					posn: 194 168
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance egoComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gPrevRoomNum 270)
					(if (== gDay 3)
						(sherry setScript: dayDream self)
					else
						(sherry setScript: fileNails self)
					)
					(gEgo setCycle: End)
				else
					(if (== gDay 5)
						(sherry setScript: fileNails 0 1)
					)
					(gEgo setCycle: End self)
				)
			)
			(1
				(if (!= gPrevRoomNum 270)
					(LoadMany rsVIEW 9251)
					((= local0 (Actor new:))
						name: {egoHead}
						view: 9251
						loop: 1
						cel: 0
						posn: 171 62
						actions: gEgo
						sightAngle: 360
						init:
						setCycle: End self
					)
					(gEgo view: 9251 loop: 0 cel: 0)
				else
					(LoadMany rsVIEW 9255)
					((= local0 (Actor new:))
						name: {egoHead}
						view: 9255
						loop: 1
						cel: 0
						posn: 288 60
						actions: gEgo
						sightAngle: 360
						init:
						setCycle: End self
					)
					(gEgo view: 9255 loop: 0 cel: 0)
				)
				(cond
					((and (gCast contains: sherry) (!= gPrevRoomNum 270))
						(if (== gDay 3)
							(sherry setScript: stopDream self)
						else
							(sherry setScript: stopFile self)
						)
					)
					((== gDay 5)
						(gCurRoom setScript: sherrySorry)
					)
					(else
						(self cue:)
					)
				)
			)
			(2 0)
			(3
				(if (!= gPrevRoomNum 270)
					(sherry setScript: waveHi self)
				else
					(self cue:)
				)
			)
			(4
				(if (and (== gDay 5) (!= gPrevRoomNum 270))
					(gMessager say: 3 2 21 1 self) ; "Hi, Detective Carey! I have a message for you from Deputy Sam. He said to tell you that.... um, that 'he sent Jane Doe's juices to Sid's!'"
				else
					(self cue:)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sherrySorry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sherry setScript: stopFile self)
			)
			(1
				(gMessager say: 3 2 23 1 self) ; "I'm really sorry about the newswoman, Detective Carey."
			)
			(2
				(sherry setScript: startFile)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance comeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (sherry script:)
					(fileNails
						(sherry setScript: stopFile self)
					)
					(dayDream
						(sherry setScript: stopDream self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(local0 setCycle: Beg self)
			)
			(2
				(LoadMany rsVIEW 9253)
				(local0 hide:)
				(gEgo
					view: 9253
					loop: 0
					cel: 0
					posn: 194 168
					setCycle: End self
				)
			)
			(3
				(gMessager say: 3 2 3 1 self) ; "Detective Carey, you know better!"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(LoadMany rsVIEW 9251)
				(local0 show: setCycle: End self)
				(gEgo view: 9251 loop: 0 cel: 0 posn: 170 168)
				(if
					(or
						local1
						(and
							(or
								(gEgo has: 4) ; hickmanStuff
								(== ((gInventory at: 4) owner:) 790) ; hickmanStuff
							)
							(or
								(gEgo has: 40) ; washStuff
								(== ((gInventory at: 40) owner:) 190) ; washStuff
							)
							(== gDay 2)
						)
						(and (gPqFlags test: 35) (== gDay 3))
						(and (not (gEgo has: 17)) (== gDay 4)) ; newspaper
						(and
							(== ((gInventory at: 23) owner:) 275) ; boneBaggie
							(== gDay 4)
						)
						(and (== gDay 5) (!= gPrevRoomNum 270))
					)
					(= cycles 1)
				else
					(LoadMany rsVIEW 254)
					(sherry
						view: 254
						loop: 0
						cel: 0
						posn: 211 100
						setCycle: End self
					)
				)
			)
			(6 0)
			(7
				(cond
					(
						(or
							(and
								(or
									(gEgo has: 4) ; hickmanStuff
									(== ((gInventory at: 4) owner:) 790) ; hickmanStuff
								)
								(or
									(gEgo has: 40) ; washStuff
									(== ((gInventory at: 40) owner:) 190) ; washStuff
								)
								(== gDay 2)
							)
							(and (gPqFlags test: 35) (== gDay 3))
							(and (not (gEgo has: 17)) (== gDay 4)) ; newspaper
							(and
								(== ((gInventory at: 23) owner:) 275) ; boneBaggie
								(== gDay 4)
							)
							(and (== gDay 5) (!= gPrevRoomNum 270))
						)
						(if (== gDay 5)
							(gMessager say: 3 2 22 2 self) ; "He's busy, Detective... that's why he left you the message!"
						else
							(gMessager say: 3 2 4 1 self) ; "Detective Carey, Deputy Nobles really is busy. Honest."
						)
					)
					((not local1)
						(sherry loop: 1 cel: 0 setCycle: End)
						(gMessager say: 3 2 3 2 self) ; "Show me your badge."
					)
					(else
						(self cue:)
					)
				)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wagFinger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (sherry script:)
					(fileNails
						(sherry setScript: stopFile self)
					)
					(dayDream
						(sherry setScript: stopDream self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gMessager say: 3 2 8 1 self) ; "I'd like to see Deputy Nobles. Is he available?"
			)
			(2
				(LoadMany rsVIEW 254)
				(sherry
					view: 254
					loop: 0
					cel: 0
					posn: 211 100
					setCycle: End self
				)
			)
			(3
				(sherry loop: 1 cel: 0 setCycle: End)
				(gMessager say: 3 2 3 2 self) ; "Show me your badge."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(LoadMany rsVIEW 9252 9251)
				(gEgo
					view: 9252
					loop: 0
					cel: 0
					posn: 184 168
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 9251 loop: 0 cel: 0 posn: 170 168)
				(= cycles 1)
			)
			(4
				(if local2
					(self cue:)
				else
					(++ local2)
					(if (== gDay 3)
						(sherry setScript: startDream)
					else
						(sherry setScript: startFile)
					)
					(gMessager say: 3 2 7 1 self) ; "No time to say hello, Detective Carey? Wow, you must be real busy!"
				)
			)
			(5
				(if
					(or
						(and
							(or
								(gEgo has: 4) ; hickmanStuff
								(== ((gInventory at: 4) owner:) 790) ; hickmanStuff
							)
							(or
								(gEgo has: 40) ; washStuff
								(== ((gInventory at: 40) owner:) 190) ; washStuff
							)
							(== gDay 2)
						)
						(and (gPqFlags test: 35) (== gDay 3))
						(and (not (gEgo has: 17)) (== gDay 4)) ; newspaper
						(and
							(== ((gInventory at: 23) owner:) 275) ; boneBaggie
							(== gDay 4)
						)
						(and (== gDay 5) (!= gPrevRoomNum 270))
					)
					(gMessager say: 3 27 4 1 self) ; "Deputy Nobles is up to his elbows in an autopsy. He can't be interrupted right now. Really."
				else
					(gMessager say: 3 2 5 1 self) ; "You can go on in, Detective Carey."
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadgeDay5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 9252 9251)
				(gGame handsOff:)
				(= local1 1)
				(gEgo
					view: 9252
					loop: 0
					cel: 0
					posn: 184 168
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 9251 loop: 0 cel: 0 posn: 170 168)
				(= cycles 1)
			)
			(4
				(gMessager say: 3 27 22 1 self) ; "I just love the way you flip your badge, Detective Carey. But it won't do you any good today! Deputy Sam is really busy and no one can see him!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 251)
				(sherry
					view: 251
					loop: 0
					cel: 6
					posn: 216 100
					setCycle: Beg self
				)
			)
			(1
				(sherry setScript: dayDream 0 1)
			)
		)
	)
)

(instance dayDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 250)
				(sherry
					view: 250
					loop: 0
					cel: 0
					posn: 215 99
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(sherry loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= ticks 60)
			)
			(4
				(sherry loop: 0 cel: 0)
				(= local3 0)
				(if register
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance fileNails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 255)
				(sherry
					view: 255
					loop: 0
					cel: 8
					posn: 209 99
					setCycle: End self
				)
			)
			(1
				(sherry loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(= ticks (Random 6 20))
			)
			(3
				(sherry setCycle: Beg self)
			)
			(4
				(sherry loop: 0 cel: (sherry lastCel:) setCycle: CT 8 -1 self)
			)
			(5
				(if register
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance stopFile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sherry setCycle: (if (sherry loop:) End else Beg) self)
			)
			(1
				(LoadMany rsVIEW 251)
				(sherry view: 251 loop: 0 cel: 0 posn: 216 100)
				(if (and (== gDay 5) (== gPrevRoomNum 270))
					(= cycles 1)
				else
					(sherry setCycle: CT 6 1 self)
				)
			)
			(2
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance stopDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 251)
				(sherry setCycle: (if (sherry loop:) End else Beg) self)
			)
			(1
				(sherry
					view: 251
					loop: 0
					cel: 0
					posn: 216 100
					setCycle: CT 6 1 self
				)
			)
			(2
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance startFile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gDay 5) (== gPrevRoomNum 270))
					(= cycles 1)
				else
					(LoadMany rsVIEW 251 255)
					(sherry
						view: 251
						loop: 0
						cel: 6
						posn: 216 100
						setCycle: Beg self
					)
				)
			)
			(1
				(sherry
					view: 255
					loop: 0
					cel: 0
					posn: 209 99
					setCycle: CT 8 1 self
				)
			)
			(2
				(sherry setScript: fileNails 0 1)
			)
		)
	)
)

(instance coronerBusy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (sherry script:)
					(fileNails
						(sherry setScript: stopFile self)
					)
					(dayDream
						(sherry setScript: stopDream self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (== gDay 5)
					(self cue:)
				else
					(gMessager say: 3 2 8 1 self) ; "I'd like to see Deputy Nobles. Is he available?"
				)
			)
			(2
				(if (== gDay 5)
					(gMessager say: 3 2 22 0 self) ; "I'd like to see Sam, Sherry."
				else
					(gMessager say: 3 2 4 1 self) ; "Detective Carey, Deputy Nobles really is busy. Honest."
				)
			)
			(3
				(sherry cycleSpeed: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance waveHi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 251)
				(gGlobalSound1 number: 251 loop: 1 play: gCurRoom)
				(sherry
					view: 251
					loop: 0
					cel: 6
					posn: 216 100
					setCycle: End self
				)
			)
			(1
				(sherry loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(2
				(if (== gDay 5)
					(self cue:)
				else
					(gMessager say: 3 2 6 1 self) ; "Hi, Detective Carey!"
				)
			)
			(3
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance shhhh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sherry setScript: stopFile self)
			)
			(1
				(switch local2
					(0
						(gMessager say: 3 2 12 0 self) ; "Sure. Next time just keep quiet. Don't talk to those people, they'll twist your words around, make your life miserable. Got it?"
					)
					(1
						(gMessager say: 3 2 18 0 self) ; "Everything understood?"
					)
					(2
						(gMessager say: 3 2 19 0 self) ; "I didn't mean..."
					)
					(else
						(gMessager say: 3 2 20 0 self) ; "Sherry..."
					)
				)
			)
			(2
				(++ local2)
				(sherry setScript: startFile)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance thanksDay5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 6 2 self) ; "Hello, Sherry."
			)
			(1
				(gMessager say: 3 2 21 2 self) ; "Sent Jane Doe's juices to SID? Thanks, Sherry."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sherry of Prop
	(properties
		noun 3
		sightAngle 359
		x 209
		y 99
		priority 100
		fixPriority 1
		view 255
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; badge
				(if (and (not local1) (!= gPrevRoomNum 270))
					(if (== gDay 5)
						(gCurRoom setScript: showBadgeDay5)
					else
						(gCurRoom setScript: showBadge)
					)
				else
					(gMessager say: 3 27 3 0) ; "Sherry only requires you to show your badge once a visit."
				)
			)
			(2 ; Talk
				(cond
					((== gPrevRoomNum 270)
						(if (== gDay 5)
							(gCurRoom setScript: shhhh)
						else
							(gMessager say: 3 2 1 1) ; "Good-bye, and have a nice day, Detective Carey!"
						)
					)
					((not local2)
						(++ local2)
						(switch gDay
							(5
								(gCurRoom setScript: thanksDay5)
							)
							(4
								(gMessager sayRange: 3 2 6 2 3) ; "Hello, Sherry."
							)
							(else
								(gMessager say: 3 2 6 2) ; "Hello, Sherry."
							)
						)
					)
					(
						(or
							(and
								(or
									(gEgo has: 4) ; hickmanStuff
									(== ((gInventory at: 4) owner:) 790) ; hickmanStuff
								)
								(or
									(gEgo has: 40) ; washStuff
									(== ((gInventory at: 40) owner:) 190) ; washStuff
								)
								(== gDay 2)
							)
							(and (gPqFlags test: 35) (== gDay 3))
							(and (not (gEgo has: 17)) (== gDay 4)) ; newspaper
							(and
								(== ((gInventory at: 23) owner:) 275) ; boneBaggie
								(== gDay 4)
							)
							(and (== gDay 5) (!= gPrevRoomNum 270))
						)
						(gCurRoom setScript: coronerBusy)
					)
					(local1
						(switch (sherry script:)
							(fileNails
								(sherry setScript: stopFile)
							)
							(dayDream
								(sherry setScript: stopDream)
							)
						)
						(gMessager sayRandom: 3 2 2)
					)
					(local2
						(gCurRoom setScript: wagFinger)
					)
					(else
						(gMessager sayRandom: 3 2 2)
					)
				)
			)
			(4 ; Do
				(switch local4
					(0
						(++ local4)
						(gMessager say: 3 4 17 0) ; "Detective Carey! You're a flirt!"
					)
					(1
						(++ local4)
						(gMessager say: 3 4 13 0) ; "Detective Carey, you're getting fresh!"
					)
					(2
						(++ local4)
						(gMessager say: 3 4 14 0) ; "Detective Carey, if I didn't know better, I'd think you were harassing me, sexually that is."
					)
					(3
						(++ local4)
						(gMessager say: 3 4 15 0) ; "Detective Carey, if you don't stop, I'm going to scream!"
					)
					(else
						(gMessager say: 3 4 16 0) ; "Help! Detective Carey has roving hands! HELP!!"
					)
				)
			)
			(11 ; washStuff
				(if local6
					(gMessager say: noun theVerb 13 1) ; "Detective Carey, that envelope needs to go to that little boy's mom!"
				else
					(= local6 1)
					(gMessager say: noun theVerb 17 1) ; "That poor little boy, being shot like that. You're going to find out who did that, aren't you?"
				)
			)
			(22 ; handgun
				(switch local5
					(0
						(++ local5)
						(gMessager say: 3 22 17 0) ; "She might not be a brain surgeon but in this world"
					)
					(1
						(++ local5)
						(gMessager say: 3 22 13 0) ; "Stupidity is not a crime. Put the gun away."
					)
					(else
						(EgoDead 3 22 14 1 250 972) ; "Your ethics are deplorable."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sherryArea of Feature
	(properties
		noun 1
		nsLeft 183
		nsTop 36
		nsRight 235
		nsBottom 94
		sightAngle 360
		x 209
		y 99
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 24 1) ; "Hum? Sherry's not here. That's not like her."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 8
		sightAngle 360
		x 155
		y 74
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 133 58 161 58 166 94 138 95
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((not (gCast contains: sherry))
				(super doVerb: theVerb)
			)
			((and (== theVerb 27) (not local1) (!= gPrevRoomNum 270)) ; badge
				(gMessager say: 8 27 25 0) ; "You should be direct when displaying your badge."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cabinets of Feature
	(properties
		noun 6
		sightAngle 360
		x 257
		y 67
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 224 59 264 60 275 59 275 67 272 69 270 71 264 73 261 74 252 72 247 77 243 80 234 80 225 79
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 1) ; Do, Look
				(gMessager say: noun theVerb 0 0)
			)
			((== theVerb 2) ; Talk
				(super doVerb: theVerb)
			)
			((== theVerb 27) ; badge
				(cond
					((not (gCast contains: sherry))
						(super doVerb: theVerb)
					)
					((or local1 (== gPrevRoomNum 270))
						(super doVerb: theVerb)
					)
					(else
						(gMessager say: 8 27 25 0) ; "You should be direct when displaying your badge."
					)
				)
			)
			(else
				(gMessager say: noun 6 0 0) ; "You have an investigation to conduct!"
			)
		)
	)
)

(instance inBoxes of Feature
	(properties
		noun 5
		sightAngle 360
		x 68
		y 110
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 86 91 111 88 142 91 139 104 113 107 93 102 94 104 89 111 53 115 31 108 31 100 45 103 64 103 64 100 68 99 68 98 74 98 79 99 88 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 1 68 71) ; Do, Look, funeralMemo, qualifyMemo
				(gMessager say: noun theVerb 0 0)
			)
			((== theVerb 2) ; Talk
				(super doVerb: theVerb)
			)
			((== theVerb 27) ; badge
				(cond
					((not (gCast contains: sherry))
						(super doVerb: theVerb)
					)
					((or local1 (== gPrevRoomNum 270))
						(super doVerb: theVerb)
					)
					(else
						(gMessager say: 8 27 25 0) ; "You should be direct when displaying your badge."
					)
				)
			)
			(else
				(gMessager say: noun 6 0 0) ; "There are probably a lot more productive things you"
			)
		)
	)
)

(instance partition of Feature
	(properties
		noun 4
		sightAngle 360
		x 89
		y 73
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 0 54 176 54 182 55 220 56 221 88 0 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (gCast contains: sherry))
				(super doVerb: theVerb)
			)
			((and (== theVerb 27) (not local1) (!= gPrevRoomNum 270)) ; badge
				(gMessager say: 8 27 25 0) ; "You should be direct when displaying your badge."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoTalker of Narrator
	(properties
		x 80
		y 10
	)

	(method (init)
		(if (== gPrevRoomNum 270)
			(self x: 190 talkWidth: 120)
		)
		(super init: &rest)
	)
)

(instance sherryTalker of Narrator
	(properties
		x 190
		y 10
	)

	(method (init)
		(if (== gPrevRoomNum 270)
			(self x: 80)
		else
			(self talkWidth: 120)
		)
		(super init: &rest)
	)
)

