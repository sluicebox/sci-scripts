;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room57 0
)

(synonyms
	(diamond bag)
	(skeleton bone)
	(room crypt)
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
	local14
	local15
)

(procedure (localproc_0 &tmp [temp0 250])
	(if (== gTombBarred 1)
		(Printf 57 33 57 34 @temp0) ; "You have entered a cold, dark tomb. From moonlight shining in through a stained-glass window, you can make out four vaults in the wall and a stone sarcophagus on the floor. Each vault has a nameplate above it. %s"
	else
		(Printf 57 33 57 35 @temp0) ; "You have entered a cold, dark tomb. From moonlight shining in through a stained-glass window, you can make out four vaults in the wall and a stone sarcophagus on the floor. Each vault has a nameplate above it. %s"
	)
)

(procedure (localproc_1 &tmp [temp0 50])
	(switch local0
		(4
			(if (gEgo has: 22) ; pouch
				(Print 57 24) ; "You look inside the open vault, but find it empty."
			else
				(Print 57 25) ; "Nervously, you peek into the open vault and see..."
				(Print 57 26) ; "...a leather pouch!"
			)
		)
		(8
			(Printf 57 36 57 37 @temp0) ; "Trembling, you peer into the open vault. %s"
		)
		(else
			(Printf 57 36 57 38 @temp0) ; "Trembling, you peer into the open vault. %s"
		)
	)
)

(procedure (localproc_2)
	(lantern view: 27 loop: 3 cel: 0 posn: 157 77 setPri: 7 stopUpd: init:)
	((gInventory at: 2) moveTo: gCurRoomNum) ; lantern
)

