;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room49 0
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
	local10
	local11
	local12
	local13
)

(instance Room49 of Rm
	(properties
		picture 49
		style 16
	)

	(method (init)
		(Load rsVIEW 250)
		(Load rsVIEW 15)
		(Load rsVIEW 78)
		(Load rsVIEW 79)
		(Load rsVIEW 615)
		(Load rsVIEW 616)
		(Load rsVIEW 256)
		(Load rsVIEW 245)
		(Load rsVIEW 48)
		(Load rsVIEW 360)
		(Load rsVIEW 541)
		(Load rsVIEW 351)
		(Load rsVIEW 352)
		(Load rsVIEW 350)
		(Load rsVIEW 87)
		(self setRegions: 602) ; regOgreHouse
		(super init:)
		(ogreChaseMusic init:)
		(ogreCatchMusic init:)
		(ogressChaseMusic init:)
		(ogressCatchMusic init:)
		(if (and (> global165 0) (!= global165 5) (not global167))
			(= local1 1)
		)
		(= gIndoors 1)
		(= global189 1)
		(if gNight
			((View new:)
				view: 616
				loop: 1
				posn: 50 129
				ignoreActors: 1
				addToPic:
				stopUpd:
			)
		)
		((Prop new:)
			view: 541
			loop: (if gNight 1 else 2)
			cel: 0
			posn: 86 137
			ignoreActors: 1
			setPri: 12
			setCycle: Fwd
			init:
		)
		((= local4 (Act new:))
			view: 351
			illegalBits: 0
			loop: 1
			setStep: 5 2
			posn: (if (== ((gInventory at: 23) owner:) 49) 155 else 160) 126 ; Bone
			init:
		)
		((= local3 (Act new:)) view: 360 posn: 230 130 init: hide:)
		(if (== global165 5)
			((gInventory at: 33) owner: 48) ; Magic_Hen
		)
		(if ((gInventory at: 33) ownedBy: 49) ; Magic_Hen
			(local3 setScript: henPecked)
		)
		((= local5 (Prop new:))
			view: 615
			loop: 0
			cel: 0
			posn: 209 124
			init:
			stopUpd:
		)
		((= local6 (Prop new:))
			view: 616
			ignoreActors: 1
			loop: 0
			posn: 59 130
			init:
		)
		(if (or (== gPrevRoomNum 4) (== gPrevRoomNum 0))
			(local6 setPri: 0 ignoreActors: 1)
			(= global210 1)
			(gEgo
				posn: 53 133
				view: 2
				loop: 0
				setStep: 2 1
				illegalBits: $8000
				init:
			)
			(if (or (> gAct 2) (gEgo has: 33)) ; Magic_Hen
				((= local2 (Act new:))
					view: 245
					posn: 65 132
					setStep: 4 2
					init:
					setScript: ogressChase
				)
			)
		)
		(if (== gPrevRoomNum 48)
			(gEgo
				posn: 181 70
				view: 2
				loop: 1
				setStep: 2 1
				illegalBits: $8000
				init:
			)
		)
		(if (== gPrevRoomNum 50) ; OgresKitchen
			(gEgo
				posn: 267 132
				view: 2
				setStep: 2 1
				illegalBits: $8000
				init:
			)
			(if global167
				((= local2 (Act new:))
					view: 245
					illegalBits: $8000
					posn: 301 132
					setStep: 4 2
					init:
					setScript: ogressChase
				)
			)
			(if (or (== global165 1) (== global165 90))
				(self setScript: ogreStuff)
			)
		)
		(if (== gPrevRoomNum 51)
			(gEgo
				view: 2
				setStep: 2 1
				loop: 2
				illegalBits: $8000
				posn: 225 129
				init:
				setCycle: Walk
				setMotion: 0
			)
			(if (== global165 5)
				((= local2 (Act new:))
					view: 245
					illegalBits: $8000
					posn: 301 132
					setStep: 4 2
					init:
					setScript: ogressChase
				)
			)
			(if (== global165 4)
				((= local0 (Act new:))
					view: 250
					posn: 235 133
					setStep: 6 2
					init:
					setCycle: Walk
				)
			)
		)
		(if (== global165 2)
			(local6 setPri: -1 cel: 0)
			((= local0 (Act new:))
				view: 256
				posn: 201 159
				setStep: 6 2
				init:
				cycleSpeed: 2
				setCycle: Fwd
			)
			(local0 setScript: ogreAwake)
		)
		(if (== global165 3)
			(local6 setPri: -1 cel: 0)
			((= local0 (Act new:))
				illegalBits: 0
				view: 256
				posn: 201 159
				setStep: 6 2
				init:
				cycleSpeed: 2
				setCycle: Fwd
			)
			(local0 setScript: ogreAwake)
		)
		(= global210 (if (> global165 1) 0 else 1))
		(local6
			cel:
				(if global210
					(local6 lastCel:)
				else
					0
				)
			init:
			stopUpd:
		)
		(if (not (local6 cel:))
			(gEgo observeControl: 16384)
		else
			(gEgo ignoreControl: 16384)
		)
		(if (== ((gInventory at: 23) owner:) 49) ; Bone
			(local4 setScript: chewBone)
		else
			(local4 setScript: chaseEgo)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0004)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(if
			(and
				global165
				(> (gEgo x:) 111)
				(> (gEgo y:) 123)
				(!= global165 5)
				(!= (self script:) ogreStuff)
				(!= (self script:) ogreAwake)
				(not
					(and
						(== gPrevRoomNum 50) ; OgresKitchen
						(or (== global165 4) (== global165 1))
					)
				)
			)
			(self setScript: ogreStuff)
		)
		(if (& (gEgo onControl: 0) $0040)
			(HandsOn)
			(gCurRoom newRoom: 4)
		)
		(if (and (& (gEgo onControl: 0) $0010) (not local11))
			(HandsOn)
			(gCurRoom newRoom: 51)
		)
		(if (& (gEgo onControl: 0) $0008)
			(HandsOn)
			(gCurRoom newRoom: 48)
		)
		(if (and (& (gEgo onControl: 0) $0020) (not local11))
			(HandsOn)
			(gCurRoom newRoom: 50) ; OgresKitchen
		)
		(if (and (& (gEgo onControl: 0) $0400) (not local10) (not local11))
			(= local10 1)
			(HandsOff)
			(moveOnTheStairs changeState: 1)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 4)
			((ScriptID 602) keep: 0) ; regOgreHouse
			(= global189 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(ogreChaseMusic keep: 0)
		(ogreCatchMusic keep: 0)
		(ogressChaseMusic keep: 0)
		(ogressCatchMusic keep: 0)
		(gSounds eachElementDo: #dispose)
		(User canInput: 1 canControl: 1)
		(= global189 0)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '<under/table')
								(Print 49 0) ; "There is nothing of interest under the table."
							)
							((Said '/table')
								(if local0
									(Print 49 1) ; "The terrible ogre is asleep at the table, snoring loudly."
								else
									(Print 49 2) ; "It's a large wooden table."
								)
							)
							((Said '/chair')
								(Print 49 3) ; "There are two chairs at the table."
							)
							((Said '/carpet,carpet')
								(Print 49 4) ; "A worn rug lies on the floor."
							)
							((Said '/stair')
								(Print 49 5) ; "The stairway goes upwards."
							)
							((Said '/window')
								(Print 49 6) ; "You see the forest out the window."
							)
							((Said '/door')
								(Print 49 7) ; "The front door leads outside. There is an open doorway to the right, and a closet door under the stairs."
							)
							((Said '/wall')
								(Print 49 8) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 49 9) ; "There is nothing interesting on the floor."
							)
							((Said '/giant')
								(cond
									((== global165 3)
										(Print 49 1) ; "The terrible ogre is asleep at the table, snoring loudly."
									)
									(global165
										(Print 49 10) ; "This ogre looks MEAN! Better get out of there...FAST!"
									)
									(else
										(Print 49 11) ; "You don't see him now."
									)
								)
							)
							((Said '/bulldog')
								(if (== (local4 script:) chewBone)
									(Print 49 12) ; "The big dog is totally engrossed in its bone."
								else
									(Print 49 13) ; "This is definitely not your basic cute pooch. This dog means business."
								)
							)
							((Said '[<around][/room,cottage]')
								(Print 49 14) ; "This isn't the most cozy-looking living room you've ever seen. In fact, the ogres' house looks almost...frightening!"
							)
						)
					)
					((Said 'blow/whistle')
						(if (and (gEgo has: 27) (gCast contains: local0)) ; Silver_Whistle
							(if (== global165 3)
								(Print 49 15) ; "That's not a good idea!"
							else
								(Print 49 16) ; "That won't help you, Rosella!"
							)
						else
							(event claimed: 0)
						)
					)
					((Said 'talk/bulldog')
						(if (== (local4 script:) chewBone)
							(Print 49 17) ; "The dog is too interested in its bone to listen to you."
						else
							(Print 49 18) ; "Soothing words will not placate this dog."
						)
					)
					((Said 'kill/bulldog')
						(Print 49 19) ; "You couldn't kill that big dog."
					)
					((Said 'pat/bulldog')
						(Print 49 20) ; "Not this dog!"
					)
					((Said 'calm/bulldog')
						(Print 49 21) ; "This dog will not be gentled."
					)
					((Said 'get,capture/bulldog')
						(Print 49 22) ; "You woudln't want this dog, even if you COULD get it."
					)
					((Said 'sit>')
						(Print 49 23) ; "You don't have time for that!"
						(event claimed: 1)
					)
					((Said 'talk/bulldog')
						(if (== (local4 script:) chewBone)
							(Print 49 17) ; "The dog is too interested in its bone to listen to you."
						else
							(Print 49 18) ; "Soothing words will not placate this dog."
						)
					)
					((Said 'talk,awaken[/giant]')
						(if (gCast contains: local0)
							(if (== global165 3)
								(if
									(and
										(< (gEgo distanceTo: local0) 50)
										(not (ogreAwake state:))
									)
									(Print 49 24) ; "You foolishly speak to the sleeping ogre."
									(= local13 1)
									(ogreAwake cue:)
								else
									(Print 49 25) ; "You're too far away for him to hear you."
								)
							else
								(Print 49 26) ; "This is no time for conversation."
							)
						else
							(Print 49 27) ; "Just whom are you talking to?"
						)
					)
					((or (Said 'open/closet') (Said 'open/door<closet'))
						(cond
							((not (gEgo inRect: 219 123 245 130))
								(NotClose) ; "You're not close enough."
							)
							((local5 cel:)
								(Print 49 28) ; "It is open."
							)
							((gEgo has: 33) ; Magic_Hen
								(Print 49 10) ; "This ogre looks MEAN! Better get out of there...FAST!"
							)
							(else
								(local5 setScript: doorOpen)
							)
						)
					)
					((Said 'open/door')
						(cond
							((gEgo inRect: 219 123 245 130)
								(cond
									((local5 cel:)
										(Print 49 28) ; "It is open."
									)
									((gEgo has: 33) ; Magic_Hen
										(Print 49 10) ; "This ogre looks MEAN! Better get out of there...FAST!"
									)
									(else
										(local5 setScript: doorOpen)
									)
								)
							)
							((gEgo inRect: 38 131 93 141)
								(if (not (local6 cel:))
									(cond
										((gEgo has: 33) ; Magic_Hen
											(local6
												ignoreActors: 1
												setCycle: End
												setPri: 0
											)
											(= global210 1)
											(gEgo ignoreControl: 16384)
											(if
												(and
													(gEgo has: 33) ; Magic_Hen
													(== (ogreAwake state:) 0)
												)
												(ogreAwake changeState: 2)
											)
										)
										(
											(and
												(== global165 3)
												(not (ogreAwake state:))
											)
											(ogreAwake changeState: 2)
										)
									)
								else
									(Print 49 29) ; "It is already open."
								)
							)
							(else
								(Print 49 30) ; "You're not close enough to any doors."
							)
						)
					)
					((Said 'close/door')
						(cond
							((gEgo inRect: 219 123 245 130)
								(if (local5 cel:)
									(local5 setCycle: Beg)
								else
									(Print 49 31) ; "It is closed."
								)
							)
							((< (gEgo distanceTo: local6) 25)
								(if (local6 cel:)
									(local6 setCycle: Beg setPri: -1)
									(= global210 0)
									(gEgo observeControl: 16384)
								else
									(Print 49 31) ; "It is closed."
								)
							)
							(else
								(Print 49 30) ; "You're not close enough to any doors."
							)
						)
					)
					((Said 'get/egg[<gold]')
						(if (and local0 (< (gEgo distanceTo: local0) 20))
							(gEgo put: 33 49) ; Magic_Hen
							(ogreAwake changeState: 1)
						)
					)
					((Said 'get,rob/chicken')
						(cond
							((not local3)
								(Print 49 32) ; "Do you see one here?"
							)
							((gEgo has: 33) ; Magic_Hen
								(AlreadyTook) ; "You already took it."
							)
							(
								(and
									(gEgo inRect: 190 148 264 156)
									(> (gEgo x:) (- (local3 x:) 11))
									(< (gEgo x:) (+ (local3 x:) 11))
								)
								(= global182 1)
								(gEgo get: 33) ; Magic_Hen
								(gGame changeScore: 4)
								(local3 dispose:)
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
					((Said 'kill/giant')
						(Print 49 33) ; "You have no way of killing a giant ogre!"
					)
					(
						(or
							(Said 'kiss/giant')
							(Said 'kiss/bulldog')
							(Said 'kiss[/!*]')
						)
						(Print 49 34) ; "He wouldn't like it, and neither would you!"
					)
					((Said 'throw,give,feed/bone')
						(if (gEgo has: 23) ; Bone
							(if (> (gEgo distanceTo: local4) 40)
								(HandsOff)
								(local4 setMotion: 0 setCycle: 0 setScript: 0)
								((gInventory at: 23) moveTo: 49) ; Bone
								(gGame changeScore: 4)
								(local4 setScript: catchBone)
							else
								(Print 49 35) ; "It's too late for that, Rosella!"
							)
						else
							(Print 49 36) ; "Sorry, you don't have it to throw!"
						)
					)
					((Said 'get,rob/bone')
						(if (== ((gInventory at: 23) owner:) 49) ; Bone
							(Print 49 37) ; "That's REALLY not a good idea!"
						else
							(Print 49 38) ; "What bone?"
						)
					)
					((Said 'get,capture/giant')
						(Print 49 39) ; "That's ridiculous."
					)
					((and (Said 'give>') (= temp0 (gInventory saidMe:)))
						(if (and temp0 (gEgo has: (gInventory indexOf: temp0)))
							(if (gCast contains: local0)
								(Print 49 40) ; "You don't want to get that close to the ogre."
							else
								(Print 49 41) ; "The dog would not be interested in it."
							)
							(event claimed: 1)
						else
							(Print 49 42) ; "You don't have that."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance ogreStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not global167) (== (self state:) 11) (> (gEgo y:) 122))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global165
					(1
						(if global167
							(self changeState: 11)
						else
							(self changeState: 10)
						)
					)
					(2
						(self changeState: 20)
					)
					(3
						(self changeState: 30)
					)
				)
			)
			(10
				(if (== (local6 cel:) 0)
					(local6 setCycle: End setPri: 0)
				)
				(= local8 5)
				(playMusic cue:)
				(self cue:)
			)
			(11
				((= local0 (Act new:))
					view: 250
					posn: 53 133
					setStep: 6 2
					init:
					setCycle: Walk
				)
				(User canInput: 0)
				(if (not global167)
					(local0 setMotion: MoveTo 130 133)
				else
					(LookAt local0 gEgo)
				)
			)
			(12
				(= local11 1)
				(local0
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
			)
			(13
				(User canControl: 0 canInput: 0)
				(gEgo dispose:)
				(local0 view: 78 setCycle: End self)
				(Print 49 43 #at -1 30 #draw) ; "Got ya!"
				(= local8 6)
				(playMusic cue:)
				(Print 49 44 #at -1 20) ; "Oh, no! You're caught! The terrible ogre grabs you by the braids and drags you off to an untimely end. Dinner will definitely be on YOU tonight!"
			)
			(14
				(local0
					view: 79
					setPri: 9
					setCycle: Walk
					setAvoider: Avoid
					setMotion: MoveTo 246 132 self
				)
			)
			(15
				(= gDeathFlag 1)
			)
			(20
				(Print 49 45 #at -1 20) ; "You see the ogre sitting at the table."
				(ogreAwake state: 0)
				((= local0 (Act new:))
					illegalBits: 0
					view: 256
					loop: 2
					posn: 200 159
					setStep: 6 2
					setPri: 12
					init:
					setScript: ogreAwake
				)
			)
			(30
				(if (== gPrevRoomNum 51)
					(Print 49 46 #at -1 20) ; "You see the ogre sleeping at the table. You had better be real quiet..."
				)
			)
		)
	)
)

(instance ogreAwake of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not global167)
				(== (self state:) 1)
				(> (gEgo y:) 122)
				(not (& (gEgo onControl:) $0004))
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= global165 2)
					(= seconds 60)
				else
					(self cue:)
				)
			)
			(1
				(if (> (gEgo y:) 122)
					(return)
				)
			)
			(2
				(gEgo observeControl: 4)
				(cond
					((gEgo has: 33) ; Magic_Hen
						(if (not local13)
							(Print 49 47 #time 4) ; ""SQUAWK! SQUAWK!" Oh, oh! The hen has woken the ogre!"
						)
					)
					((== global165 3)
						(Print 49 48) ; "With a grunt, the ogre suddenly wakes up! Noticing you, he quickly jumps from his chair and heads your way."
					)
				)
				(= local8 5)
				(playMusic cue:)
				(local0 cycleSpeed: 0 loop: 1 setCycle: End self)
			)
			(3
				(= global165 4)
				(= local11 1)
				(local0
					view: 250
					posn: (local0 x:) (- (local0 y:) 3)
					setAvoider: Avoid
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
			)
			(4
				(User canControl: 0 canInput: 0)
				(if (gEgo has: 33) ; Magic_Hen
					(Print 49 49 #draw) ; "Now you've gone and done it! The vicious ogre grabs you and drags you toward the kitchen. As to what happens in the kitchen, let's just say that you are cordially invited to BE dinner."
				else
					(Print 49 44 #draw) ; "Oh, no! You're caught! The terrible ogre grabs you by the braids and drags you off to an untimely end. Dinner will definitely be on YOU tonight!"
				)
				(= local8 6)
				(gEgo dispose:)
				(local0 view: 78 setCycle: End self)
			)
			(5
				(local0
					view: 79
					setCycle: Walk
					illegalBits: $8000
					setPri: -1
					setAvoider: Avoid
					setMotion: MoveTo 246 132 self
				)
			)
			(6
				(= gDeathFlag 1)
			)
		)
	)
)

(instance ogressChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 1)
				(= local8 10)
				(playMusic cue:)
				(local2
					illegalBits: $8000
					setAvoider: Avoid
					ignoreActors: 1
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
			)
			(1
				(HandsOff)
				(= local8 11)
				(playMusic cue:)
				(gEgo hide:)
				(local2 view: 48 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(2
				(Print 49 50 #at -1 20 #draw) ; "Poor Rosella! Looks like you'll join the deer in the stew pot tonight!!"
				(= seconds 4)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance henPecked of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3
					view: 360
					posn: 225 130
					loop: 0
					show:
					setPri: 12
					ignoreActors: 1
					setCycle: Walk
					moveSpeed: 2
					cycleSpeed: 0
					setMotion: MoveTo 260 133 self
				)
			)
			(1
				(if (gCast contains: local3)
					(local3 loop: (+ (local3 loop:) 2) setCycle: End self)
				)
			)
			(2
				(if (gCast contains: local3)
					(local3
						setCycle: Walk
						setMotion:
							MoveTo
							(if (> (local3 x:) 238)
								(Random 214 230)
							else
								(Random 240 262)
							)
							133
							self
					)
				)
			)
			(3
				(= state 0)
				(self cue:)
			)
		)
	)
)

