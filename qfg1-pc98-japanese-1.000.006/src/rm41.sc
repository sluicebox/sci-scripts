;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use n007)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	local0 = 1
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

(instance rm41 of Rm
	(properties
		picture 41
		style 5
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 31)
		(super dispose:)
	)

	(method (init &tmp temp0 temp1)
		(Load rsVIEW 41)
		(gContMusic fade:)
		(super init: &rest)
		(SL enable:)
		(= local9 (== gPrevRoomNum 141))
		(if (and (IsFlag 170) (not local9) (not (IsFlag 215)))
			(self horizon: 130)
		)
		(gMouseHandler add: self)
		(self setFeatures: onTrees1 onWeed1 onCastle onStones)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(NormalEgo)
		(gEgo init:)
		(if (not gNight)
			(rGuard init: stopUpd:)
			(lGuard init: stopUpd:)
			(if (and (IsFlag 170) (not local9) (not (IsFlag 215)))
				(HandsOff)
				(gContMusic prevSignal: 0)
				(lGuard setScript: lGuardTrumpets)
				(rGuard setScript: rGuardTrumpets)
			)
		)
		(door1 init: stopUpd:)
		(door2 init: stopUpd:)
		(switch gPrevRoomNum
			(38
				(if (and (IsFlag 170) (not (IsFlag 215)))
					(gEgo posn: 43 168 setMotion: MoveTo 160 168)
				else
					(if (< temp1 110)
						(= temp1 110)
					)
					(gEgo posn: 1 temp1 setMotion: MoveTo 15 temp1)
				)
			)
			(39
				(if (and (IsFlag 170) (not (IsFlag 215)))
					(gEgo posn: 160 186 setMotion: MoveTo 160 168)
				else
					(gEgo posn: temp0 189)
					(cond
						((< temp0 10)
							(gEgo setMotion: MoveTo (+ temp0 25) 175)
						)
						((> temp0 310)
							(gEgo setMotion: MoveTo (- temp0 25) 175)
						)
						(else
							(gEgo setMotion: MoveTo temp0 175)
						)
					)
				)
			)
			(40
				(if (and (IsFlag 170) (not (IsFlag 215)))
					(gEgo posn: 283 168 setMotion: MoveTo 160 168)
				else
					(if (< temp1 110)
						(= temp1 110)
					)
					(gEgo posn: 319 temp1 setMotion: MoveTo 305 temp1)
				)
			)
			(141
				(gEgo setScript: leaveHall)
			)
			(else
				(gEgo posn: 160 189 setMotion: MoveTo 160 170)
			)
		)
		(self setLocales: 807)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(switch (gEgo edgeHit:)
			(EDGE_RIGHT
				(= global106 (+ (/ (= temp0 (- (gEgo y:) 105)) 3) 98))
				(gCurRoom newRoom: 40)
			)
			(EDGE_BOTTOM
				(= global105 (+ (/ (gEgo x:) 3) 102))
				(gCurRoom newRoom: 39)
			)
			(EDGE_LEFT
				(= global106 (+ (/ (= temp0 (- (gEgo y:) 105)) 2) 84))
				(gCurRoom newRoom: 38)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed gEgo event 3)
					(HighPrint 41 0) ; "So you says to yourself, "Self", you says..."
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '[/!*]')
								(HighPrint 41 1) ; "You face the main doors of the Baron's keep."
							)
							((Said '/castle')
								(HighPrint 41 2) ; "The castle grounds look like no one has taken care of them. The castle is still impressive close up, but it looks rather dirty"
							)
							((Said '/north')
								(HighPrint 41 3) ; "You see the castle and the guards"
							)
							((Said '/east')
								(HighPrint 41 4) ; "Along the wall to the southeast, you can see the stables."
							)
							((Said '/south')
								(HighPrint 41 5) ; "You see the main courtyard of the castle."
							)
							((Said '/west')
								(HighPrint 41 6) ; "Along the wall to the southwest, you can see the barracks."
							)
							((Said '/door')
								(if gNight
									(HighPrint 41 7) ; "The doors are securely locked for the night."
								else
									(HighPrint 41 8) ; "The doors are guarded by Frederick and Pierre."
								)
							)
						)
					)
					((Said 'japaneseclimbup,climb,climb[/castle,wall]')
						(HighPrint 41 9) ; "The castle walls are very high. You judge that you would not be able to climb them."
					)
					((Said 'knock,knock,force/door')
						(HighPrint 41 10) ; "There is no response."
					)
					((Said 'open,open,open,pick,lockpick/door,hasp,hasp,lock')
						(if gNight
							(HighPrint 41 11) ; "The doors are securely locked and barred from the inside."
						else
							(HighPrint 41 12) ; "The doors are guarded by Frederick and Pierre."
						)
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					((or (Said 'nap,nap') (Said 'go[<to]/nap,nap'))
						(HighPrint 41 13) ; "You barely get to sleep when the guard on night patrol kicks you out."
						(if (< 750 gClock 2550)
							(FixTime 21)
						)
						(gCurRoom newRoom: 37)
					)
				)
			)
		)
	)
)