(instance Room57 of Rm
	(properties
		picture 57
	)

	(method (init)
		(= horizon 0)
		(super init:)
		(gAddToPics add: skeleton casket skeletons doit:)
		(self setFeatures: Box Window1 Window2)
		(LoadMany rsVIEW 27 28 29 30)
		(LoadMany rsSCRIPT 985 991)
		(LoadMany rsSOUND 60 71 122 123 124)
		(if (== gPrevRoomNum 2)
			(= local13 1)
			(gEgo view: 0 posn: 43 148 init:)
		)
		(lid view: 157 loop: 0 posn: 228 84 setPri: 8 ignoreActors: 1 init:)
		(if (== ((gInventory at: 2) owner:) gCurRoomNum) ; lantern
			(localproc_2)
		)
		(if (not (gEgo has: 22)) ; pouch
			(pouch setPri: 1 stopUpd: init:)
		)
		(marysCover view: 157 loop: 2 ignoreActors: 1 stopUpd: init:)
		(if (& global169 $0002)
			(marysCover cel: (- (NumCels marysCover) 1) posn: 32 87)
		else
			(marysCover loop: 1 cel: 0 posn: 46 87)
		)
		(rubysCover view: 157 loop: 2 ignoreActors: 1 stopUpd: init:)
		(if (& global169 $0004)
			(rubysCover cel: (- (NumCels rubysCover) 1) posn: 116 69)
		else
			(rubysCover loop: 1 cel: 1 posn: 130 70)
		)
		(tomsCover view: 157 loop: 3 ignoreActors: 1 stopUpd: init:)
		(if (& global169 $0008)
			(tomsCover cel: (- (NumCels tomsCover) 1) posn: 192 71)
		else
			(tomsCover loop: 1 cel: 2 posn: 177 71)
		)
		(claudesCover view: 157 loop: 3 ignoreActors: 1 stopUpd: init:)
		(if (& global169 $0010)
			(claudesCover cel: (- (NumCels claudesCover) 1) posn: 281 91)
		else
			(claudesCover loop: 1 cel: 3 posn: 266 91)
		)
		(skull view: 157 illegalBits: 0 ignoreActors: 1 priority: 1)
		(if (& global169 $0200)
			(skull loop: 6)
			(skull cel: (- (NumCels skull) 1) posn: 75 117)
		else
			(skull setLoop: 5 cel: 0 posn: 53 79)
		)
		(skull stopUpd: init:)
		(if (IsFirstTimeInRoom)
			(= local14 1)
			(myMusic number: 71 loop: 1 play:)
			(lid cel: 0 cycleSpeed: 4 setCycle: End self)
		else
			(gEgo init:)
			(lid cel: (- (NumCels lid) 1) stopUpd:)
			(if (!= gPrevRoomNum 2)
				(self setScript: GettingOut)
			)
		)
	)

	(method (doit)
		(cond
			((== gTombBarred 1)
				(if (& (gEgo onControl: 1) $0200)
					(gCurRoom newRoom: 2)
				)
			)
			((& (gEgo onControl: 1) $0200)
				(if (not local12)
					(= local12 1)
					(Print 57 0) ; "The tomb door is barred shut."
				)
			)
			(else
				(= local12 0)
			)
		)
		(if (and (& (gEgo onControl: 1) $0020) local13)
			(cond
				(global137
					(self setScript: GettingIn)
				)
				((not local15)
					(= local15 1)
					(Print 57 1) ; "I wouldn't go down there without you lantern lit."
				)
			)
		)
		(if (& (gEgo onControl: 1) $0001)
			(= local15 0)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '(look<in),get,open/casket>')
					(if (& global169 $0008)
						(Print 57 2) ; "Have respect for the dead, Laura!"
					else
						(NotHere) ; "You don't see it here."
					)
					(event claimed: 1)
				)
				((or (Said 'latch,bar/*') (Said 'lower/bar'))
					(Print 57 3) ; "There's no reason to do that."
				)
				(
					(and
						(not (gEgo has: 7)) ; crowbar
						(or
							(Said '*/crowbar')
							(Said '*/*/crowbar')
							(Said '*<use<crowbar')
						)
					)
					(DontHave) ; "You don't have it."
				)
				((or (Said 'look,read/nameplate') (Said 'read/vault'))
					(cond
						((& (gEgo onControl: 0) $0002)
							(Print 57 4) ; "The nameplate reads, "Mary Frances Crouton.""
						)
						((& (gEgo onControl: 0) $0004)
							(Print 57 5) ; "The nameplate reads, "Ruby Crouton.""
						)
						((& (gEgo onControl: 0) $0008)
							(Print 57 6) ; "The nameplate reads, "Thomas S. Crouton.""
						)
						((& (gEgo onControl: 0) $0010)
							(Print 57 7) ; "The nameplate reads, "Claude Crouton.""
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				(
					(or
						(Said '/vault,(door<vault)>')
						(and (Said '/door>') (Said '/vault>'))
						(Said '//vault,(door<vault)>')
						(and (Said '//door>') (Said '//vault>'))
					)
					(for ((= local0 2)) (<= local0 16) ((<<= local0 $0001))
						(if (& (gEgo onControl: 1) local0)
							(= temp0 2)
							(if global219
								(if (not global224)
									(return)
								)
								(= temp0 (!= global171 7))
							)
							(cond
								((Said 'look>')
									(if (not (& global169 local0))
										(Print 57 8) ; "The vault door is sealed shut. Above the door is an engraved nameplate."
										(event claimed: 1)
										(break)
									)
									(if (Said '<in')
										(localproc_1)
										(break)
									)
									(Print 57 9) ; "The vault is open."
									(event claimed: 1)
									(break)
								)
								(
									(or
										(Said '(break,force)[<(open,up)]//cane')
										(Said '(break,lift,force)<use<cane')
										(Said 'open//cane')
									)
									(if (gEgo has: 21) ; cane
										(Print 57 10) ; "The cane isn't strong enough."
										(break)
									)
									(DontHave) ; "You don't have it."
									(break)
								)
								(
									(or
										(Said
											'(break,force)[<(open,up)]//poker'
										)
										(Said '(break,lift,force)<use<poker')
										(Said 'open//poker')
									)
									(if (gEgo has: 6) ; poker
										(Print 57 11) ; "The poker won't fit under the cover."
										(break)
									)
									(DontHave) ; "You don't have it."
									(break)
								)
								(
									(and
										(!= temp0 1)
										(not (& global169 local0))
										(or
											(Said
												'(break,force)[<(open,up)]//crowbar'
											)
											(Said
												'(break,lift,force)<use<crowbar'
											)
											(Said 'open//crowbar')
											(Said 'open<use<crowbar')
										)
									)
									(if (gEgo has: 7) ; crowbar
										(self setScript: OpenVault)
										(break)
									)
									(Print 57 12) ; "You're not strong enough to do that!"
									(break)
								)
								((Said 'break,force,open')
									(if (& global169 local0)
										(AlreadyOpen) ; "It is already open."
										(break)
									)
									(if (not (& global169 (<< local0 $0008)))
										(Print 57 13) ; "The vault door is sealed shut. You can't open it with your bare hands."
										(break)
									)
									(self setScript: OpenVault)
									(break)
								)
								((Said 'close')
									(if (not (& global169 local0))
										(AlreadyClosed) ; "It is already closed."
										(break)
									)
									(gEgo illegalBits: 0)
									(self setScript: CloseVault)
									(break)
								)
								((Said 'unbar')
									(if (not (& global169 local0))
										(Print 57 14) ; "The vault door isn't locked; it's sealed."
										(break)
									)
									(AlreadyOpen) ; "It is already open."
									(break)
								)
							)
						)
					)
					(if (> local0 16)
						(NotClose) ; "You're not close enough."
						(event claimed: 1)
					)
				)
				(
					(or
						(Said '/bar,door[<room]>')
						(and (Said '/door>') (Said '/room>'))
					)
					(cond
						((Said 'look')
							(if (== gTombBarred 0)
								(Print 57 0) ; "The tomb door is barred shut."
							else
								(Print 57 15) ; "The door is now unbarred."
							)
						)
						((Said 'open')
							(if (== gTombBarred 0)
								(Print 57 0) ; "The tomb door is barred shut."
							else
								(Print 57 15) ; "The door is now unbarred."
							)
						)
						((Said 'unbar,unbar,detach,lift,lift,move')
							(if
								(or
									(& (gEgo onControl: 0) $0200)
									(& (gEgo onControl: 0) $0040)
								)
								(if (== gTombBarred 0)
									(= gTombBarred 1)
									(Print 57 16) ; "You grab the bar holding the door shut and carefully raise it. Now the door is free."
								else
									(Print 57 17) ; "The door is unbarred."
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(localproc_0)
						)
						((Said '/stair')
							(Print 57 18) ; "The stairs lead down into total darkness."
						)
						((Said '/wall')
							(Print 57 19) ; "You see four vaults in the wall. Each vault has a nameplate above it."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 57 20) ; "The stone floor is cold and hard."
						)
						((or (Said '/ceiling') (Said '<up'))
							(Print 57 21) ; "There is nothing special on the tomb ceiling."
						)
						((Said '/frances,(crouton<frances)')
							(cond
								((not (& global169 $0002))
									(Print 57 22) ; "You can't do that! The vault door is not open!"
								)
								((not (& (gEgo onControl: 1) $0002))
									(NotClose) ; "You're not close enough."
								)
								(else
									(Print 57 23) ; "What a revolting sight! You want nothing to do with that old skeleton!"
								)
							)
						)
						((Said '/s,(crouton<s)')
							(cond
								((not (& global169 $0008))
									(Print 57 22) ; "You can't do that! The vault door is not open!"
								)
								((not (& (gEgo onControl: 1) $0008))
									(NotClose) ; "You're not close enough."
								)
								(else
									(Print 57 23) ; "What a revolting sight! You want nothing to do with that old skeleton!"
								)
							)
						)
						((Said '/claude,(crouton<claude)')
							(cond
								((not (& global169 $0010))
									(Print 57 22) ; "You can't do that! The vault door is not open!"
								)
								((not (& (gEgo onControl: 1) $0010))
									(NotClose) ; "You're not close enough."
								)
								(else
									(Print 57 23) ; "What a revolting sight! You want nothing to do with that old skeleton!"
								)
							)
						)
						((Said '/ruby,(crouton<ruby)')
							(cond
								((not (& global169 $0004))
									(Print 57 22) ; "You can't do that! The vault door is not open!"
								)
								((not (& (gEgo onControl: 1) $0004))
									(NotClose) ; "You're not close enough."
								)
								((gEgo has: 22) ; pouch
									(Print 57 24) ; "You look inside the open vault, but find it empty."
								)
								(else
									(Print 57 25) ; "Nervously, you peek into the open vault and see..."
									(myMusic number: 60 loop: 1 play:)
									(Print 57 26) ; "...a leather pouch!"
								)
							)
						)
						((Said '/skeleton,casket>')
							(for
								((= local0 2))
								(<= local0 16)
								((<<= local0 $0001))
								
								(if
									(and
										(& (gEgo onControl: 1) local0)
										(& global169 local0)
									)
									(if (== local0 4)
										(NotHere) ; "You don't see it here."
										(break)
									)
									(if (Said '/skeleton')
										(if (== local0 8)
											(NotHere) ; "You don't see it here."
											(break)
										)
										(Print 57 23) ; "What a revolting sight! You want nothing to do with that old skeleton!"
										(break)
									)
									(if (!= local0 8)
										(NotHere) ; "You don't see it here."
										(break)
									)
									(Print 57 27) ; "The badly deteriorated casket is riddled with worm holes."
									(break)
								)
							)
							(if (> local0 16)
								(if global169
									(if
										(or
											(and
												(Said '/skeleton')
												(& global169 $0012)
											)
											(and
												(Said '/casket')
												(& global169 $0008)
											)
										)
										(NotClose) ; "You're not close enough."
									else
										(NotHere) ; "You don't see it here."
									)
								else
									(NotHere) ; "You don't see it here."
								)
							)
							(event claimed: 1)
						)
					)
				)
				((Said '(move,get)>')
					(cond
						((Said '/skeleton,casket>')
							(if
								(or
									(and (Said '/skeleton') (& global169 $0012))
									(and (Said '/casket') (& global169 $0008))
								)
								(Print 57 2) ; "Have respect for the dead, Laura!"
							else
								(NotHere) ; "You don't see it here."
								(event claimed: 1)
							)
						)
						((Said '/lantern')
							(if (gEgo has: 2) ; lantern
								(AlreadyTook) ; "You already took it."
							else
								(HandsOff)
								(gEgo
									setAvoider: (Avoid new:)
									setMotion: MoveTo 144 112 self
								)
							)
						)
					)
				)
				((Said 'open/window')
					(Print 57 28) ; "The windows don't open."
				)
				((Said 'break/window')
					(Print 57 29) ; "That wouldn't be very nice!"
				)
				((Said '(close,cover)>')
					(if
						(or
							(Said '/sarcophagus,(lid<sarcophagus)')
							(and (Said '/lid>') (Said '/sarcophagus'))
						)
						(Print 57 30) ; "There's no need to do that."
					)
				)
				((Said 'extinguish,extinguish,(rotate<off)')
					(Print 57 31) ; "You best keep it lit in case a cloud passes in front of the moon."
				)
			)
		)
	)

	(method (cue)
		(if (gEgo has: 2) ; lantern
			(lid stopUpd:)
			(gEgo init:)
			(self setScript: GettingOut)
		else
			(lantern hide:)
			(gEgo loop: 0 setAvoider: 0)
			((gInventory at: 2) moveTo: gEgo) ; lantern
			(HandsOn)
		)
	)
)

(instance OpenVault of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (& global169 $0200))
				(== state 4)
				(== (marysCover cel:) 1)
				(== (skull script:) 0)
			)
			(skull setScript: RollSkull)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 2)
				(= local1 local0)
				(if (not (& global169 local1))
					(HandsOff)
					(if (not (& global169 (<< local1 $0008)))
						(Print 57 32 #at 90 110 #mode 1) ; "You insert the crowbar into the small opening between the vault door and the tomb wall. You then pull with all your might! With a loud CRACK, the door pops open."
						(= local2 10)
					else
						(Ok) ; "Okay."
						(= local2 3)
					)
					(switch local1
						(2
							(= local3 78)
							(= local4 108)
							(= local5 0)
							(= local10 marysCover)
						)
						(4
							(= local3 99)
							(= local4 103)
							(= local5 1)
							(= local10 rubysCover)
						)
						(8
							(= local3 209)
							(= local4 104)
							(= local5 0)
							(= local10 tomsCover)
						)
						(16
							(= local3 234)
							(= local4 111)
							(= local5 1)
							(= local10 claudesCover)
						)
					)
					(gEgo
						illegalBits: 0
						setMotion: MoveTo local3 local4 self
					)
				else
					(AlreadyOpen) ; "It is already open."
					(client setScript: 0)
				)
			)
			(1
				(gEgo view: 29 loop: local5 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: (+ local5 2) cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: (+ local5 4) cel: 0 setCycle: Fwd)
				(= cycles local2)
			)
			(4
				(switch local1
					(2
						(local10 loop: 2 posn: 32 87)
					)
					(4
						(local10 loop: 2 posn: 116 69)
					)
					(8
						(local10 loop: 3 posn: 192 71)
					)
					(16
						(local10 loop: 3 posn: 281 91)
					)
				)
				(local10 cel: 0 setCycle: End)
				(myMusic number: 123 loop: 1 play:)
				(gEgo loop: (+ local5 2))
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(5
				(gEgo loop: 0)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(6
				(gEgo
					view: 0
					loop: 2
					cel: 6
					setCycle: Walk
					illegalBits: -32768
				)
				(|= global169 (| (<< local1 $0008) local1))
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance CloseVault of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== state 2)
			(cond
				((and (> (= temp0 (gEgo cel:)) 2) (< temp0 6))
					(local10 cel: (- 5 temp0))
				)
				((== temp0 6)
					(switch local1
						(2
							(= local6 46)
							(= local7 87)
							(= local9 0)
						)
						(4
							(= local6 130)
							(= local7 70)
							(= local9 1)
						)
						(8
							(= local6 177)
							(= local7 71)
							(= local9 2)
						)
						(16
							(= local6 266)
							(= local7 91)
							(= local9 3)
						)
					)
					(local10 loop: 1 cel: local9 posn: local6 local7)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& global169 local0)
					(HandsOff)
					(= local1 local0)
					(&= global169 (~ local0))
					(Ok) ; "Okay."
					(switch local1
						(2
							(= local6 53)
							(= local7 115)
							(= local8 0)
							(= local10 marysCover)
							(= local11 15)
						)
						(4
							(= local6 146)
							(= local7 99)
							(= local8 0)
							(= local10 rubysCover)
							(= local11 15)
						)
						(8
							(= local6 169)
							(= local7 100)
							(= local8 1)
							(= local10 tomsCover)
							(= local11 -15)
						)
						(16
							(= local6 260)
							(= local7 121)
							(= local8 1)
							(= local10 claudesCover)
							(= local11 -15)
						)
					)
					(gEgo setMotion: MoveTo local6 local7 self)
				else
					(gEgo illegalBits: -32768)
					(AlreadyClosed) ; "It is already closed."
					(client setScript: 0)
				)
			)
			(1
				(gEgo view: 0 loop: 3 cel: 0)
				(= cycles 1)
			)
			(2
				(gEgo view: 30 loop: local8 cel: 0 setCycle: End self)
				(myMusic number: 123 loop: 1 play:)
			)
			(3
				(gEgo
					view: 0
					loop: 2
					cel: 6
					posn: (+ (gEgo x:) local11) (+ (gEgo y:) 3)
					setCycle: Walk
					illegalBits: -32768
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance RollSkull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(skull
					startUpd:
					setPri: 15
					setStep: 6 4
					setCycle: Fwd
					moveSpeed: 0
					cycleSpeed: 0
					setMotion: MoveTo 75 117 self
				)
			)
			(1
				(myMusic number: 122 loop: 1 play:)
				(skull setMotion: JumpTo 90 117 self)
			)
			(2
				(myMusic number: 124 loop: 1 play:)
				(skull loop: 6 cel: 0 setPri: -1 setCycle: End self)
			)
			(3
				(skull stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance GettingIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 109 self)
			)
			(1
				(gEgo
					view: 28
					loop: 0
					cel: 0
					posn: 176 107
					setPri: 8
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo view: 27 posn: 167 81)
				(if (gEgo has: 2) ; lantern
					(self cue:)
				else
					(gEgo loop: 0 cycleSpeed: 1)
					(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
					(gEgo get: 2) ; lantern
					(lantern hide:)
				)
			)
			(3
				(gEgo loop: 4 cycleSpeed: 2)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(4
				(gEgo
					setPri: -1
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance GettingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(HandsOff)
				(gEgo
					view: 27
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 167 81
					setPri: 8
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 0 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gEgo view: 28 loop: 0 posn: 176 107 cycleSpeed: 2)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
				(localproc_2)
			)
			(3
				(gEgo
					view: 0
					loop: 3
					cel: 0
					posn: 176 109
					setPri: -1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 155 124 self
				)
			)
			(4
				(gEgo illegalBits: -32768)
				(HandsOn)
				(if local14
					(localproc_0)
				)
				(= local13 1)
				(= local14 0)
				(client setScript: 0)
			)
		)
	)
)

(instance lid of Prop
	(properties)
)

(instance marysCover of Prop
	(properties)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 57 4) ; "The nameplate reads, "Mary Frances Crouton.""
		)
	)
)

