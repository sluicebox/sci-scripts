;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm90 0
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
)

(instance rm90 of Rm
	(properties
		picture 90
		style 0
	)

	(method (init)
		(SL enable:)
		(HandsOn)
		(Load rsVIEW 105)
		(Load rsVIEW 110)
		(Load rsVIEW 109)
		(Load rsVIEW 111)
		(Load rsSOUND 14)
		(Load rsSOUND 49)
		(Load rsSOUND 57)
		(Load rsSOUND 67)
		(Load rsSOUND 60)
		(Load rsSOUND 74)
		(super init:)
		(self setScript: rmScript)
	)

	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (and (< (gEgo x:) 84) (== local3 90))
					(cond
						(
							(Said
								'look[/area,partition,left,right,up,down,ceiling,deck]'
							)
							(Print 90 0) ; "You find yourself in... Guess... A janitor's closet. You certainly have a sixth sense about this kind of thing."
						)
						((Said 'look/door')
							(Print 90 1) ; "The door leads back into the hallway."
						)
						((Said 'look,explore/area,closet')
							(gEgo setScript: searchScript)
						)
						((Said 'get,wear,drop,change,switch,explore/attire')
							(if (gEgo has: 12) ; Coveralls
								(Print 90 2) ; "That you did."
							else
								(Print 90 3) ; "What a great idea, Roger! No one would be suspicious of a janitor walking around. You grab the coveralls and pull them on (seizing the opportune moment to dump all of the old items you've been pocketing along the way). What a great disguise! Wait... what's this?"
								(Print 90 4) ; "You reach down into the pocket of the grimy coveralls and find... well, what do you know, Mr. Garbage! A trash vaporizer. You've seen these babies in all the janitorial supply catalogs but your superiors were always too cheap to outfit you with one."
								(for ((= temp0 0)) (<= temp0 16) ((++ temp0))
									(if (gEgo has: temp0)
										(gEgo put: temp0 -1)
									)
								)
								(gEgo view: 109 get: 12 get: 13) ; Coveralls, Vaporizer
								(gGame changeScore: 5)
							)
						)
						((Said 'disembark,disembark[/area,closet]')
							(Print 90 5) ; "Just walk out."
						)
					)
				)
				(cond
					((Said 'get/life[<a]')
						(if global200
							(gEgo view: 109 get: 11 12 13 15) ; Keycard
						else
							(event claimed: 0)
						)
					)
					(
						(Said
							'look[/area,corridor,deck,dirt,ceiling,partition,up,down,left,right]'
						)
						(cond
							((<= 114 (gEgo x:) 203)
								(if
									(or
										(== (gEgo loop:) 3)
										(== (gEgo loop:) 2)
									)
									(if (== local0 {some})
										(= local0 {no})
									else
										(= local0 {some})
									)
									(Printf 90 6 local0) ; "You are walking down a circular hallway... going %swhere."
								else
									(Print 90 7) ; "You are in a hallway... somewhere deep in the innards of ScumSoft, Inc."
								)
							)
							(
								(or
									(and
										(== (gEgo loop:) 1)
										(> (gEgo x:) 114)
									)
									(and
										(== (gEgo loop:) 0)
										(< (gEgo x:) 203)
									)
								)
								(Print 90 8) ; "You are entering an interminably long hallway."
							)
							(else
								(Print 90 9) ; "You are leaving the hallway."
							)
						)
					)
					((Said 'look/closet')
						(Print 90 10) ; "Technically speaking, you're in a hallway."
					)
					((Said 'look/door')
						(if (or (== local1 wHallDoor) (== local1 eHallDoor))
							(if local4
								(Print 90 11) ; "The door has a keycard security system as well as a composite facial scanner. It will be pretty tricky gaining access."
							else
								(Print 90 12) ; "A door leads out of the hallway."
							)
						else
							(Print 90 13) ; "There's not a door in sight."
						)
					)
					((or (Said 'look/mrgarbage') (Said 'look/garbage<mr'))
						(if (gEgo has: 13) ; Vaporizer
							((gInventory at: 13) showSelf:) ; Vaporizer
						else
							(event claimed: 0)
						)
					)
					((Said 'remove/attire[<janitor]')
						(if (gEgo has: 12) ; Coveralls
							(Print 90 14) ; "Second quessing yourself, you leave the `disguise' on."
						else
							(event claimed: 0)
						)
					)
					(
						(or
							(Said 'blast')
							(Said 'use/mrgarbage')
							(Said 'use/garbage<mr')
						)
						(if (gEgo has: 13) ; Vaporizer
							(Print 90 15) ; "This is neither the time nor the place for that."
						else
							(Print 90 16) ; "'Using what?' you ask of yourself."
						)
					)
					((Said 'find,get/card')
						(Print 90 17) ; "Do that."
					)
					((Said 'look/device,keylock,latch,card,girder,device')
						(if (and (== local1 eHallDoor) (== local3 95))
							(Print 90 18) ; "A security system adjoins this door. There must be something worthwhile on the other side."
						else
							(event claimed: 0)
						)
					)
					((Said '*/device,keylock,latch,girder,device')
						(if (and (== local1 eHallDoor) (== local3 95))
							(Print 90 19) ; "Tampering with the security system can only lead to misfortune."
						else
							(event claimed: 0)
						)
					)
					((Said 'open/door[<corridor]')
						(if (and local4 (<= 186 (gEgo x:) 203))
							(Print 90 20) ; "This door is locked."
						else
							(Print 90 21) ; "Walk in front of a door if you want it to open."
						)
					)
					((Said 'close,close/door[<corridor]')
						(Print 90 22) ; "Don't worry about the doors; they'll take care of themselves."
					)
					(
						(or
							(Said 'drop,use,insert,enter/card,key')
							(Said 'unlock/door[<corridor]')
						)
						(cond
							((not (and local4 (<= 186 (gEgo x:) 203)))
								(Print 90 23) ; "You are not near a locked door."
							)
							((not (gEgo has: 11)) ; Keycard
								(Print 90 24) ; "Easier said than done without the proper keycard."
							)
							((not (User canControl:))
								(Print 90 25) ; "These things take time..."
							)
							((not (== (gEgo loop:) 0))
								(Print 90 26) ; "You're not facing a locked door."
							)
							((or (<= (scanner y:) 90) (>= (scanner y:) 95))
								(Print 90 27) ; "You need to get closer to the scanner."
							)
							(else
								(gEgo setScript: scanScript)
							)
						)
					)
					((Said '*/door')
						(if local4
							(Print 90 28) ; "Do or don't; the fact remains the door is locked."
						else
							(Print 90 29) ; "The door is not an obstacle."
						)
					)
					((Said 'look/crack,crack')
						(Print 90 30) ; "Don't step on a crack!"
					)
					((Said 'explore,look/pocket')
						(if (gEgo has: 12) ; Coveralls
							(Print 90 31) ; "You've already found the vaporizer; the handkerchief is a permanent fixture."
						else
							(Print 90 32) ; "You haven't got any!"
						)
					)
					(
						(or
							(Said 'copy<use')
							(Said
								'drop,hold,show,use,position,place/original,copy'
							)
						)
						(if (gEgo has: 15) ; a_copy_of_Elmo_s_picture
							(if (== (gEgo view:) 105)
								(gEgo setLoop: 1 setCel: 0 setCycle: End)
								(User canInput: 0)
							else
								(Print 90 33) ; "You wouldn't be able to see where you were going."
							)
						else
							(Print 90 34) ; "You don't have such."
						)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
	)
)

