;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm13 0
	proc13_1 1
)

(synonyms
	(console dash)
)

(local
	[local0 100]
	local100
	local101
	local102
	local103
	local104
	local105
	local106
	local107
	local108
	local109
	local110
	local111
	local112
	local113
	local114
	local115
	local116
	local117
	local118
	local119
	local120
	local121
)

(procedure (proc13_1)
	(if (and (== local109 local107) (== local110 local108))
		(NormalEgo)
		(Print 13 0) ; "OK, we're getting out."
		(if (and (== local103 25) (IsFlag 165))
			(= local103 225)
		)
		(NormalEgo)
		(gCurRoom newRoom: local103)
	else
		(Print 13 1) ; "Wait until the car has stopped moving."
	)
)

(procedure (localproc_0)
	(lines startUpd:)
	(extraScene hide:)
	(rightScene startUpd:)
	(leftScene startUpd:)
	(= local102 1)
	(= global130 13)
	(SetFlag 40)
	(= local116 300)
	(= local117 20)
)

(procedure (localproc_1)
	(= local118 0)
	(= local112 0)
	(DrawCel 180 4 0 4 145 15)
	(Display 13 2 dsWIDTH 316 dsCOORD 0 158 dsCOLOR 0 dsBACKGROUND 0 dsFONT 0) ; "-------------------------------------------------------------------------- ---------------------------------------------------------------------------- ----------"
)

(procedure (localproc_2 param1 param2 param3)
	(localproc_1)
	(= local118 80)
	(= local112 1)
	(DrawCel 180 param1 0 4 145 15)
	(= local111 15)
	(if (== argc 2)
		(Display (Format @local0 param2) dsWIDTH 316 dsCOORD 0 158 dsCOLOR local111 dsFONT 0)
	else
		(Display
			(Format @local0 param2 param3)
			dsWIDTH
			316
			dsCOORD
			0
			158
			dsCOLOR
			local111
			dsFONT
			0
		)
	)
)

(instance hand of View
	(properties)
)

(instance cig of Prop
	(properties)
)

(instance puff of Prop
	(properties)
)

(instance rightScene of Prop
	(properties)
)

(instance leftScene of Prop
	(properties)
)

(instance extraScene of Prop
	(properties)
)

(instance lines of Prop
	(properties)
)

(instance scanner of Prop
	(properties)
)

(instance sonny of PV
	(properties
		y 105
		x 63
		view 71
		priority 13
	)
)

(instance keithBud of PV
	(properties
		y 107
		x 247
		view 71
		cel 1
		priority 13
	)
)

(instance sShoulder of PV
	(properties
		y 141
		x 99
		view 71
		cel 4
		priority 13
	)
)

(instance kShoulder of PV
	(properties
		y 137
		x 208
		view 71
		cel 5
		priority 13
	)
)

(instance wheel of PV
	(properties
		y 130
		x 113
		view 71
		cel 2
		priority 12
	)
)

(instance street of PV
	(properties
		y 101
		x 154
		view 71
		loop 5
		priority 1
	)
)