(instance rubysCover of Prop
	(properties)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 57 5) ; "The nameplate reads, "Ruby Crouton.""
		)
	)
)

(instance tomsCover of Prop
	(properties)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 57 6) ; "The nameplate reads, "Thomas S. Crouton.""
		)
	)
)

(instance claudesCover of Prop
	(properties)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 57 7) ; "The nameplate reads, "Claude Crouton.""
		)
	)
)

(instance pouch of Prop
	(properties
		y 63
		x 124
		view 157
		loop 4
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/diamond')
				(cond
					((& (gEgo onControl: 0) $0004)
						(= global182 1)
						(gEgo get: 22) ; pouch
						(pouch dispose:)
						(Print 57 39) ; "You remove the leather pouch from the vault and take it with you."
					)
					((& global169 $0004)
						(NotClose) ; "You're not close enough."
					)
					(else
						(NotHere) ; "You don't see it here."
					)
				)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(Print 57 26) ; "...a leather pouch!"
			)
		)
	)
)

(instance lantern of Prop
	(properties)
)

(instance skull of Act
	(properties)
)

(instance skeleton of PV
	(properties
		y 81
		x 40
		view 157
		loop 4
		priority 1
	)
)

(instance casket of PV
	(properties
		y 66
		x 182
		view 157
		loop 4
		cel 2
		priority 1
	)
)

(instance skeletons of PV
	(properties
		y 87
		x 272
		view 157
		loop 4
		cel 3
		priority 1
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 13
		nsLeft 72
		nsBottom 59
		nsRight 105
	)

	(method (handleEvent event)
		(if
			(or
				(Said 'look/window')
				(Said 'look/glass<stained')
				(MousedOn self event 3)
			)
			(Print 57 40) ; "Those are lovely stained glass windows!"
			(event claimed: 1)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 12
		nsLeft 203
		nsBottom 61
		nsRight 240
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 57 40) ; "Those are lovely stained glass windows!"
			(event claimed: 1)
		)
	)
)

(instance Box of RFeature
	(properties
		nsTop 75
		nsLeft 153
		nsBottom 119
		nsRight 28
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/sarcophagus'))
			(Print 57 41) ; "The sarcophagus appears to be empty. All you see are a set of stairs going downward."
			(event claimed: 1)
		)
	)
)

(instance myMusic of Sound
	(properties)
)