(instance lGuard of Prop
	(properties
		y 119
		x 120
		view 41
		loop 1
	)

	(method (doit)
		(if (or (not (IsFlag 170)) (IsFlag 215))
			(if (and (not local8) (< (gEgo y:) 142) (< 99 (gEgo x:) 209))
				(= local8 1)
				(= local3 12)
				(lGuard setScript: lGuardTalks)
			)
			(if
				(or
					(< (gEgo x:) 78)
					(< 228 (gEgo x:))
					(> (gEgo y:) 155)
				)
				(= local8 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed lGuard event 3)
					(HighPrint 41 14) ; "Plays a mean horn. A member in good standing of the musicians guild."
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'japaneseclimbup,climb,climb[/castle,wall]')
						(HighPrint 41 15) ; "You don't think the guards would allow you to do so."
					)
					((Said 'attack,kill/guard,man,gatekeeper')
						(EgoDead ; "No sooner do you draw your weapon then the guards have their weapons out and quickly disarm you. It seems that they practice with the Baron's Weapons Master. They promptly drag you into the castle and down into the dungeon, which is not a very likely spot for the attainment of hero status."
							41
							16
							80
							{Getting into the castle the hard way.}
							82
							39
							3
							0
						)
					)
					((Said 'look,look/horn')
						(HighPrint 41 17) ; "The horns are tarnished and starting to corrode."
					)
					((Said 'look,look/guard')
						(HighPrint 41 18) ; "The guards look to be middle-aged, but in good physical condition. Their clothing is faded and patched. Even the horns look dull."
					)
					((Said 'talk,talk[<to]/guard,man,gatekeeper')
						(HighPrint 41 19) ; "Go ahead."
					)
					((Said 'talk,talk,ask//moustache')
						(= local4 11)
						(self setScript: rGuardTalks)
						(= local2 0)
						(= local6 0)
					)
					((Said 'open,open,open/door')
						(= local3 12)
						(self setScript: lGuardTalks)
					)
					(local2
						(cond
							(local6
								(event claimed: 1)
								(= local6 0)
								(= local3 11)
								(self setScript: lGuardTalks)
							)
							((Said 'talk,talk,ask>')
								(event claimed: 1)
								(HighPrint 41 20) ; "The guards are ignoring you."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said '/hey')
						(= local3 2)
						(self setScript: lGuardTalks)
					)
					((Said 'call/guard,man,gatekeeper')
						(if local5
							(= local3 3)
							(self setScript: lGuardTalks)
						else
							(= local4 2)
							(self setScript: rGuardTalks)
						)
					)
					((Said 'say')
						(= local3 4)
						(self setScript: lGuardTalks)
					)
					((Said 'talk,talk,ask>')
						(cond
							((Said '//consent')
								(= local4 3)
								(self setScript: rGuardTalks)
							)
							((Said '//baron,baron,hamlet')
								(= local4 4)
								(self setScript: rGuardTalks)
							)
							((Said '//castle')
								(= local3 5)
								(self setScript: lGuardTalks)
							)
							((Said '//barnard,barnard,barnard')
								(= local4 5)
								(self setScript: rGuardTalks)
							)
							((Said '//daughter,elsa')
								(= local3 6)
								(self setScript: lGuardTalks)
							)
							((Said '//stable')
								(= local4 6)
								(self setScript: rGuardTalks)
							)
							((or (Said '//guard') (Said '//name,handle'))
								(= local3 7)
								(self setScript: lGuardTalks)
							)
							((Said '//barrack')
								(= local3 8)
								(self setScript: lGuardTalks)
							)
							((Said '//place,place[<bald]')
								(= local3 9)
								(self setScript: lGuardTalks)
								(= local2 300)
								(= local6 1)
							)
							((Said '//place,place')
								(= local4 9)
								(self setScript: rGuardTalks)
							)
							((Said '//karl')
								(= local3 13)
								(self setScript: lGuardTalks)
							)
							(else
								(event claimed: 1)
								(if local5
									(= local3 10)
									(self setScript: lGuardTalks)
								else
									(= local4 8)
									(self setScript: rGuardTalks)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance rGuard of Prop
	(properties
		y 119
		x 197
		view 41
	)

	(method (doit)
		(if (or (not (IsFlag 170)) (IsFlag 215))
			(if (and (not local7) (< (gEgo y:) 126) (< 99 (gEgo x:) 209))
				(= local7 1)
				(= local4 13)
				(rGuard setScript: rGuardTalks)
			)
			(if
				(or
					(< (gEgo x:) 78)
					(< 228 (gEgo x:))
					(> (gEgo y:) 140)
				)
				(= local7 0)
			)
			(if local2
				(-- local2)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed rGuard event 3)
					(HighPrint 41 21) ; "He's very proud of his moustache, but don't mention his bald spot."
				)
			)
		)
	)
)

(instance rGuardHead of Prop
	(properties
		y 86
		x 204
		view 41
		loop 2
		cycleSpeed 2
	)
)

(instance lGuardHead of Prop
	(properties
		y 85
		x 112
		view 41
		loop 5
		cycleSpeed 2
	)
)

(instance door1 of Prop
	(properties
		y 117
		x 138
		view 41
		loop 3
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if
					(or
						(and local0 (MouseClaimed door1 event 3))
						(and local0 (MouseClaimed door2 event 3))
						(and
							(MouseClaimed door1 event 3)
							(not (MouseClaimed torch event 3))
						)
						(and
							(MouseClaimed door2 event 3)
							(not (MouseClaimed torch event 3))
						)
					)
					(HighPrint 41 22) ; "Doorway to castle great hall."
				)
			)
		)
	)
)

(instance door2 of Prop
	(properties
		y 117
		x 178
		view 41
		loop 4
	)
)

(instance torch of Prop
	(properties
		y 82
		x 158
		view 41
		loop 6
		cycleSpeed 3
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (and (not local0) (MouseClaimed torch event 3))
					(HighPrint 41 23) ; "The torch lights the way to the Baron's Hall."
				)
			)
		)
	)
)

