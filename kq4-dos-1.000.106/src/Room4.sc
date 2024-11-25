;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room4 0
)

(synonyms
	(giantess giantess giantess giantess giantess woman giantess)
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

(instance door of Prop
	(properties)

	(method (cue)
		(HandsOn)
		(gCurRoom newRoom: 49)
	)
)

(instance Room4 of Rm
	(properties
		picture 4
	)

	(method (init)
		(= north 28)
		(= south 10)
		(= east 5)
		(= west 3)
		(= horizon 75)
		(= global189 1)
		(if gNight
			(= picture 104)
		)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(self setRegions: 508 517) ; Forest_Region, Ogre_s_Region
		(Load rsVIEW 245)
		(Load rsVIEW 246)
		(Load rsVIEW 57)
		(if (and (== gPrevRoomNum 49) (gEgo has: 33)) ; Magic_Hen
			(door
				view: 602
				loop: 0
				cel: 6
				posn: 182 150
				setPri: 10
				ignoreActors:
				init:
				stopUpd:
			)
		else
			(door
				view: 602
				loop: 0
				cel: 0
				posn: 182 150
				setPri: 10
				init:
				stopUpd:
			)
		)
		(if (<= (gEgo y:) horizon)
			(gEgo y: (+ horizon (gEgo yStep:)))
		)
		(switch gPrevRoomNum
			(0
				(gEgo posn: 128 166)
			)
			(28
				(gEgo posn: 48 (+ horizon (gEgo yStep:) 1))
			)
			(3
				(gEgo posn: 2 (gEgo y:))
			)
			(5
				(gEgo posn: 317 (gEgo y:))
			)
			(10
				(gEgo posn: (gEgo x:) 187)
			)
			(49
				(gEgo loop: 2 posn: 173 153)
			)
		)
		(gEgo view: 2 xStep: 2 yStep: 1 init:)
		(if (and (== gPrevRoomNum 10) global121 (!= global179 1))
			(= global121 (Act new:))
			(global121
				posn: 110 (+ 189 (- global173 75) 80)
				view: 250
				xStep: 6
				yStep: 2
				setCycle: Walk
				ignoreActors:
				init:
			)
			(gCurRoom setScript: ogreActions)
			(= local9 (Sound new:))
			(local9 number: 5 loop: -1 play:)
		else
			(= global121 0)
		)
		(if (and (== gAct 2) (not gSeenOgressDeerFlag))
			(= gSeenOgressDeerFlag 1)
			(= local1 (Act new:))
			(local1
				posn: 4 142
				view: 246
				xStep: 1
				yStep: 1
				setCycle: Walk
				ignoreActors:
				init:
			)
			(= local8 (Sound new:))
			(gCurRoom setScript: ogressActions)
			(local1 setMotion: MoveTo 103 168 ogressActions)
			(local8 number: 10 loop: -1 play:)
		)
		(if
			(and
				(not global121)
				(< (Random 1 100) 35)
				(!= global179 1)
				(!= gPrevRoomNum 49)
				(not (gCast contains: local1))
			)
			(= global121 (Act new:))
			(global121
				posn: 1 179
				view: 250
				xStep: 6
				yStep: 2
				setCycle: Walk
				ignoreActors:
				init:
			)
			(if (< (Random 1 100) 50)
				(global121 posn: 110 239)
			)
			(= local9 (Sound new:))
			(local9 number: 5 loop: -1 play:)
			(gCurRoom setScript: ogreActions)
		)
		(if (== global165 4)
			(gCurRoom setScript: ogreActions)
			(ogreActions changeState: 200)
		)
		(if (== (door cel:) 0)
			(gEgo observeControl: 16384)
		)
	)

	(method (dispose)
		(= global189 0)
		(gEgo setPri: -1)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(gSounds eachElementDo: #dispose)
		(if (gCast contains: gEgo)
			(gEgo illegalBits: $8000)
			(gEgo setPri: -1)
		)
		(if (!= newRoomNumber 49)
			(= global165 0)
		)
		(= global189 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 0) $4000) (!= (door cel:) 0))
			(gCurRoom newRoom: 49)
		)
		(if (gCast contains: gEgo)
			(if (gEgo inRect: 143 0 369 136)
				(gEgo setPri: 1)
			else
				(gEgo setPri: -1)
			)
		)
		(if (gCast contains: global121)
			(if (global121 inRect: 143 0 369 136)
				(global121 setPri: 1)
			else
				(global121 setPri: -1)
			)
		)
		(if (gCast contains: local1)
			(cond
				((local1 inRect: 143 0 369 136)
					(local1 setPri: 1)
				)
				((< (ogressActions state:) 200)
					(local1 setPri: -1)
				)
			)
		)
		(if
			(and
				(== local3 1)
				(not
					(and
						(gEgo inRect: 134 0 369 137)
						(local1 inRect: 104 149 369 185)
					)
				)
				(< (gEgo distanceTo: local1) 75)
			)
			(= local3 2)
			(ogressActions changeState: 10)
			(Print 4 0) ; "The ogress sees you! You'd better run as she'd like to have YOU for dinner!"
		)
		(if
			(and
				(== local3 1)
				(not (gEgo inRect: 134 0 369 137))
				(not (local1 inRect: 104 149 369 185))
			)
			(= local4
				(GetAngle (local1 x:) (local1 y:) (gEgo x:) (gEgo y:))
			)
			(if (and (< (= local5 (local1 heading:)) 15) (> local4 345))
				(+= local5 360)
			)
			(if (< (Abs (- local4 local5)) 15)
				(= local3 2)
				(Print 4 0) ; "The ogress sees you! You'd better run as she'd like to have YOU for dinner!"
				(ogressActions changeState: 10)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/cottage')
							(Print 4 1) ; "This is a large, crudely-built, thatched-roof house. It makes you feel uneasy."
						)
						((Said '/door')
							(Print 4 2) ; "This is a heavy, wooden door."
						)
						((Said '/bucket')
							(Print 4 3) ; "There is nothing in the pail."
						)
						((Said '/buck')
							(if (gCast contains: local1)
								(Print 4 4) ; "Poor thing!"
							)
						)
						((Said '/window')
							(if (gEgo inRect: 266 140 304 155)
								(Print 4 5) ; "You peek through the window, but can make out no details."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/giantess')
							(if (gCast contains: local1)
								(switch (local1 view:)
									(246
										(Print 4 6) ; "This is a mean-looking lady! The ogress is returning home after having caught a poor deer in the surrounding forest."
									)
									(245
										(Print 4 7) ; "The ogress sees you! Maybe she'd rather have YOU for dinner instead of the deer!"
									)
								)
							else
								(Print 4 8) ; "You can't see one here."
							)
						)
						((Said '[<around][/room]')
							(Print 4 9) ; "You see a large, thatched-roof house surrounded by forest; and it looks very formidable. It might be wise to use caution here."
						)
					)
				)
				((and (gCast contains: local1) (Said 'talk'))
					(if (and (== (local1 view:) 246) (!= local3 3))
						(if (not (gEgo inRect: 143 0 319 136))
							(Print 4 10) ; "Now you've blown it! You foolishly spoke to the ogress, and drew her attention toward you. Now she's headed your way!"
							(ogressActions changeState: 10)
							(= local3 2)
						else
							(Print 4 11) ; "She can't see you now. It would be better not to attract attention."
						)
					else
						(Print 4 12) ; "This is no time for conversation!"
					)
				)
				((Said 'get,capture/buck')
					(cond
						((gCast contains: local1)
							(Print 4 13) ; "Are you KIDDING?!"
						)
						((gCast contains: local6)
							(Print 4 14) ; "You are not interested in the deer."
						)
						(else
							(Print 4 15) ; "What deer?"
						)
					)
				)
				((Said 'get,capture/giantess')
					(Print 4 16) ; "That's ridiculous!"
				)
				((Said 'open/door')
					(if (gEgo inRect: 163 144 199 155)
						(cond
							(
								(or
									(gCast contains: local1)
									(gCast contains: global121)
								)
								(Print 4 17) ; "You don't have the time for that now!"
							)
							((!= gAct 2)
								(Print 4 18) ; "You can't. It's locked and you don't have the key."
							)
							(else
								(gEgo loop: 3)
								(HandsOff)
								(door setPri: 9 setCycle: End)
								((Sound new:) number: 300 loop: 1 play: door)
								(gEgo illegalBits: $8000)
							)
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'bang')
					(if (< (gEgo distanceTo: door) 10)
						(cond
							((gCast contains: global121)
								(Print 4 19) ; "You don't have time for that!"
							)
							((!= gAct 2)
								(Print 4 20) ; "You cautiously tap at the door, but are greeted only with vicious barking from the other side."
							)
							((not (gCast contains: local1))
								(Print 4 21) ; "You cautiously tap at the door. "JUST A MINUTE! I'M COMIN'!" a loud woman's voice yells. With a jerk, the door opens to reveal...oh no!...the ogress!!"
								(gCurRoom setScript: ogressActions)
								(ogressActions changeState: 200)
							)
							(else
								(Print 4 22) ; "You don't have time for that."
							)
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'unlatch')
					(if (!= gAct 2)
						(Print 4 18) ; "You can't. It's locked and you don't have the key."
					else
						(Print 4 23) ; "The door is already unlocked."
					)
				)
				((Said 'break/window')
					(Print 4 24) ; "That's vandalism!"
				)
				((Said 'break/door')
					(Print 4 25) ; "You could never do that."
				)
				((Said 'open/window')
					(Print 4 26) ; "The windows do not open."
				)
			)
		)
	)
)