(instance chaseEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 49 51 #at -1 20 #draw) ; "Watch out! A VERY unfriendly bulldog rushes toward you!"
				(local4
					setAvoider: (Avoid new:)
					setCycle: Fwd
					ignoreActors: 1
					setMotion: Chase gEgo 15 self
				)
			)
			(1
				(User canInput: 0 canControl: 0)
				(gEgo dispose:)
				(local4 view: 87 loop: 0 setMotion: 0)
				(self cue:)
			)
			(2
				(local4 loop: 1 setCycle: Fwd)
				(= local8 6)
				(playMusic changeState: 0)
				(= seconds 3)
			)
			(3
				(local4 loop: 3 cycleSpeed: 2 setCycle: End)
				(= seconds 4)
			)
			(4
				((= local9 (Prop new:))
					view: 87
					loop: 4
					cel: 0
					setPri: 15
					posn: (- (local4 x:) 17) (- (local4 y:) 9)
					init:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(5
				(local9 dispose:)
				(Print 49 52 #draw #at -1 20) ; "You weren't fast enough, Rosella! You were nothing but a bite-sized morsel for that big dog!"
				(= gDeathFlag 1)
			)
		)
	)
)

(instance chewBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local4
					view: 350
					loop: 2
					ignoreActors: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(1
				(dogsPlace
					top: (local4 nsTop:)
					bottom: (+ (local4 nsBottom:) 1)
					left: (- (local4 nsLeft:) 1)
					right: (+ (local4 nsRight:) 1)
					init:
				)
				(gEgo observeBlocks: dogsPlace)
			)
		)
	)
)