(instance onTrees1 of RFeature
	(properties
		nsTop 42
		nsLeft 5
		nsBottom 120
		nsRight 83
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed onTrees1 event 3) (MouseClaimed onTrees2 event 3))
				(HighPrint 41 24) ; "You can't reach the windows from these trees."
			)
		)
	)
)

(instance onTrees2 of RFeature
	(properties
		nsTop 52
		nsLeft 233
		nsBottom 112
		nsRight 307
	)
)

(instance onWeed1 of RFeature
	(properties
		nsTop 136
		nsLeft 82
		nsBottom 143
		nsRight 93
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(not (MouseClaimed gEgo event 3))
					(or
						(MouseClaimed onWeed1 event 3)
						(MouseClaimed onWeed2 event 3)
						(MouseClaimed onWeed3 event 3)
						(MouseClaimed onWeed4 event 3)
						(MouseClaimed onWeed5 event 3)
					)
				)
				(HighPrint 41 25) ; "Weeds grow profusely, but nobody notices."
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance onWeed2 of RFeature
	(properties
		nsTop 174
		nsLeft 132
		nsBottom 180
		nsRight 141
	)
)

(instance onWeed3 of RFeature
	(properties
		nsTop 137
		nsLeft 220
		nsBottom 142
		nsRight 227
	)
)

(instance onWeed4 of RFeature
	(properties
		nsTop 176
		nsLeft 274
		nsBottom 187
		nsRight 287
	)
)

(instance onWeed5 of RFeature
	(properties
		nsTop 182
		nsLeft 53
		nsBottom 188
		nsRight 64
	)
)

(instance onCastle of RFeature
	(properties
		nsBottom 41
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCastle event 3)
				(HighPrint 41 26) ; "This is the castle of the Baron Stefan von Spielburg."
			)
		)
	)
)

(instance onStones of RFeature
	(properties
		nsTop 142
		nsLeft 65
		nsBottom 189
		nsRight 278
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(MouseClaimed onStones event 3)
					(not
						(or
							(MouseClaimed gEgo event 3)
							(MouseClaimed onWeed1 event 3)
							(MouseClaimed onWeed2 event 3)
							(MouseClaimed onWeed3 event 3)
							(MouseClaimed onWeed4 event 3)
							(MouseClaimed onWeed5 event 3)
						)
					)
				)
				(switch local1
					(0
						(HighPrint 41 27) ; "These flagstones are from a rock quarry in eastern Germany."
						(++ local1)
					)
					(1
						(HighPrint 41 28) ; "Well...maybe the flagstones are from western Germany."
						(++ local1)
					)
					(2
						(HighPrint 41 29) ; "Flagstones from Europe?"
						(++ local1)
					)
					(3
						(HighPrint 41 30) ; "Granite from our very own mountains?"
						(++ local1)
					)
					(else
						(HighPrint 41 31) ; "I don't know!"
						(= local1 0)
					)
				)
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance lGuardTrumpets of Script
	(properties)

	(method (doit)
		(if (== (gContMusic prevSignal:) 10)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(lGuard setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
		)
	)
)

(instance rGuardTrumpets of Script
	(properties)

	(method (doit)
		(if (== (gContMusic prevSignal:) 20)
			(self changeState: 7)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gContMusic number: 96 loop: -1 priority: 5 play:)
				(rGuard setLoop: 0 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(= seconds 1)
			)
			(3
				(TimePrint 6 41 32) ; "The Baron von Spielburg and Baronet await you in the great hall."
				(= cycles 30)
			)
			(4
				(torch init: setCycle: Fwd)
				(door1 setCycle: End self)
				(door2 setCycle: End)
			)
			(5
				(door1 stopUpd:)
				(door2 stopUpd:)
				(= seconds 2)
			)
			(6
				(gEgo illegalBits: 0 setMotion: MoveTo 158 100)
			)
			(7
				(gCurRoom newRoom: 141)
			)
		)
	)
)