(instance ogressActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(= seconds 3)
				)
			)
			(1
				(= local3 1)
				(local1 setLoop: 0)
			)
			(2
				(local1 setMotion: MoveTo 183 155 ogressActions)
			)
			(3
				(door setCycle: End self)
			)
			(4
				(= local3 3)
				(local1
					baseSetter: (ScriptID 0 1) ; smallBase
					setPri: 9
					setMotion: MoveTo 187 144 self
				)
			)
			(5
				(door setCycle: Beg self)
			)
			(6
				(= local3 0)
				(local8 dispose:)
				(local1 dispose:)
				(= local1 0)
			)
			(10
				(= local6 (Prop new:))
				(local6
					view: 530
					ignoreActors:
					setPri: (+ (local1 priority:) 1)
					posn: (- (local1 x:) 6) (+ (local1 y:) 3)
					setCycle: End self
					init:
				)
				(local1 setLoop: -1 setMotion: 0 view: 245)
				(door setCycle: 0)
			)
			(11
				(local1
					setAvoider: (Avoid new:)
					xStep: 6
					yStep: 2
					setLoop: -1
					setCycle: Walk
					ignoreActors:
					setMotion: Chase gEgo 5 self
				)
				(if (gCast contains: local6)
					(local6 ignoreActors: 0 setPri: -1)
				)
			)
			(12
				(if (gSounds contains: local8)
					(local8 dispose:)
				)
				(= local8 (Sound new:))
				(local8 number: 11 loop: 1 play: self)
				(HandsOff)
				(gEgo dispose:)
				(local1 view: 57 setCycle: Fwd)
				(Print 4 27 #at -1 20 #draw) ; "Poor Rosella! It looks like you'll join the deer in the stew pot tonight!"
			)
			(13
				(= seconds 2)
			)
			(14
				(= gDeathFlag 1)
			)
			(200
				(door setCycle: End self)
				(= local1 (Act new:))
				(local1
					view: 245
					setPri: 9
					loop: 2
					ignoreActors:
					baseSetter: (ScriptID 0 1) ; smallBase
					posn: 186 145
					init:
				)
				(HandsOff)
			)
			(201
				(= seconds 1)
			)
			(202
				(self changeState: 11)
			)
		)
	)
)

