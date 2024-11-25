;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm81 0
)

(local
	[local0 3]
	local3
	[local4 4]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm81 of Rm
	(properties
		picture 81
		style 0
	)

	(method (dispose)
		(exitScript dispose:)
		(entranceScript dispose:)
		(coverScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= local15 (Random 100 400))
		(if (and (not global237) (not global236))
			(= local19 (Random 30 50))
		)
		(HandsOn)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 261)
		(Load rsVIEW 191)
		(if (not global237)
			(Load rsVIEW 88)
			(Load rsVIEW 32)
			(Load rsVIEW 46)
			(Load rsVIEW 52)
			(Load rsVIEW 264)
		)
		(= global211 0)
		(= global212 1)
		(= local20 100)
		((= local10 (View new:))
			view: 261
			loop: 2
			cel: (if global196 1 else 0)
			posn: 62 189
			init:
			ignoreActors:
			stopUpd:
		)
		((= local8 (Act new:))
			view: 264
			posn: -15 124
			init:
			illegalBits: 0
			setStep: 2 1
			moveSpeed: 1
			setCycle: Fwd
			setScript: duckScript
		)
		(if (== gPrevRoomNum 120)
			(entranceScript changeState: 0)
		else
			(gEgo
				posn: 1 171
				view: (if (not global204) 0 else 6)
				setPri: -1
				init:
				setMotion: MoveTo 320 171
				startUpd:
			)
			(if global196
				(= local9 1)
				(gEgo illegalBits: $9000)
			)
		)
	)

	(method (doit &tmp [temp0 20])
		(if (and global236 (== (gCurRoom script:) 0))
			(self setScript: (ScriptID 77)) ; muggerScript
		)
		(if (and (not global237) (> local19 1))
			(-- local19)
		)
		(if (> local15 0)
			(-- local15)
		)
		(if
			(and
				(== local19 1)
				(== local15 0)
				(not global204)
				(not global106)
				(gEgo inRect: 110 156 185 180)
			)
			(self setScript: (ScriptID 77)) ; muggerScript
			(= local3 1)
			(= local19 0)
		)
		(cond
			((> local20 1)
				(-- local20)
			)
			((== local20 1)
				(= local20 0)
				(duckScript changeState: 0)
				(= local20 (Random 200 300))
			)
		)
		(if (and (< (gEgo x:) 0) (not global106))
			(gCurRoom newRoom: 79)
		)
		(if global196
			(if
				(and
					(== (gEgo onControl: 1) 8192)
					(not local18)
					(not local17)
				)
				(= local18 1)
				(localproc_0 81 0) ; "Yeow! That was a close one! You'd better watch out that you don't fall into the open manhole."
			)
			(if (not (== (gEgo onControl: 1) 8192))
				(= local18 0)
			)
		)
		(if (and (gCast contains: local11) (> (gEgo x:) 135))
			(local11 dispose:)
		)
		(if (and global237 (not local12) (not local14))
			(doggieScript changeState: 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '[*]/dog')
						(cond
							(local12
								(localproc_0 81 1) ; "Whoops! That's a mighty fast poodle."
							)
							(local14
								(localproc_0 81 2) ; "That doggone dog's gone!"
							)
							(else
								(localproc_0 81 3) ; "What dog? Where?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/chamber')
								(localproc_0 81 4) ; "Mighty big room, this park!"
							)
							((Said '[<at,around][/scenery,park]')
								(localproc_0 81 5) ; "The park is pretty this time of year. The air is sweet and clear, except near the manhole cover."
							)
							((Said '/man,mugger')
								(localproc_0 81 6) ; "There's nobody there."
							)
							((Said '/sand')
								(localproc_0 81 7) ; "It used to be part of the 17th hole at the old Steelton Golf Links. It's very nice sand, but you see nothing unusual."
							)
							((Said '/duck,bird')
								(localproc_0 81 8) ; "The little brown ducks will almost eat out of your hand."
							)
							((Said '/egg')
								(localproc_0 81 9) ; "Quit thinking of omelets!"
							)
							((Said '/tree')
								(localproc_0 81 10) ; "You look closely at the tree, but you can't find anything that even resembles a clue."
							)
							((Said '/bush,brush,bush')
								(localproc_0 81 11) ; "You admire the beauty of the shrubbery, but you see nothing out the ordinary."
							)
							((or (Said '<up') (Said '/air'))
								(localproc_0 81 12) ; "Meteorologists tell us that it's called the "sky"."
							)
							((Said '/flower')
								(localproc_0 81 13) ; "You see a beautiful assortment of chrysanthemums."
							)
							((Said '/chrysanthemum')
								(localproc_0 81 14) ; "It's an ornamental plant, grown for its brightly colored, often double flower head."
							)
							((Said '/pond,water')
								(localproc_0 81 15) ; "The pond really adds to the scenery, but that's all it does in this game."
							)
							((Said '/cloud')
								(localproc_0 81 16) ; "The fluffy white clouds remind you of the cotton balls in Marie's makeup kit."
							)
							((Said '/rock')
								(localproc_0 81 17) ; "You look all around the rock. You find nothing."
							)
							((or (Said '/dirt') (Said '<down'))
								(if (gEgo inRect: 0 160 132 200)
									(if (not global196)
										(SetScore 1 100)
										(localproc_0 81 18) ; "Looking at the ground you see..."
										(localproc_0 81 19) ; "...a manhole cover!"
										(= local9 1)
									else
										(localproc_0 81 20) ; "The open manhole yawns before you."
										(= local9 1)
									)
								else
									(localproc_0 81 21) ; "Good old Mother Earth!"
								)
							)
							((Said '/sewer,complex')
								(if global196
									(localproc_0 81 22) ; "It's too dark to tell what's down there without climbing in."
								else
									(localproc_0 81 23) ; "You can't see it."
								)
							)
							((Said '/ladder')
								(if global196
									(localproc_0 81 24) ; "It disappears into the darkness."
								else
									(localproc_0 81 25) ; "What ladder? Where?"
								)
							)
							((Said '/clue')
								(cond
									((not local16)
										(localproc_0 81 26) ; "What evidence?"
									)
									(
										(and
											local16
											(gEgo inRect: 0 160 132 200)
										)
										(localproc_0 81 27) ; "You see gouge marks and torn lawn."
									)
									(else
										(localproc_0 81 28) ; "You're not close enough."
									)
								)
							)
							((Said '/lid,cover,manhole,hole,sewer')
								(if (gEgo inRect: 0 160 132 200)
									(if (not global196)
										(if (not local16)
											((= local11 (View new:))
												view: 261
												loop: 0
												cel: 3
												posn: 58 116
												init:
												stopUpd:
												ignoreActors:
											)
											(SetScore 1 100)
											(= local16 1)
											(localproc_0 81 29 83) ; "It looks like a normal manhole cover. You see evidence of recent use."
										else
											(localproc_0 81 27) ; "You see gouge marks and torn lawn."
										)
									else
										(localproc_0 81 30) ; "There's a ladder in the opening. Apparently, it leads down into the Steelton sewer system."
									)
								else
									(localproc_0 81 31) ; "You're too far away."
								)
							)
						)
					)
					((Said 'extender/dispatch')
						(localproc_0 81 32) ; "You only have walkie-talkies designed for local use."
					)
					((Said 'feed/duck')
						(localproc_0 81 33) ; "You really don't have time. Besides, you don't have anything to feed them."
					)
					((Said 'get,kill,fire,eat/duck,egg')
						(localproc_0 81 34) ; "Planning a barbecue while your girlfriend's kidnapped? C'mon Sonny! Where's your sense of proportion?"
					)
					((Said 'talk/duck,egg')
						(localproc_0 81 35) ; "You're overwrought, Sonny!"
					)
					((Said 'dig[/hole,dirt]')
						(localproc_0 81 36) ; "You don't have a shovel, and besides....why would you want to do that?"
					)
					((Said 'lie,lay/dirt,grass,lawn')
						(localproc_0 81 37) ; "You took your vitamins this morning. Why would you want to do that?"
					)
					(
						(or
							(Said 'get,jump,swim,walk,wade[<in]/pond,water')
							(Said 'swim[<go]')
						)
						(localproc_0 81 38) ; "Look here, Detective Bonds....this ain't no picnic, there's an ordinance prohibiting swimming in city parks, and besides all that, Sweet Cheeks is in deep trouble. Get going!"
					)
					((Said 'drink/water')
						(localproc_0 81 39) ; "Leave it for the ducks."
					)
					((Said 'get/rock')
						(localproc_0 81 40) ; "It's only the tip of a large granite boulder. You couldn't move it. Who'd want to, anyway?"
					)
					((Said 'hoist,move/rock')
						(localproc_0 81 41) ; "The rocks are buried in the ground, and you don't have either the time or the earth-moving equipment."
					)
					((Said 'climb/tree')
						(localproc_0 81 42) ; "There isn't a need to do that."
					)
					((Said 'climb,jump/fence')
						(localproc_0 81 43) ; "You haven't finished your search of the park yet."
					)
					((Said 'pick/flower')
						(localproc_0 81 44) ; "They're public property, Sonny, as you well know!"
					)
					((Said 'get/grass,lawn')
						(localproc_0 81 45) ; "Nowhere in the game will grass help you."
					)
					((and (Said 'get,get/clue,cover,manhole,ladder') local9)
						(localproc_0 81 46) ; "You don't need it."
					)
					((Said 'show/badge,badge')
						(localproc_0 81 47) ; "Nobody can see your badge right now."
					)
					(
						(or
							(Said 'call,extender/backup,friend')
							(Said '(key<up),use/extender,(talkie<walkie)')
						)
						(if (gEgo has: 30) ; walkie_talkie
							(if (not global237)
								(switch (Random 1 4)
									(1
										(localproc_0 81 48) ; "You key the walkie-talkie trying to raise Keith....you pause to listen, and then you hear..."
										(localproc_0 81 49) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
										(localproc_0 81 50) ; "A lot of noise and no answer...you can't seem to get him."
									)
									(2
										(localproc_0 81 51) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
									)
									(3
										(localproc_0 81 52) ; "You listen but he doesn't answer."
									)
									(4
										(localproc_0 81 53) ; "After trying to raise Keith and getting a lot of static, you think to yourself...."WHEW! This is one sorry radio.""
									)
								)
							else
								(localproc_0 81 54) ; "The mugger's gone, Sonny. What's your story?"
							)
						)
					)
					((Said 'read/right,miranda,miranda')
						(localproc_0 81 6) ; "There's nobody there."
					)
					((Said 'interrogate,talk/man,mugger')
						(if global238
							(localproc_0 81 55) ; "He's off to jail, now. Besides, he wasn't a brilliant conversationalist the first time, anyway."
						else
							(localproc_0 81 6) ; "There's nobody there."
						)
					)
					(
						(Said
							'open,hoist,remove,move,press/lid,cover,manhole,sewer'
						)
						(if (gEgo inRect: 40 170 102 189)
							(if (not global196)
								(coverScript changeState: 0)
							else
								(localproc_0 81 56) ; "You already opened it."
							)
						else
							(localproc_0 81 31) ; "You're too far away."
						)
					)
					((Said 'drop,close,replace/cover,manhole')
						(if (gEgo inRect: 40 170 102 189)
							(if (not global196)
								(localproc_0 81 57) ; "The cover's on pretty tight already."
							else
								(localproc_0 81 58) ; "What for?"
							)
						else
							(localproc_0 81 31) ; "You're too far away."
						)
					)
					(
						(or
							(Said 'go,get,enter,climb,stair<down,in,hole')
							(Said 'stair,crawl<[in]/sewer')
							(Said 'climb/ladder,sewer')
						)
						(= local17 1)
						(cond
							(global196
								(exitScript changeState: 0)
							)
							(local9
								(not global196)
								(localproc_0 81 59) ; "You have to get to it first."
							)
							(else
								(localproc_0 81 60) ; "What? Where?"
							)
						)
					)
				)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(localproc_0 81 61 25 8) ; "You step onto the ladder and begin the climb down."
				(self cue:)
			)
			(1
				(gEgo setMotion: MoveTo 75 179 self)
			)
			(2
				(gEgo
					view: 261
					loop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: -1 cycleSpeed: 0)
				(self cue:)
			)
			(4
				(gEgo illegalBits: $8000)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance entranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 261
					loop: 3
					posn: 75 179
					setPri: -1
					init:
					illegalBits: 0
					startUpd:
				)
				(= local9 1)
				(= global196 1)
				(= local17 1)
				(local10 cel: 1)
				(self cue:)
			)
			(1
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(2
				(NormalEgo)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 95 179 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 93 179 illegalBits: $9000)
				(= local17 0)
				(HandsOn)
			)
		)
	)
)