(instance dogsPlace of Blk
	(properties)
)

(instance catchBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LookAt gEgo local4)
				((Sound new:) number: 63 loop: 1 play:)
				(gEgo view: 15 cycleSpeed: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(gEgo cel: 6 setCycle: End)
				((= local7 (Act new:))
					view: 541
					illegalBits: 0
					posn: (+ (gEgo x:) 3) (- (gEgo y:) 25)
					setLoop: 0
					setPri: 14
					setStep: 6 1
					setCycle: Fwd
					setMotion: MoveTo (- (local4 x:) 10) (- (local4 y:) 11) self
					init:
				)
			)
			(2
				(Print 49 53 #width 290 #at -1 20 #dispose) ; "Quickly, you toss the bone to the big dog who catches it in mid-air. Happy with his surprise gift, he takes it to his favorite rug, lies down, and begins to gnaw at it. He seems to have completely forgotten you."
				(gEgo view: 2 cycleSpeed: 0 setCycle: Walk)
				(local7 dispose:)
				(local4 view: 350 loop: 3 setCycle: End self)
			)
			(3
				(local4
					view: 352
					setLoop: (if (< (local4 x:) 155) 0 else 1)
					setCycle: Walk
					moveSpeed: 1
					setMotion: MoveTo 155 126 self
				)
			)
			(4
				(local4
					view: 350
					loop: 2
					ignoreActors: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 10)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(local4 setScript: chewBone)
			)
		)
	)
)