(instance rm13 of Rm
	(properties
		picture 13
		style 0
	)

	(method (init)
		(HandsOff)
		(User canInput: 1)
		(Load rsVIEW 71)
		(Load rsVIEW 200)
		(Load rsVIEW 180)
		(Load rsSOUND 5)
		(= global131 13)
		(= local102 0)
		(= global204 0)
		(= local103 gPrevRoomNum)
		(= local109
			(switch gPrevRoomNum
				(14 0)
				(25 40)
				(225 40)
				(29 80)
				(67 100)
				(61 122)
				(22 90)
				(31 30)
				(27 62)
				(1 110)
			)
		)
		(= local108
			(= local110
				(switch gPrevRoomNum
					(14 62)
					(25 100)
					(29 100)
					(67 100)
					(61 12)
					(22 10)
					(31 60)
					(27 50)
					(1 40)
				)
			)
		)
		(= local107 local109)
		(= local104
			(switch local109
				(0 329)
				(40 332)
				(80 331)
				(100 328)
				(122 326)
				(90 334)
				(30 333)
				(62 330)
				(110 327)
			)
		)
		(Load rsVIEW local104)
		(= local116 300)
		(gEgo
			setPri: 0
			setLoop: -1
			setCel: -1
			posn: 0 0
			setMotion: 0
			ignoreActors: 0
			illegalBits: $8000
			init:
		)
		(hand view: 71 posn: 129 149 loop: 0 cel: 3 setPri: 13 init: stopUpd:)
		(lines
			view: 71
			posn: 149 101
			setPri: 2
			setLoop: 4
			setCycle: Fwd
			init:
			stopUpd:
		)
		(leftScene
			view: 200
			posn: 114 93
			setPri: 0
			setLoop: 0
			cel: 1
			setCycle: Fwd
			init:
			stopUpd:
		)
		(rightScene
			view: 200
			posn: 201 93
			setPri: 0
			setLoop: 1
			setCycle: Fwd
			init:
			stopUpd:
		)
		(extraScene
			view: local104
			setLoop: 0
			setCel: 0
			posn: 160 100
			setPri: 3
			setLoop: 0
			init:
			stopUpd:
		)
		(SL enable:)
		(super init:)
		(self setScript: rm13Script)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		else
			(switch (event type:)
				(evMOUSEBUTTON
					(if local112
						(event claimed: 1)
						(localproc_1)
						(if (not local113)
							(sequencer cue:)
						)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance rm13Script of Script
	(properties)

	(method (doit)
		(cond
			((and local112 (== local118 1))
				(localproc_1)
				(if (not local113)
					(sequencer cue:)
				)
			)
			((and local112 (> local118 0))
				(-- local118)
			)
		)
		(if (and (or (== global159 1) (== global158 1)) (not local115))
			(= local115 1)
			(sequencer changeState: 105)
		)
		(if (> local121 1)
			(-- local121)
		)
		(if (== local121 1)
			(= local121 0)
			(self changeState: 1)
		)
		(if local102
			(if (> global110 20)
				(cond
					((<= (hand y:) 148)
						(hand posn: 129 (+ (hand y:) 1))
					)
					((>= (hand y:) 154)
						(hand posn: 129 (- (hand y:) 1))
					)
					(else
						(hand posn: 129 (+ (hand y:) (Random -2 2)))
					)
				)
			)
			(if (not local112)
				(if (> local117 1)
					(-- local117)
				)
				(cond
					((> local109 local107)
						(-- local109)
					)
					((< local109 local107)
						(++ local109)
					)
					((> local110 local108)
						(-- local110)
					)
					(else
						(if local101
							(EgoDead
								{As a police officer, you should not abandon any stolen property which you have recovered. Next time, think about what you're doing.}
							)
						)
						(if (< local110 local108)
							(++ local110)
						else
							(User canInput: 0)
							(if local102
								(if (not local119)
									(sequencer changeState: 91)
									(= local119 1)
								)
								(if local113
									(if (and (== local103 25) (IsFlag 165))
										(= local103 225)
									)
									(if
										(and
											(== local103 61)
											(not (IsFlag 19))
											(== global100 5)
										)
										(sequencer changeState: 8)
									)
									(NormalEgo)
									(gContinuousMusic loop: 1 fade:)
									(NormalEgo)
									(gCurRoom newRoom: local103)
								)
							)
						)
					)
				)
			)
		else
			(lines stopUpd:)
			(rightScene stopUpd:)
			(leftScene stopUpd:)
			(if (> local116 0)
				(-- local116)
			)
			(if (and (== local116 1) (not local112))
				(= local116 200)
				(cond
					((IsFlag 1)
						(localproc_2 1 13 3)
					)
					((Random 0 1)
						(localproc_2 1 13 4)
					)
					(else
						(localproc_2 1 13 5)
					)
				)
			)
		)
		(if (== local117 1)
			(= local117 0)
			(cond
				((and (not (IsFlag 15)) (== global100 1))
					(if (== local103 22)
						(sequencer changeState: 1)
					else
						(= local117 15)
					)
				)
				((and (not (IsFlag 16)) (== global100 2))
					(sequencer changeState: 74)
					(= local117 20)
				)
				((and (IsFlag 16) (not (IsFlag 17)))
					(sequencer changeState: 5)
				)
				((and (not local100) (== global100 4))
					(sequencer changeState: 79)
					(= local117 25)
				)
				((and (not (IsFlag 21)) (== global100 6))
					(sequencer changeState: 36)
				)
				((and (not (IsFlag 22)) (== global100 6) (== gPrevRoomNum 14))
					(sequencer changeState: 53)
					(= local117 25)
				)
				((and (IsFlag 22) (gEgo has: 11) (not (IsFlag 23))) ; potted_plant
					(sequencer changeState: 54)
				)
				((and (not (IsFlag 24)) (== global100 10))
					(sequencer changeState: 57)
				)
				((and (not (IsFlag 27)) global127 (== gPrevRoomNum 31))
					(sequencer changeState: 63)
				)
				((and (not (IsFlag 28)) (IsFlag 52))
					(sequencer changeState: 68)
				)
			)
			(if (not local117)
				(if (not (> 20 (- local110 local108) -20))
					(= local110 (+ local108 16))
				)
				(if (not (> 20 (- local109 local107) -20))
					(= local109 (+ local107 16))
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gAddToPics
					add: sonny keithBud sShoulder kShoulder wheel street
					doit:
				)
				(scanner
					view: 71
					posn: 159 141
					cycleSpeed: 1
					setCycle: Fwd
					setLoop: 6
					setPri: 13
					init:
					setScript: sequencer
				)
				(if (< global110 30)
					(scanner stopUpd: setScript: 0)
				)
				(cig
					view: 71
					posn: 215 81
					setLoop: 2
					cycleSpeed: 1
					setCycle: Fwd
					setPri: 12
					init:
				)
				(puff
					view: 71
					posn: 205 97
					cycleSpeed: 2
					setCycle: Fwd
					setLoop: 3
					setPri: 13
					init:
				)
				(if (< global110 30)
					(cig stopUpd:)
					(puff posn: 1000 1000 stopUpd:)
				)
				(self cue:)
			)
			(1
				(if (< global110 30)
					(self cue:)
				else
					(puff setCycle: End self)
				)
			)
			(2
				(= local121 (Random 20 70))
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (= temp0 (event message:)) KEY_F6)
						(== temp0 KEY_F8)
						(== temp0 KEY_F10)
					)
					(Print 13 6) ; "You don't need your gun in the car. Keith's friendly."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
				(if (== temp0 KEY_RETURN)
					(if local112
						(event claimed: 1)
						(localproc_1)
						(if (not local113)
							(sequencer cue:)
						)
					else
						(event claimed: 0)
					)
				)
				(event claimed: (not local113))
			)
			(evSAID
				(cond
					((Said '/too<me')
						(Print 13 7) ; "Keith nods."
					)
					(
						(or
							(Said 'talk[/friend,man]')
							(Said 'stop/friend,man,cigarette')
							(Said '/cigarette')
						)
						(sequencer changeState: 113)
					)
					((Said 'check,look/gauge<gas,gas')
						(Print 13 8) ; "The needle is stuck on 'F'."
					)
					((Said 'look,read/note,list')
						(Print 13 9) ; "The grocery list is Keith's. It has only one item: "cigarettes"."
					)
					(
						(or
							(Said 'start[/auto,ignition,engine]')
							(Said 'turn/key')
							(Said 'turn<on/engine,auto')
						)
						(Print 13 10) ; "The old V8 engine is running a little rough."
					)
					(
						(or
							(Said 'stop[/auto,engine]')
							(Said 'turn<off/engine,auto')
							(Said 'switch<off/engine,auto')
						)
						(if (== local107 local109)
							(Print 13 11) ; "The car's engine is off."
						else
							(Print 13 12) ; "It would probably be a good idea to wait until you've arrived."
						)
					)
					((Said '/box,compartment')
						(Print 13 13) ; "Keith keeps a carton of cigarettes in the glovebox. He doesn't like anyone messing with his 'stash'."
					)
					((Said '/siren,(3<code)')
						(Print 13 14) ; "You don't need the siren right now."
					)
					((Said '/lamp,light[<read]')
						(Print 13 15) ; "The light is for night work."
					)
					((Said 'look>')
						(cond
							((Said '/speedometer,speed')
								(if local102
									(Print 13 16) ; "Your speedometer indicates you're within the local 35 mph speed limit."
								else
									(Print 13 17) ; "You're getting nowhere fast."
								)
							)
							((or (Said '/bench<back') (Said '/back'))
								(Print 13 18) ; "You see an adventure gamer looking over your shoulder."
							)
							((Said '/light[<read]')
								(Print 13 19) ; "The light is for night work, and has a shade to avoid detection during stake-outs."
							)
							((Said '/tray,ashtray')
								(Print 13 20) ; "The ash tray is full of Keith's smelly old butts. You really should clean it out, but not right now."
							)
							((Said 'look/pane')
								(Print 13 21) ; "Outside the car's window, you see..."
								(if local102
									(Print 13 22) ; "... the streets of Lytton as they fly by."
								else
									(switch local109
										(0
											(Print 13 23) ; "... the newly built Lytton Airport parking lot and terminal building."
										)
										(40
											(Print 13 24) ; "Snuggler's Inn. Sleazy and cheap, it's a motel for the down-and-out."
										)
										(80
											(Print 13 25) ; "Arnie's restaurant. Their food is good, and the service is adequate."
										)
										(100
											(Print 13 26) ; "Oak Tree Mall. This is Lytton's major shopping area."
										)
										(122
											(Print 13 27) ; "Cotton Cove. It's a poorly-kept-up park. It holds many fond memories from your youth."
										)
										(90
											(Print 13 28) ; "... the underground parking structure of the new Lytton Justice Building. The city jail's entrance is nearby."
										)
										(30
											(Print 13 29) ; "... a typical American neighborhood. You're parked in front of Marie Wilkan's house."
										)
										(62
											(Print 13 30) ; "... the warehouse district. A lot goes down around here, free from prying eyes."
										)
										(110
											(Print 13 31) ; "... the Lytton Police Station and parking lot. The detective's entrance is nearby."
										)
										(else
											(Print 13 32) ; "nothing mutch."
										)
									)
								)
							)
							((Said '/mirror')
								(Print 13 33) ; "That's good driving practice. Tail-gaters can be dangerous."
							)
							((Said '/console')
								(Print 13 34) ; "The dashboard is cluttered with various necessary items: police radio, note pad, reading light, and Keith's pack of cigarettes."
							)
							((Said '/extender,scanner')
								(Print 13 35) ; "The police radio scans the emergency frequencies, constantly in search of new developments."
							)
							((Said '/note,clipboard')
								(Print 13 36) ; "The note on the dashboard is from three days ago. It's an old grocery list."
							)
							((Said '/cigarette,pack')
								(Print 13 37) ; "You read: "SURGEON GENERAL'S WARNING: Smoking Causes Lung Cancer, Heart Disease, Emphysema, And May Complicate Pregnancy.""
							)
							(
								(Said
									'/building,ave,air,cloud,sun,barn,home,airplane,airport,lot,fence,cove,inn,bush,tree,garage,sign,mall,store,cafe,warehouse'
								)
								(Print 13 38) ; "You can't see much from inside the car."
							)
							(
								(Said
									'[<at,around][/!*,auto,up,door,bonds,down,ceiling,floor,bench]'
								)
								(Print 13 39) ; "You're behind the wheel of an unmarked police cruiser. Your partner, Keith, is puffing away on a cigarette."
							)
						)
					)
					(
						(or
							(Said 'wear,fasten,use,(drop<on),buckle/belt,belt')
							(Said 'buckle')
						)
						(Print 13 40) ; "Good idea. Safety first."
					)
					((Said 'turn/extender,scanner')
						(Print 13 41) ; "Keith keeps the police scanner on at all times."
					)
					((Said 'listen/extender,scanner')
						(Print 13 42) ; "You listen intently to the radio traffic. It takes practice to pick out the important calls."
					)
					(
						(or
							(Said 'talk,use,call/extender')
							(Said 'extender,call,finding,notify>')
						)
						(cond
							((and (not (IsFlag 27)) global127)
								(sequencer changeState: 63)
							)
							(global186
								(= global186 0)
								(sequencer changeState: 12)
							)
							(
								(and
									global184
									(== global100 5)
									(not (IsFlag 54))
								)
								(SetScore 2 54)
								(sequencer changeState: 99)
							)
							((and global183 (not (IsFlag 111)))
								(SetFlag 111)
								(localproc_2 1 13 43)
							)
							(
								(and
									(or
										(Said '/warrant')
										(Said '/dispatch/warrant')
										(Said '/dispatch[/!*]')
										(Said '[/!*]')
									)
									(IsFlag 1)
									(== local109 40)
								)
								(ClearFlag 1)
								(SetScore 2)
								(= global170 200)
								(sequencer changeState: 101)
							)
							(
								(and
									(or
										(Said '/dispatch/[!*]')
										(Said '/backup,swat,team')
										(Said '/dispatch/backup,swat,team')
									)
									(IsFlag 2)
									(== local109 40)
								)
								(ClearFlag 2)
								(SetScore 2)
								(= global171 200)
								(sequencer changeState: 103)
							)
							((IsFlag 50)
								(sequencer changeState: 93)
							)
							((IsFlag 51)
								(sequencer changeState: 96)
							)
							((== global169 2)
								(= global169 3)
								(SetScore 2 159)
								(sequencer changeState: 46)
							)
							((and (IsFlag 49) (== global100 6))
								(ClearFlag 49)
								(SetScore 1)
								(sequencer changeState: 50)
							)
							(
								(and
									(IsFlag 84)
									(== global100 6)
									(not (IsFlag 158))
								)
								(SetScore 2 158)
								(localproc_2 1 13 44)
							)
							(
								(and
									(not local105)
									(or
										(and (== global100 2) (== gPrevRoomNum 22))
										(and (== global100 3) (== gPrevRoomNum 67))
										(and (== global100 5) (== gPrevRoomNum 61))
										(and (== global100 12) (== gPrevRoomNum 25))
										(and (== global100 10) (== gPrevRoomNum 27))
									)
								)
								(localproc_2 1 13 45)
								(= local105 1)
							)
							(else
								(localproc_2 1 13 46)
							)
						)
						(event claimed: 1)
					)
					((Said 'drive/auto')
						(Print 13 47) ; "To drive somewhere, type: "drive to (destination)""
					)
					((Said 'drive,go>')
						(if (not (gEgo has: 3)) ; unmarked_car_keys
							(Print 13 48) ; "You need the correct key to operate this car."
							(event claimed: 1)
						else
							(if (and (== global100 3) (IsFlag 152))
								(= global100 4)
							)
							(if (and (== global100 12) (not (IsFlag 165)))
								(if (Said '/inn[<snuggler,to]')
									(event claimed: 0)
								else
									(SetFlag 165)
								)
							)
							(User canInput: 0)
							(cond
								(
									(or
										(Said '/cheeks')
										(Said '/home<cheeks')
										(Said '/ave<peach<lonny<222')
										(Said '/peach<lonny<222')
									)
									(if (!= local103 31)
										(= local103 31)
										(sequencer changeState: 85)
										(= local107 30)
										(= local108 60)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/home<barn')
										(Said
											'/office,homicide,police,barn,lpd'
										)
										(Said
											'/barn,department<police[<lytton,to]'
										)
									)
									(if (!= local103 1)
										(= local103 1)
										(sequencer changeState: 85)
										(= local107 110)
										(= local108 40)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/jail,courthouse')
										(Said '/center<enforcement<law')
									)
									(if (!= local103 22)
										(= local103 22)
										(sequencer changeState: 85)
										(= local107 90)
										(= local108 10)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/cove[<cotton,to]')
									(if (!= local103 61)
										(= local103 61)
										(sequencer changeState: 85)
										(= local107 122)
										(= local108 12)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/airport[<lytton,to]')
									(if (!= local103 14)
										(= local103 14)
										(sequencer changeState: 85)
										(= local107 0)
										(= local108 62)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/inn[<snuggler,to]')
										(Said '/ave<third<753')
									)
									(if (!= local103 25)
										(= local103 25)
										(sequencer changeState: 85)
										(= local107 40)
										(= local108 100)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/cafe[<arnie,to]')
										(Said '/arnie,date,chow')
									)
									(if (!= local103 29)
										(= local103 29)
										(sequencer changeState: 85)
										(= local107 80)
										(= local108 100)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/area<death>')
										(Said '/death[<area,to]>')
										(Said '/warehouse>')
										(Said '/district<warehouse>')
										(Said '/ave<rose<lonny<160')
										(Said '/rose<lonny<160')
									)
									(cond
										(
											(and
												(or
													(Said '/area<death')
													(Said '/death')
												)
												(!= global100 10)
											)
											(localproc_2 1 13 51)
											(User canInput: 1)
										)
										((!= local103 27)
											(event claimed: 1)
											(= local103 27)
											(sequencer changeState: 85)
											(= local107 62)
											(= local108 50)
										)
										(else
											(if local102
												(Print 13 49) ; "You're already going there."
											else
												(Print 13 50) ; "You're already there."
											)
											(event claimed: 1)
											(User canInput: 1)
										)
									)
								)
								(
									(or
										(Said '/mall[<(tree<fig),to]')
										(Said '/tree<fig')
										(Said '/center,mall<shopping')
									)
									(if (!= local103 67)
										(= local103 67)
										(sequencer changeState: 85)
										(= local107 100)
										(= local108 100)
									else
										(if local102
											(Print 13 49) ; "You're already going there."
										else
											(Print 13 50) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/ave<fig<5556')
									(Print 13 52) ; "You have hotter leads to follow."
									(User canInput: 1)
								)
								(
									(or
										(Said '/castle<caffeine[<carol,to]')
										(Said '/willie<drunk')
										(Said '/chamber<blue')
										(Said '/delphoria[<hotel,to]')
									)
									(User canInput: 1)
									(Print 13 53) ; "Lytton has seen many businesses fail in the last year... and that was one of them."
								)
								((Said '/steelton,houston,coarsegold')
									(User canInput: 1)
									(Print 13 54) ; "That's a great place, but it's too far to drive there right now."
								)
								((Said '/[*]')
									(User canInput: 1)
									(Print 13 55) ; "You don't need to drive there."
								)
								(else
									(User canInput: 1)
									(event claimed: 1)
									(Print 13 56) ; "Where to?"
								)
							)
						)
						(= local101 (and (== gPrevRoomNum 14) (>= global169 2)))
					)
					((Said 'chase[/bains]')
						(if global186
							(= local103 14)
							(sequencer changeState: 11)
							(= local107 0)
							(= local108 62)
						else
							(localproc_2 1 13 57)
						)
					)
					(
						(or
							(Said 'stop<chase/bains')
							(Said 'call<off/chase,pursuit')
							(Said 'stop/chase,pursuit')
						)
						(if local114
							(= local103 61)
							(sequencer changeState: 34)
							(= local107 122)
							(= local108 12)
						)
					)
					(
						(or
							(Said 'exit[/auto]')
							(Said 'open/door')
							(Said 'get<out')
						)
						(proc13_1)
					)
					((or (Said 'give/cheeks') (Said '//cheeks'))
						(if (== (sequencer state:) 55)
							(sequencer changeState: 56)
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance sequencer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local113 1)
			)
			(1
				(= local113 0)
				(SetFlag 15)
				(localproc_2 1 13 58)
			)
			(2
				(localproc_2 1 13 59)
			)
			(3
				(localproc_2 1 13 60)
			)
			(4
				(localproc_2 1 13 61)
				(= local113 1)
			)
			(5
				(= local113 0)
				(SetFlag 17)
				(= global100 3)
				(= global158 300)
				(= global138 2)
				(localproc_2 1 13 62)
			)
			(6
				(localproc_2 1 13 63)
			)
			(7
				(localproc_2 1 13 64)
				(= local113 1)
			)
			(8
				(= local113 0)
				(SetFlag 19)
				(localproc_2 1 13 65)
				(if (Print 13 66 #at -1 128 #button {You're ON!} 1 #button {No way.} 0)
					(= local112 0)
					(SetFlag 114)
					(sequencer changeState: 9)
				else
					(= local112 0)
					(sequencer changeState: 10)
				)
			)
			(9
				(localproc_2 1 13 67)
				(= local113 1)
			)
			(10
				(localproc_2 1 13 68)
				(= local113 1)
			)
			(11
				(User canInput: 0)
				(SetFlag 20)
				(= local114 1)
				(localproc_0)
				(gContinuousMusic number: 5 loop: -1 play:)
				(self cue:)
			)
			(12
				(= local113 0)
				(SetFlag 20)
				(SetScore 2 164)
				(localproc_2 1 13 69)
			)
			(13
				(localproc_2 0 13 70)
			)
			(14
				(localproc_2 0 13 71)
			)
			(15
				(localproc_2 1 13 72)
			)
			(16
				(localproc_2 1 13 73)
			)
			(17
				(localproc_2 0 13 74)
			)
			(18
				(localproc_2 0 13 75)
			)
			(19
				(localproc_2 1 13 76)
			)
			(20
				(localproc_2 1 13 77)
			)
			(21
				(localproc_2 0 13 78)
			)
			(22
				(localproc_2 0 13 79)
			)
			(23
				(localproc_2 0 13 80)
			)
			(24
				(localproc_2 0 13 81)
			)
			(25
				(localproc_2 0 13 82)
			)
			(26
				(if local114
					(localproc_2 1 13 83)
				else
					(localproc_2 1 13 84)
					(= local113 1)
				)
			)
			(27
				(localproc_2 2 13 85)
			)
			(28
				(localproc_2 1 13 86)
			)
			(29
				(localproc_2 2 13 87)
			)
			(30
				(localproc_2 1 13 88)
			)
			(31
				(= global100 5)
				(= global158 300)
				(= global138 2)
				(localproc_2 2 13 89)
			)
			(32
				(localproc_2 1 13 90)
			)
			(33
				(localproc_2 1 13 91)
				(User canInput: 1)
				(= local113 1)
			)
			(34
				(= local113 0)
				(= local114 0)
				(localproc_2 1 13 92)
			)
			(35
				(Format ; "Dispatch," Keith says, more calmly now, "53mary2... we are 10-22 on pursuit of Bains' vehicle. 10-97 to %s."
					@local0
					13
					93
					(switch local103
						(14 {Lytton Airport})
						(25 {753 Third Street})
						(29 {Arnie's restaurant})
						(67 {Oak Tree Mall})
						(61 {Cotton Cove})
						(22 {Lytton City Jail})
						(31 {222 West Peach Street})
						(27 {160 West Rose})
						(1 {the office})
					)
				)
				(localproc_2 1 @local0)
				(= local113 1)
			)
			(36
				(= local113 0)
				(SetFlag 21)
				(Format ; "As you drive toward %s, Dispatch brings the radio alive with information from a unit in pursuit."
					@local0
					13
					94
					(switch local103
						(14 {Lytton Airport})
						(25 {753 Third Street})
						(29 {Arnie's restaurant})
						(67 {Oak Tree Mall})
						(61 {Cotton Cove})
						(22 {Lytton City Jail})
						(31 {222 West Peach Street})
						(27 {160 West Rose})
						(1 {the office})
					)
				)
				(localproc_2 0 @local0)
			)
			(37
				(localproc_2 0 13 95)
			)
			(38
				(localproc_2 0 13 96)
			)
			(39
				(localproc_2 0 13 97)
			)
			(40
				(localproc_2 1 13 98)
			)
			(41
				(localproc_2 0 13 99)
			)
			(42
				(localproc_2 3 13 100)
			)
			(43
				(localproc_2 0 13 101)
			)
			(44
				(localproc_2 3 13 102)
			)
			(45
				(localproc_2 1 13 103)
				(= local113 1)
			)
			(46
				(= local113 0)
				(localproc_2 1 13 104)
			)
			(47
				(localproc_2 0 13 105)
			)
			(48
				(localproc_2 0 13 106)
			)
			(49
				(localproc_2 0 13 107)
				(if (not (IsFlag 49))
					(= local113 1)
				)
			)
			(50
				(= local113 0)
				(localproc_2 1 13 108)
			)
			(51
				(localproc_2 0 13 109)
			)
			(52
				(localproc_2 1 13 110)
				(= local113 1)
			)
			(53
				(SetFlag 22)
				(localproc_2 1 13 111)
			)
			(54
				(SetFlag 23)
				(= local113 0)
				(localproc_2 1 13 112)
			)
			(55
				(localproc_2 1 13 113)
				(= local113 1)
			)
			(56
				(localproc_2 1 13 114)
			)
			(57
				(SetFlag 24)
				(localproc_2 1 13 115)
			)
			(58
				(= local106 0)
				(= local113 0)
				(SetFlag 25)
				(localproc_2 1 13 116)
			)
			(59
				(if (not local106)
					(gContinuousMusic number: 5 loop: -1 play:)
				)
				(localproc_2 0 13 117)
				(localproc_0)
			)
			(60
				(localproc_2 1 13 118)
			)
			(61
				(localproc_2 1 13 119)
			)
			(62
				(localproc_2 1 13 120)
				(= local113 1)
				(User canInput: 1)
			)
			(63
				(User canInput: 0)
				(= local113 0)
				(SetFlag 27)
				(localproc_2 1 13 121)
			)
			(64
				(if (== local103 1)
					(localproc_2 1 13 122)
				else
					(self cue:)
				)
			)
			(65
				(localproc_2 1 13 123)
			)
			(66
				(localproc_2 0 13 124)
			)
			(67
				(localproc_2 1 13 125)
				(= local113 1)
				(User canInput: 1)
			)
			(68
				(= local113 0)
				(SetFlag 28)
				(localproc_2 1 13 126)
			)
			(69
				(localproc_2 1 13 127)
			)
			(70
				(localproc_2 1 13 128)
			)
			(71
				(localproc_2 1 13 129)
			)
			(72
				(localproc_2 1 13 130)
			)
			(73
				(self changeState: 67)
			)
			(74
				(= local113 0)
				(SetFlag 16)
				(localproc_2 0 13 131)
			)
			(75
				(localproc_2 1 13 132)
			)
			(76
				(localproc_2 0 13 133)
			)
			(77
				(localproc_2 0 13 134)
			)
			(78
				(localproc_2 1 13 135)
				(= local113 1)
			)
			(79
				(= local113 0)
				(localproc_2 0 13 136)
				(= local100 1)
			)
			(80
				(localproc_2 1 13 137)
			)
			(81
				(localproc_2 0 13 138)
			)
			(82
				(= global100 5)
				(= global158 300)
				(= global138 2)
				(localproc_2 0 13 139)
			)
			(83
				(localproc_2 1 13 140)
				(= local113 1)
			)
			(85
				(if (== global169 3)
					(= global169 0)
				)
				(ClearFlag 51)
				(ClearFlag 50)
				(SetFlag 111)
				(if (and (== gPrevRoomNum 61) (== global100 5) (!= local103 61))
					(= global100 6)
					(= global169 1)
					(= global158 0)
				)
				(if (and (== gPrevRoomNum 27) (== global100 10) (!= global158 1))
					(= global100 11)
				)
				(cond
					(
						(and
							(not (IsFlag 25))
							(== global100 11)
							(gEgo has: 24) ; envelope_corner
							(== local103 25)
						)
						(sequencer changeState: 58)
					)
					(local114
						(self changeState: 34)
					)
					((and (== local109 local107) (== local110 local108))
						(self cue:)
					)
					(else
						(self changeState: 89)
					)
				)
			)
			(86
				(= local113 0)
				(switch local103
					(14
						(localproc_2 1 13 141)
					)
					(25
						(localproc_2 1 13 142)
					)
					(29
						(localproc_2 1 13 143)
					)
					(67
						(localproc_2 1 13 144)
					)
					(61
						(localproc_2 1 13 145)
					)
					(22
						(localproc_2 1 13 146)
					)
					(31
						(if (>= global100 8)
							(localproc_2 1 13 147)
						else
							(localproc_2 1 13 148)
						)
					)
					(1
						(localproc_2 1 13 149)
					)
					(27
						(localproc_2 1 13 150)
					)
				)
			)
			(87
				(Format
					@local0
					{Keith grabs the mike and calls dispatch... "Dispatch...53mary2 is 10-8 from %s."}
					(switch local109
						(0 {Lytton Airport})
						(40 {753 Third Street})
						(80 {Arnie's restaurant})
						(100 {Oak Tree Mall})
						(122 {Cotton Cove})
						(90 {Lytton City Jail})
						(30 {222 West Peach Street})
						(62 {160 West Rose})
						(110 {the office})
					)
				)
				(localproc_2 1 @local0)
			)
			(88
				(Format ; "Dispatch comes on the air and responds... "53mary2...10-4. Dispatch copies 10-8 from %s.""
					@local0
					13
					151
					(switch local109
						(0 {Lytton Airport})
						(40 {753 Third Street})
						(80 {Arnie's restaurant})
						(100 {Oak Tree Mall})
						(122 {Cotton Cove})
						(90 {Lytton City Jail})
						(30 {222 West Peach Street})
						(62 {160 West Rose})
						(110 {the office})
					)
				)
				(localproc_2 0 @local0)
				(gContinuousMusic number: 5 loop: -1 play:)
				(= local106 1)
				(localproc_0)
			)
			(89
				(if (not local106)
					(gContinuousMusic number: 5 loop: -1 play:)
				)
				(= local106 0)
				(= local113 0)
				(Format ; "Keith keys the mike..."Dispatch...53mary2. Be advised we are enroute to %s.""
					@local0
					13
					152
					(switch local103
						(14 {Lytton Airport})
						(25 {753 Third Street})
						(29 {Arnie's restaurant})
						(67 {Oak Tree Mall})
						(61 {Cotton Cove})
						(22 {Lytton City Jail})
						(31 {222 West Peach Street})
						(27 {160 West Rose})
						(1 {the office})
					)
				)
				(localproc_2 1 @local0)
			)
			(90
				(Format ; "Dispatch answers..."53mary2...10-4. We copy you are enroute to %s.""
					@local0
					13
					153
					(switch local107
						(0 {Lytton Airport})
						(40 {753 Third Street})
						(80 {Arnie's restaurant})
						(100 {Oak Tree Mall})
						(122 {Cotton Cove})
						(90 {Lytton City Jail})
						(30 {222 West Peach Street})
						(62 {160 West Rose})
						(110 {the office})
					)
				)
				(localproc_2 0 @local0)
				(User canInput: 1)
				(= local113 1)
			)
			(91
				(= local113 0)
				(Format
					@local0
					(if
						(or
							(and
								(== local103 67)
								(or (< global100 2) (>= global100 4))
							)
							(and
								(== local103 61)
								(or (< global100 4) (== global100 6))
							)
							(and (== local103 31) (< global100 8))
							(== local103 1)
						)
						{"Dispatch...53Mary2 10-7 at %s."}
					else
						{Keith contacts dispatch..."Dispatch...53mary2 10-97 %s."}
					)
					(switch local103
						(14 {Lytton Airport})
						(25 {753 Third Street})
						(29 {Arnie's restaurant})
						(67 {Oak Tree Mall})
						(61 {Cotton Cove})
						(22 {Lytton City Jail})
						(31 {222 West Peach Street})
						(27 {160 West Rose})
						(1 {the office})
					)
				)
				(localproc_2 1 @local0)
			)
			(92
				(Format ; "Dispatch responds..."53mary2...10-4. Dispatch copies 10-97 %s.""
					@local0
					13
					154
					(switch local103
						(14 {Lytton Airport})
						(25 {753 Third Street})
						(29 {Arnie's restaurant})
						(67 {Oak Tree Mall})
						(61 {Cotton Cove})
						(22 {Lytton City Jail})
						(31 {222 West Peach Street})
						(27 {160 West Rose})
						(1 {the office})
					)
				)
				(localproc_2 0 @local0)
				(= local113 1)
			)
			(93
				(= local113 0)
				(ClearFlag 50)
				(SetScore 1)
				(localproc_2 1 13 155)
			)
			(94
				(localproc_2 0 13 156)
			)
			(95
				(localproc_2 0 13 157)
				(if (not (IsFlag 51))
					(= local113 1)
				)
			)
			(96
				(= local113 0)
				(SetScore 2)
				(ClearFlag 51)
				(localproc_2 1 13 158)
			)
			(97
				(localproc_2 0 13 159)
			)
			(98
				(localproc_2 0 13 160)
				(= local113 1)
			)
			(99
				(= local113 0)
				(localproc_2 1 13 161)
			)
			(100
				(localproc_2 0 13 162)
				(= local113 1)
			)
			(101
				(= local113 0)
				(localproc_2 1 13 163)
			)
			(102
				(localproc_2 0 13 164)
				(= local113 1)
			)
			(103
				(= local113 0)
				(localproc_2 1 13 165)
			)
			(104
				(localproc_2 0 13 166)
				(= local113 1)
			)
			(105
				(= seconds 3)
			)
			(106
				(User canInput: 0)
				(= local113 0)
				(localproc_2 0 13 167)
			)
			(107
				(localproc_2 1 13 132)
			)
			(108
				(localproc_2 2 13 168)
			)
			(109
				(if (== global100 10)
					(= global159 1)
					(= global158 0)
				)
				(if global159
					(gContinuousMusic loop: 1 fade:)
					(NormalEgo)
					(gCurRoom newRoom: 300)
				else
					(= global159 600)
					(if (!= global100 0 8)
						(localproc_2 2 13 169)
					else
						(localproc_2 2 13 170)
					)
				)
			)
			(110
				(localproc_2 1 13 171)
			)
			(111
				(if (!= global100 0 8)
					(localproc_2 1 13 172)
				else
					(localproc_2 1 13 173)
				)
			)
			(112
				(= local113 1)
				(if (and (!= global100 8) (!= global100 0))
					(= global159 300)
				)
				(NormalEgo)
				(gContinuousMusic loop: 1 fade:)
				(gCurRoom newRoom: 300)
			)
			(113
				(= local113 0)
				(switch (Random 0 1)
					(0
						(localproc_2 1 13 174)
					)
					(1
						(localproc_2 1 13 175)
					)
				)
			)
			(114
				(switch (Random 0 3)
					(0
						(localproc_2 1 13 176)
					)
					(1
						(localproc_2 1 13 177)
					)
					(2
						(localproc_2 1 13 178)
					)
					(3
						(localproc_2 1 13 179)
					)
				)
				(if (Print 13 66 #button {YES!!} 0 #button {no} 1 #at -1 128)
					(localproc_2 1 13 180)
					(= local113 1)
				else
					(= local118 1)
				)
			)
			(115
				(switch (Random 0 15)
					(0
						(localproc_2 1 13 181)
					)
					(1
						(localproc_2 1 13 182)
					)
					(2
						(localproc_2 1 13 183)
					)
					(3
						(localproc_2 1 13 184)
					)
					(4
						(localproc_2 1 13 185)
					)
					(5
						(localproc_2 1 13 186)
					)
					(6
						(localproc_2 1 13 187)
					)
					(7
						(localproc_2 1 13 188)
					)
					(8
						(localproc_2 1 13 189)
					)
					(9
						(localproc_2 1 13 190)
					)
					(10
						(localproc_2 1 13 191)
					)
					(11
						(localproc_2 1 13 192)
					)
					(12
						(localproc_2 1 13 193)
					)
					(13
						(Format @local0 13 194) ; "I don't know what you're complaining about! I filter the smoke with my lungs first, you know."
					)
					(14
						(Format @local0 13 195) ; "How many times have I saved your life, huh partner? And now... now, when I need a little consideration from you, you turn on me."
					)
					(15
						(Format @local0 13 196) ; "Well, if I didn't smoke, we'd BOTH be nervous wrecks! One of us has to keep his mental faculties sharp."
					)
				)
				(= local113 1)
			)
		)
	)
)