(instance coverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 54 180 83 189)
					(localproc_0 81 62) ; "How can you do that when you're standing on it?"
				else
					(self cue:)
				)
			)
			(1
				(local10 setCel: 1)
				(cond
					((or (not local16) (not (gCast contains: local11)))
						((= local11 (View new:))
							view: 261
							loop: 0
							cel: 4
							posn: 58 116
							init:
							stopUpd:
							ignoreActors:
						)
					)
					((gCast contains: local11)
						(local11 setCel: 4)
					)
				)
				(SetScore 2 101)
				(self cue:)
			)
			(2
				(localproc_0 81 63 83) ; "Straining, you manage to slide the heavy cover off of the manhole."
				(self cue:)
			)
			(3
				(= global196 1)
				(gEgo illegalBits: $9000)
			)
		)
	)
)

(instance duckScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local8 setLoop: 0 setMotion: MoveTo 34 145 self)
			)
			(1
				(local8 setLoop: 4 setCycle: End self)
			)
			(2
				(local8 setCycle: Beg self)
			)
			(3
				(local8 setLoop: 1 setCycle: Fwd setMotion: MoveTo -15 124)
			)
		)
	)
)

(instance doggieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local12 1)
				((= local13 (Act new:))
					view: 191
					loop: 0
					setStep: 6 4
					init:
					setCycle: Fwd
					setAvoider: (Avoid new:)
				)
				(local13 posn: 0 185 setMotion: MoveTo 150 170 self)
			)
			(1
				(local13 loop: 1 setMotion: MoveTo 0 170 self)
			)
			(2
				(local13 dispose:)
				(= local12 0)
				(= local14 1)
			)
		)
	)
)