(instance doorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (client x:) 20) (+ (client y:) 9) self
				)
			)
			(1
				(LookAt gEgo client)
				(client setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) (+ (client y:) 2) self)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance ogreChaseMusic of Sound
	(properties
		number 5
		loop 0
		keep 1
	)
)

(instance ogreCatchMusic of Sound
	(properties
		number 6
		loop 0
		keep 1
	)
)

(instance ogressChaseMusic of Sound
	(properties
		number 10
		loop 0
		keep 1
	)
)

(instance ogressCatchMusic of Sound
	(properties
		number 11
		loop 0
		keep 1
	)
)

(instance playMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local8
					(5
						(ogreChaseMusic loop: 1 play: self)
					)
					(6
						(ogreCatchMusic loop: 1 play: self)
					)
					(10
						(ogressChaseMusic loop: 1 play: self)
					)
					(11
						(ogressCatchMusic loop: 1 play: self)
					)
				)
			)
			(1
				(if (or (== local8 5) (== local8 10))
					(= state -1)
					(self cue:)
				)
			)
		)
	)
)

(instance moveOnTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo setStep: 2 2)
				(gEgo illegalBits: 0)
				(if (> (gEgo y:) 100)
					(gEgo setMotion: MoveTo 194 61 self)
				else
					(gEgo setMotion: MoveTo 97 123 self)
				)
			)
			(2
				(HandsOn)
				(gEgo illegalBits: $8000)
				(gEgo setStep: 2 1)
				(= local10 0)
			)
		)
	)
)