(instance searchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(searchSound prevSignal: 0)
				(searchSound play:)
				(= cycles 1)
			)
			(1
				(if (!= (searchSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(HandsOn)
					(if (IsItemAt 12) ; Coveralls
						(Print 90 35) ; "Rummaging about the cramped closet you find a pair of old, grimy janitorial coveralls."
					else
						(Print 90 36) ; "Your thorough search reveals a lot of used junk, but nothing of value to you."
					)
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance scanScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hallSound stop:)
				(gEgo
					view: 105
					setLoop: 0
					setCel: 0
					x: 202
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(keycardSound play:)
				(Timer setReal: self 2)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(Print 90 37) ; "You hear several clicks. "I'm in" you think to yourself."
				(Print 90 38) ; "Then you hear a synthesized voice say, "Keycard verified. Standby for composite facial scan.""
				(User canInput: 1)
				(gEgo setPri: 13)
				(Timer setReal: self 3)
			)
			(4
				(User canInput: 0)
				(if (== (gEgo loop:) 1)
					(Timer setReal: self 3)
				else
					(= cycles 1)
				)
			)
			(5
				(face init:)
				(scanner setLoop: 6)
				(= local9 6)
				(= cycles 1)
			)
			(6
				(scannerSound play:)
				(face setCel: 0 setCycle: End)
				(scanner setCel: 0 setCycle: End self)
			)
			(7
				(if (-- local9)
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(8
				(face dispose:)
				(scanner setLoop: 5 setCel: 4 setCycle: 0 stopUpd:)
				(Timer setReal: self 2)
			)
			(9
				(if (== (gEgo loop:) 1)
					(= local4 0)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(10
				(gEgo
					view: 109
					setLoop: -1
					setCel: -1
					setDirection: 3
					setMotion: 0
					setCycle: Walk
				)
				(Timer setCycle: self 3)
			)
			(11
				(if local4
					(Print 90 39 #at -1 20 #width 280) ; "Composite Facial Scan complete: Access denied."
				)
				(hallSound play:)
				(HandsOn)
			)
			(12
				(self init:)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gEgo
			view: (if (gEgo has: 13) 109 else 110) ; Vaporizer
			setPri: 13
			setCel: -1
			setLoop: -1
			setCycle: Walk
			setStep: 3 1
			x: (if (== gPrevRoomNum 86) 65 else 262)
			y: (if (== gPrevRoomNum 86) 123 else 119)
			setDirection: (if (== gPrevRoomNum 86) 3 else 7)
			observeBlocks: egoArea
			init:
		)
		(wHallDoor init:)
		(eHallDoor init:)
		(bPanelLine init:)
		(tPanelLine init:)
		(egoArea init:)
		(scanner init:)
		(hallSound init:)
		(doorSound init:)
		(ouchSound init:)
		(scannerSound init:)
		(keycardSound init:)
		(searchSound init:)
		(hallSound play:)
		(switch gPrevRoomNum
			(91
				(self changeState: (= state 5))
			)
			(95
				(gGame changeScore: -20)
				(self changeState: (= state 13))
			)
			(86
				(self changeState: (= state 0))
			)
			(else
				(gEgo posn: 65 123 setDirection: 3)
				(self changeState: (= state 0))
			)
		)
	)

	(method (changeState newState)
		(= local8 state)
		(switch (= state newState)
			(0
				(= local1 wHallDoor)
				(= local3 86)
				(= local2 wDoorScript)
			)
			(1
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(2)
			(3)
			(4
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(5
				(= local1 eHallDoor)
				(= local3 91)
				(= local2 eDoorScript)
			)
			(6
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(7
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(8
				(= local1 wHallDoor)
				(= local3 90)
				(= local2 wDoorScript)
			)
			(9
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(10)
			(11)
			(12
				(= local1 bPanelLine)
				(= local2 panelScript)
				(= local4 0)
			)
			(13
				(= local1 eHallDoor)
				(= local3 95)
				(= local2 eDoorScript)
				(if (< (gEgo x:) 203)
					(= local4 1)
				)
			)
			(14
				(= local1 bPanelLine)
				(= local2 panelScript)
				(= local4 0)
			)
			(15
				(= local1 bPanelLine)
				(= local2 panelScript)
			)
			(16
				(= state -1)
				(self changeState: 0)
			)
			(else
				(= state 16)
				(self changeState: 15)
			)
		)
		(cond
			((> state local8)
				(local2 state: -1)
			)
			((< state local8)
				(local2 state: (local2 start:))
			)
			(else
				(local2 changeState: (- (local1 lastCel:) 1))
			)
		)
	)

	(method (doit)
		(switch (gEgo loop:)
			(0
				(cond
					((>= (gEgo x:) 203)
						(cond
							(
								(and
									(> (gEgo y:) (+ 119 (gEgo yStep:)))
									(< (gEgo x:) (+ 203 (gEgo xStep:)))
								)
								(if (== local6 2)
									(gEgo posn: 203 119)
								else
									(gEgo posn: 202 130 setDirection: 0)
									(ShakeScreen 4 ssLEFTRIGHT)
									(ouchSound play:)
								)
							)
							((> (gEgo x:) 262)
								(if (== local3 91)
									(gEgo setDirection: 1)
									(gCurRoom newRoom: 91)
								else
									(gCurRoom newRoom: 95)
									(gGame changeScore: 20)
								)
							)
							(else
								(gEgo y: 119)
							)
						)
					)
					((>= (gEgo x:) 114)
						(if (== (gEgo y:) 123)
							(gEgo y: 130)
						else
							(gEgo y: 130)
							(cond
								((and (> (gEgo x:) 131) (== local5 0) local7)
									(gEgo setDirection: local7)
									(= local7 0)
									(User canControl: 1)
								)
								((== local6 0)
									(cond
										((== (eDoorScript state:) 3)
											(gEgo setScript: eDoorScript)
										)
										((== (eDoorScript state:) 5)
											(eDoorScript
												changeState:
													(- (eDoorScript state:) 1)
											)
										)
									)
								)
							)
						)
					)
					(else
						(gEgo y: 123)
					)
				)
			)
			(1
				(cond
					((<= (gEgo x:) 114)
						(cond
							(
								(and
									(> (gEgo y:) (+ 123 (gEgo yStep:)))
									(> (gEgo x:) (- 114 (gEgo xStep:)))
								)
								(if (== local5 2)
									(gEgo posn: 114 123)
								else
									(gEgo posn: 115 130 setDirection: 0)
									(ShakeScreen 4 ssLEFTRIGHT)
									(ouchSound play:)
								)
							)
							((< (gEgo x:) 65)
								(if (== local3 90)
									(gEgo posn: 65 123)
								else
									(gCurRoom newRoom: 86)
								)
							)
							(else
								(gEgo y: 123)
							)
						)
					)
					((<= (gEgo x:) 203)
						(if (== (gEgo y:) 119)
							(gEgo y: 130)
						else
							(gEgo y: 130)
							(cond
								(
									(and
										(< (gEgo x:) 186)
										(== local6 0)
										(!= local7 0)
									)
									(gEgo setDirection: local7)
									(= local7 0)
									(User canControl: 1)
								)
								((== local5 0)
									(cond
										((== (wDoorScript state:) 2)
											(gEgo setScript: wDoorScript)
										)
										((== (wDoorScript state:) 4)
											(wDoorScript
												changeState:
													(- (wDoorScript state:) 1)
											)
										)
									)
								)
							)
						)
					)
					(else
						(gEgo y: 119)
					)
				)
			)
			(2
				(if (< 131 (gEgo x:) 186)
					(if (and (!= (gEgo y:) 130) (== local5 0) (== local6 0))
						(gEgo posn: (gEgo x:) 130)
						(if (== (local2 state:) -1)
							(rmScript changeState: (- (rmScript state:) 1))
						)
						(local2 changeState: (- (local2 state:) 1))
					)
				else
					(User canControl: 0)
					(= local7 5)
					(gEgo setDirection: (if (<= (gEgo x:) 131) 3 else 7))
				)
			)
			(3
				(if (< 131 (gEgo x:) 186)
					(if (and (!= (gEgo y:) 130) (== local5 0) (== local6 0))
						(gEgo posn: (gEgo x:) 130)
						(if (== (local2 state:) (local2 start:))
							(rmScript cue:)
						)
						(local2 changeState: (+ (local2 state:) 1))
					)
				else
					(User canControl: 0)
					(= local7 1)
					(gEgo setDirection: (if (<= (gEgo x:) 131) 3 else 7))
				)
			)
		)
		(super doit:)
	)
)

(instance wDoorScript of Script
	(properties
		start 5
	)

	(method (changeState newState)
		(wHallDoor posn: 0 0 setCel: newState setPri: 6)
		(switch (= state newState)
			(0
				(wHallDoor posn: 119 123)
			)
			(1
				(wHallDoor posn: 113 124)
			)
			(2
				(wHallDoor posn: 110 127)
			)
			(3
				(wHallDoor posn: 104 130)
			)
			(4
				(wHallDoor posn: 93 135 setPri: 14)
			)
			(5
				(rmScript cue:)
			)
			(else
				(rmScript changeState: (- (rmScript state:) 1))
			)
		)
	)
)

(instance eDoorScript of Script
	(properties
		start 6
	)

	(method (changeState newState)
		(eHallDoor posn: 0 0 setCel: newState setPri: 5)
		(if (== local3 95)
			(scanner posn: 0 0 setCel: newState setPri: 6)
		)
		(switch (= state newState)
			(0
				(eHallDoor posn: 134 110)
				(if (== local3 95)
					(scanner posn: 151 85)
				)
			)
			(1
				(eHallDoor posn: 158 116)
				(if (== local3 95)
					(scanner posn: 176 86)
				)
			)
			(2
				(eHallDoor posn: 177 120)
				(if (== local3 95)
					(scanner posn: 197 87)
				)
			)
			(3
				(eHallDoor posn: 203 131)
				(if (== local3 95)
					(scanner posn: 221 89)
				)
			)
			(4
				(eHallDoor posn: 213 136)
				(if (== local3 95)
					(scanner posn: 229 91 setPri: 14)
				)
			)
			(5
				(eHallDoor posn: 226 131 setPri: 14)
			)
			(6
				(rmScript cue:)
			)
			(else
				(rmScript changeState: (- (rmScript state:) 1))
			)
		)
	)
)

(instance panelScript of Script
	(properties
		start 8
	)

	(method (changeState newState)
		(bPanelLine posn: 0 0)
		(tPanelLine posn: 0 0)
		(switch (= state newState)
			(0)
			(1
				(bPanelLine posn: 158 115)
				(tPanelLine posn: 158 50)
			)
			(2
				(bPanelLine posn: 158 119)
				(tPanelLine posn: 158 47)
			)
			(3
				(bPanelLine posn: 158 123)
				(tPanelLine posn: 158 43)
			)
			(4
				(bPanelLine posn: 158 127)
				(tPanelLine posn: 158 40)
			)
			(5
				(bPanelLine posn: 158 133)
				(tPanelLine posn: 158 37)
			)
			(6
				(bPanelLine posn: 158 135)
				(tPanelLine posn: 158 34)
			)
			(7)
			(8
				(rmScript cue:)
			)
			(else
				(rmScript changeState: (- (rmScript state:) 1))
			)
		)
	)
)

(instance wHallDoor of Prop
	(properties
		view 111
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 0 posn: 0 0 setPri: 6)
		(= local5 0)
	)

	(method (doit)
		(super doit:)
		(cond
			((<= 75 (gEgo x:) 131)
				(if (and (== (self loop:) 0) (== (self cel:) 3))
					(self setLoop: 1 setCel: 0)
					(= local5 1)
				)
				(if (== local5 1)
					(= local5 3)
					(doorSound play:)
					(self setCycle: End self)
				)
			)
			((or (== local5 3) (== local5 2))
				(= local5 1)
				(doorSound play:)
				(self setCycle: Beg self)
			)
		)
	)

	(method (cue)
		(if (== local5 1)
			(= local5 0)
			(wHallDoor setLoop: 0 setCel: 3 startUpd:)
		else
			(= local5 2)
			(wHallDoor stopUpd:)
		)
	)
)

(instance eHallDoor of Prop
	(properties
		view 111
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 2 posn: 0 0 setPri: 5)
		(= local6 0)
	)

	(method (doit)
		(super doit:)
		(cond
			((<= 186 (gEgo x:) 252)
				(if (and (== (self loop:) 2) (== (self cel:) 4) (not local4))
					(= local6 1)
					(self setLoop: 3 setCel: 0)
				)
				(if (== local6 1)
					(= local6 3)
					(doorSound play:)
					(self setCycle: End self)
				)
			)
			((or (== local6 3) (== local6 2))
				(= local6 1)
				(doorSound play:)
				(self setCycle: Beg self)
			)
		)
	)

	(method (cue)
		(if (== local6 1)
			(= local6 0)
			(self setLoop: 2 setCel: 4 startUpd:)
			(if (and (== local3 95) (< (gEgo x:) 203))
				(= local4 1)
			)
		else
			(= local6 2)
			(self stopUpd:)
		)
	)
)

(instance tPanelLine of Prop
	(properties
		view 111
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 4 posn: 0 0 setPri: 4)
	)
)

(instance bPanelLine of Prop
	(properties
		view 111
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 4 setPri: 4)
	)
)

(instance scanner of Prop
	(properties
		view 111
		loop 5
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setPri: 6)
	)
)

(instance face of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			setPri: 14
			view: 105
			x: (if (== (gEgo loop:) 1) 219 else 202)
			y: (if (== (gEgo loop:) 1) 81 else 80)
			setLoop: (if (== (gEgo loop:) 1) 3 else 2)
		)
	)
)

(instance egoArea of Cage
	(properties
		top 117
		bottom 132
		right 320
	)
)

(instance hallSound of Sound
	(properties
		number 14
		loop -1
	)
)

(instance doorSound of Sound
	(properties
		number 49
		priority 1
	)
)

(instance ouchSound of Sound
	(properties
		number 57
		priority 1
	)
)

(instance scannerSound of Sound
	(properties
		number 67
		priority 1
	)
)

(instance keycardSound of Sound
	(properties
		number 74
		priority 1
	)
)

(instance searchSound of Sound
	(properties
		number 60
		priority 1
	)
)