(instance ogreActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: global121)
					(ogreActions changeState: 1)
				)
			)
			(1
				(= local2 1)
				(if (gEgo inRect: 223 74 319 136)
					(global121 setMotion: MoveTo 97 123 self)
				else
					(self changeState: 2)
				)
			)
			(2
				(global121
					setAvoider: (Avoid new:)
					xStep: 6
					yStep: 2
					ignoreActors:
					setMotion: Chase gEgo 5 self
				)
			)
			(3
				(HandsOff)
				(gEgo dispose:)
				(global121 view: 78 setCycle: End self)
			)
			(4
				(local9 dispose:)
				(= local9 (Sound new:))
				(local9 number: 6 loop: 1 play:)
				(global121 setAvoider: 0 view: 79 setCycle: Walk self)
				(Print 4 28 #at -1 20 #draw) ; "Oh no! You're caught! The terrible ogre grabs you by the braids and drags you off to an untimely end. Dinner will definitely be on YOU tonight!"
				(cond
					((global121 inRect: -50 70 350 93)
						(global121 setMotion: MoveTo 37 87 self)
					)
					(
						(or
							(global121 inRect: -50 93 350 136)
							(global121 inRect: 92 135 141 148)
						)
						(self changeState: 5)
						(= local0 (Timer setReal: killOgre 15))
					)
					(else
						(self changeState: 7)
						(= local0 (Timer setReal: killOgre 15))
					)
				)
			)
			(5
				(global121 setMotion: MoveTo 75 120 self)
			)
			(6
				(global121 setMotion: MoveTo 75 164 self)
			)
			(7
				(global121 setMotion: MoveTo 182 164 self)
			)
			(8
				(if (gTimers contains: local0)
					(local0 dispose: delete:)
				)
				(if (== (door cel:) 0)
					(door setCycle: End self)
				else
					(self changeState: 9)
				)
			)
			(9
				(door ignoreActors:)
				(global121 setMotion: MoveTo 182 154 self)
			)
			(10
				(= seconds 3)
			)
			(11
				(gSounds eachElementDo: #dispose)
				(= seconds 2)
			)
			(12
				(= gDeathFlag 1)
			)
			(200
				(= seconds 5)
			)
			(201
				(= global121 (Act new:))
				(global121
					loop: 2
					posn: 186 148
					view: 250
					baseSetter: (ScriptID 0 1) ; smallBase
					setCycle: Walk
					setAvoider: Avoid
					init:
				)
				(= local9 (Sound new:))
				(local9 number: 5 loop: -1 play:)
				(if (< (global121 distanceTo: gEgo) 10)
					(self changeState: 1)
				else
					(global121 setMotion: MoveTo 181 159 self)
				)
			)
			(202
				(global121 observeControl: 16384)
				(self changeState: 1)
			)
		)
	)
)

(instance killOgre of Script
	(properties)

	(method (cue)
		(= gDeathFlag 1)
	)
)