(instance lGuardTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lGuardHead setPri: 8 init: setCycle: Fwd)
				(= cycles 25)
			)
			(1
				(= local5 0)
				(HandsOn)
				(switch local3
					(1
						(HighPrint 41 33) ; "No one enters the castle without the Baron's permission."
					)
					(2
						(HighPrint 41 34) ; "Hay is for horses."
					)
					(3
						(HighPrint 41 35) ; "I'm here! What do you want?"
					)
					(4
						(HighPrint 41 36) ; "Says you."
					)
					(5
						(HighPrint 41 37) ; "This is the castle of the Baron Stefan von Spielburg."
					)
					(6
						(HighPrint 41 38) ; "The Baron's daughter has been gone for years."
					)
					(7
						(HighPrint 41 39) ; "I'm Frederick."
						(= local4 7)
						(self setScript: rGuardTalks)
					)
					(8
						(HighPrint 41 40) ; "The barracks are off to my right, but you have no business going there."
					)
					(9
						(HighPrint 41 41) ; "I told you not to mention it. Now you've hurt his feelings, and he won't talk until he gets over it."
					)
					(10
						(HighPrint 41 42) ; "I can't help you on that."
						(= local4 10)
						(self setScript: rGuardTalks)
					)
					(11
						(HighPrint 41 43) ; "Looks like meathead is sulking. If I talk to you anymore he'll get even with me."
						(= local4 12)
						(self setScript: rGuardTalks)
					)
					(12
						(HighPrint 41 33) ; "No one enters the castle without the Baron's permission."
					)
					(13
						(HighPrint 41 44) ; "Karl is the gatekeeper. He is a good one to answer questions."
					)
				)
				(lGuardHead dispose:)
			)
		)
	)
)

(instance rGuardTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rGuardHead setPri: 8 init: setCycle: Fwd)
				(= cycles 25)
			)
			(1
				(= local5 1)
				(HandsOn)
				(switch local4
					(1
						(HighPrint 41 45) ; "The Baron sees no one."
					)
					(2
						(HighPrint 41 46) ; "We cannot leave our post."
					)
					(3
						(HighPrint 41 47) ; "You will have to see the Baron to get his permission."
					)
					(4
						(if (IsFlag 170)
							(HighPrint 41 48) ; "The Baron is busy and will see no one."
						else
							(HighPrint 41 45) ; "The Baron sees no one."
						)
					)
					(5
						(if (IsFlag 170)
							(HighPrint 41 49) ; "The Baronet is in the castle recovering from his ordeal and will see no one."
						else
							(HighPrint 41 50) ; "The Baronet Barnard von Spielburg is missing."
						)
					)
					(6
						(HighPrint 41 51) ; "The stable is off to my left."
					)
					(7
						(HighPrint 41 52) ; "My name is Pierre. I'm one of the Baron's personal guards."
						(= local5 0)
					)
					(8
						(HighPrint 41 53) ; "It is not our place to answer questions."
					)
					(9
						(HighPrint 41 54) ; "Spot? What spot?"
					)
					(10
						(HighPrint 41 55) ; "Why don't you ask Karl?"
						(= local5 0)
					)
					(11
						(HighPrint 41 56) ; "Why thank you. Your manners have improved."
					)
					(12
						(HighPrint 41 57) ; "Don't get me mad."
						(= local5 0)
					)
					(13
						(HighPrint 41 45) ; "The Baron sees no one."
					)
				)
				(rGuardHead dispose:)
			)
		)
	)
)

(instance leaveHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					posn: 159 120
					setMotion: MoveTo 159 150 self
				)
				(= gCurRoomNum 141)
				(FixTime 22)
				(EgoSleeps 7 30)
				(= gCurRoomNum 41)
			)
			(1
				(gEgo ignoreActors: 0 illegalBits: $8000)
				(TimePrint 10 41 58) ; "After a wonderful meal with the Baron and his son, a peaceful night's sleep in a featherdown bed, and a filling breakfast in bed, you are ready to go adventuring once more."
				(HandsOn)
				(SetFlag 215)
				(= local9 0)
				(client setScript: 0)
			)
		)
	)
)

