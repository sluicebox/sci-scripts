;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use HighLite)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room52 0
)

(synonyms
	(body body actress c gertie ethel fifi attorney butler)
	(rotate wind)
	(detach loosen)
	(room basement)
)

(local
	[local0 16] = [70 151 187 161 187 161 70 151 70 151 208 111 208 111 70 151]
	local16
	local17
	local18
	local19
	local20
	local21
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 90 55 #draw #dispose)
)

(instance Room52 of Rm
	(properties
		picture 52
	)

	(method (init)
		(= horizon 0)
		(super init:)
		(gAddToPics add: rags tub eachElementDo: #init doit:)
		(|= gCorpseFlags $003f) ; Everyone but Lillian
		(self
			setRegions: 242 ; tunnelReg
			setFeatures:
				rags
				tub
				WallPlate
				Chute
				Bricks1
				Bricks2
				Bricks3
				Bricks4
				Bricks5
				Walls
				Beams
				Floor1
				Floor2
		)
		(LoadMany rsVIEW 51 924)
		(LoadMany rsSOUND 45 84 126)
		(if gDetailLevel
			(Splash1 ignoreActors: 1 setPri: 3 init: hide:)
			(Splash2 ignoreActors: 1 setPri: 3 init: hide:)
		)
		(rat
			setStep: 5 5
			setScript: Scurry
			setCycle: Walk
			ignoreActors: 1
			init:
			hide:
		)
		(bodies setPri: 14 init: stopUpd:)
		(drip setPri: 3 cycleSpeed: 1 setScript: Drip init:)
		(panelCrank setPri: 8 init:)
		(if (== ((gInventory at: 20) owner:) gCurRoomNum) ; crank
			(panelCrank stopUpd:)
			(gEgo observeBlocks: cBlock)
		else
			(panelCrank hide:)
		)
		(door setPri: 4 init: stopUpd:)
		(if (& global205 $0001)
			(door cel: (- (NumCels door) 1))
		else
			(door cel: 0)
			(gEgo illegalBits: -32764)
		)
		(if (== global189 51)
			(gEgo setPri: 3 posn: 195 63)
		else
			(gEgo posn: 69 103)
		)
		(gEgo view: 7 init:)
		(glow deltaX: 8 deltaY: 8 ignoreCast: 1 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 52 0) ; "It appears that you've discovered an old, sealed-off portion of the basement! You notice some outdated laundry paraphernalia in the form of a laundry chute, a wash tub, and a broken-down wringer. You can barely make out a pile of... something... underneath the chute."
		)
		(if
			(and
				(& (gEgo onControl: 0) $0040)
				(!= (gEgo mover:) 0)
				gDetailLevel
			)
			(switch (gEgo loop:)
				(2
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(3
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(else
					(if (== (gEgo cel:) 0)
						(Splash1
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(cond
			((and (& global205 $0002) (bodies cel:))
				(= local20 1)
			)
			(
				(and
					(== (bodies cel:) (- (NumCels bodies) 1))
					(not (& global205 $0002))
				)
				(soundFX number: 53 loop: 1 play:)
				(= global213 25)
				(Say 0 52 1) ; ""EEEEEEEEEKKKK!!!" A pile of dead bodies!!"
				(Print 52 2) ; "Someone has cruelly dumped the bodies of Gertie, Wilbur, Gloria, Ethel, Fifi, Jeeves, and Clarence down the old laundry chute!!"
				(|= global205 $0002)
				(= gEthelState 101)
			)
			(else
				(= local20 0)
			)
		)
		(switch (gEgo onControl: 1)
			(2
				(gEgo illegalBits: -32768)
				(= global189 51)
				(gCurRoom newRoom: 55)
			)
			(4
				(= global189 52)
				(gCurRoom newRoom: 55)
			)
			(2048
				(bodies cel: 1 forceUpd:)
			)
			(4096
				(bodies cel: 2 forceUpd:)
			)
			(8192
				(bodies cel: 3 forceUpd:)
			)
			(16384
				(bodies cel: 4 forceUpd:)
			)
			(1
				(bodies cel: 0 forceUpd:)
			)
			(16
				(bodies cel: 0 forceUpd:)
			)
		)
		(if (< (gEgo y:) 66)
			(gEgo setPri: 3)
		else
			(gEgo setPri: -1)
		)
		(if
			(or
				(< (gEgo y:) 66)
				(and (& global205 $0001) (& (gEgo onControl:) $0014))
			)
			(glow show:)
		else
			(glow hide:)
		)
		(cond
			((< (gEgo x:) 110)
				(= vertAngle 30)
			)
			((< (gEgo x:) 160)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 150)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 214)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(drip setScript: 0)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 [temp1 250])
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((gEgo has: 20) ; crank
					(cond
						((Said 'attach/control')
							(= local19 1)
						)
						(
							(and
								(Said '/panel,door>')
								(or
									(Said 'open<control')
									(Said 'open//control')
								)
							)
							(= local19 3)
						)
					)
				)
				((== ((gInventory at: 20) owner:) gCurRoomNum) ; crank
					(cond
						((Said 'attach/control')
							(Print 52 3) ; "You already did that."
						)
						((Said 'rotate/control,handle')
							(= local19 2)
						)
						((Said 'open/panel,door')
							(if (& global205 $0001)
								(AlreadyOpen) ; "It is already open."
							else
								(Print 52 4) ; "You must turn the crank to do that."
							)
						)
						((Said 'get,detach,pull/control')
							(= local19 4)
						)
						((Said 'look/control')
							(Print (Format @temp1 52 5 52 6) #icon 624 0 1) ; "%s The crank has been inserted into the hole in the middle of the metal plate."
						)
					)
				)
				((and (not (Said 'look/control>')) (Said '*/control'))
					(DontHave) ; "You don't have it."
				)
			)
			(if (not (event claimed:))
				(cond
					((Said 'attach/control')
						(Print 52 7) ; "It won't fit."
					)
					((Said 'close/panel,door')
						(if (& global205 $0001)
							(Print 52 4) ; "You must turn the crank to do that."
						else
							(AlreadyClosed) ; "It is already closed."
						)
					)
					((Said 'look>')
						(cond
							((Said '[<around,at][/room]')
								(if (not (& global205 $0002))
									(Print 52 0) ; "It appears that you've discovered an old, sealed-off portion of the basement! You notice some outdated laundry paraphernalia in the form of a laundry chute, a wash tub, and a broken-down wringer. You can barely make out a pile of... something... underneath the chute."
								else
									(Print 52 8) ; "This area of the basement has been sealed-off. You notice some out-dated laundry paraphernalia in the form of a laundry chute, a wash tub, and a broken-down wringer. Horribly, someone has dumped the bodies of Gertie, Wilbur, Gloria, Ethel, Fifi, Jeeves, and Clarence down the old chute!"
								)
							)
							((or (Said 'look/dirt') (Said 'look<down'))
								(Print 52 9) ; "Damp stones cover the basement's floor."
							)
							((or (Said 'look/ceiling') (Said 'look<up'))
								(Print 52 10) ; "Old pipes and rafters cross the basement's ceiling."
							)
							((Said '/brick,(wall<brick)')
								(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
							)
							((Said '/passage')
								(if (& global205 $0001)
									(Print 52 12) ; "There are TWO underground passages leading off in opposite directions!"
								else
									(Print 52 13) ; "An underground passage leads back the way you came."
								)
							)
							((Said '/water,mud')
								(Print 52 14) ; "Puddles of water dampen the basement floor."
							)
						)
					)
					(
						(or
							(Said 'get,detach,find/brick[<loose][/wall]')
							(Said 'break/wall[<brick]')
						)
						(Print 52 15) ; "None of the bricks are loose. The brick walls are solidly built."
					)
					((Said 'search,get,detach,move/body[/pile[<from]]')
						(if (& global205 $0002)
							(Print 52 16) ; "You don't even want to go near them!"
						else
							(NotHere) ; "You don't see it here."
						)
					)
				)
			)
			(if (and local19 (not local17))
				(panelCrank setScript: CrankIt)
			)
		)
	)
)

(instance Drip of Script
	(properties)

	(method (doit)
		(if (and (== (drip cel:) 5) (== (soundFX state:) 0))
			(soundFX number: (+ 35 (* 10 (Random 0 1))) loop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(drip setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance Scurry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 18))
			)
			(1
				(= local16 (* (Random 0 3) 4))
				(rat
					setLoop:
						(if (< [local0 local16] [local0 (+ local16 2)])
							2
						else
							3
						)
					posn: [local0 local16] [local0 (++ local16)]
					setMotion:
						MoveTo
						[local0 (++ local16)]
						[local0 (++ local16)]
						self
					show:
				)
				(soundFX
					number: (if (== (rat loop:) 2) 84 else 58)
					loop: -1
					play:
				)
			)
			(2
				(rat hide:)
				(soundFX fade:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance CrankIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 40 124 70 160)
					(= cycles 1)
				else
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 85 120 self
					)
				)
				(= local17 1)
			)
			(1
				(gEgo setMotion: MoveTo 57 126 self)
			)
			(2
				(crankCage init:)
				(gEgo loop: 3 setAvoider: 0 observeBlocks: crankCage hide:)
				(panelCrank
					view: 51
					loop: 0
					cel: 0
					posn: 57 126
					cycleSpeed: 1
					show:
				)
				(HandsOn)
				(= cycles 2)
			)
			(3
				(cond
					((or (== local19 1) (== local19 3))
						(gEgo observeBlocks: cBlock)
						(Print 52 17 #at 90 55) ; "With some effort, you are able to insert the crank into the hole of the small metal plate. It fits perfectly!"
						((gInventory at: 20) moveTo: gCurRoomNum) ; crank
						(if (== local19 1)
							(= local19 0)
						else
							(= state 4)
						)
					)
					((== local19 2)
						(if (not (& global205 $0001))
							(= state 4)
						else
							(Print 52 18 #at 90 55) ; "Try as you might, you can't make the crank budge."
							(= state 6)
						)
					)
					((== local19 4)
						(Print 52 18 #at 90 55) ; "Try as you might, you can't make the crank budge."
						(= state 6)
					)
				)
				(= cycles 1)
			)
			(4
				(if (and local17 (== (gEgo x:) 57) (== (gEgo y:) 126))
					(= state 2)
				else
					(= state 6)
				)
				(= cycles 1)
			)
			(5
				(HandsOff)
				(Print 52 19 #at 90 55) ; "As you slowly turn the crank, a secret panel opens to another passage!"
				(soundFX number: 126 loop: 1 play:)
				(door cycleSpeed: 2 setCycle: End self)
				(panelCrank setCycle: Fwd)
			)
			(6
				(panelCrank setCycle: End self)
				(|= global205 $0001)
			)
			(7
				(cls)
				(User controls: 1 canInput: 1)
				(panelCrank view: 152 loop: 2 cel: 2 posn: 67 90)
				(gEgo
					setLoop: -1
					posn: 57 126
					ignoreBlocks: crankCage
					observeBlocks: cBlock
					illegalBits: -32768
					show:
					setCycle: Walk
				)
				(= local19 (= local17 0))
				(client setScript: 0)
			)
		)
	)
)

(instance WallPlate of RFeature
	(properties
		nsTop 86
		nsLeft 55
		nsBottom 91
		nsRight 58
	)

	(method (handleEvent event &tmp [temp0 75])
		(if (or (MousedOn self event 3) (Said 'look/nameplate'))
			(event claimed: 1)
			(if (== ((gInventory at: 20) owner:) gCurRoomNum) ; crank
				(Print (Format @temp0 52 5 52 6) #icon 624 0 1) ; "%s The crank has been inserted into the hole in the middle of the metal plate."
			else
				(Print (Format @temp0 52 20 52 6) #icon 624 0 0) ; "%s There is a hole in the middle of the metal plate."
			)
		)
		(cond
			((or (Said 'use/key') (Said 'attach/key') (Said 'unbar/nameplate'))
				(if (or (gEgo has: 5) (gEgo has: 18)) ; skeleton_key, brass_key
					(Print 52 21) ; "A key will not fit the hole in the metal plate."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'attach/poker')
				(if (gEgo has: 6) ; poker
					(Print 52 22) ; "It won't fit the hole in the metal plate."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'attach/crowbar')
				(if (gEgo has: 7) ; crowbar
					(Print 52 22) ; "It won't fit the hole in the metal plate."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'attach/key')
				(if (or (gEgo has: 18) (gEgo has: 5)) ; brass_key, skeleton_key
					(Print 52 22) ; "It won't fit the hole in the metal plate."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'force/nameplate')
				(if (gEgo has: 7) ; crowbar
					(Print 52 23) ; "It can't be pried."
				else
					(DontHave) ; "You don't have it."
				)
			)
		)
	)
)

(instance Chute of RFeature
	(properties
		nsTop 71
		nsLeft 34
		nsBottom 104
		nsRight 54
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look[<up]/chute[<laundry]'))
				(event claimed: 1)
				(Print 52 24) ; "The laundry chute appears to come down from the old plantation house right above you."
			)
			((Said '(enter,go,get,climb)[<(up,in)]/chute[<laundry]')
				(Print 52 25) ; "It's too high and too vertical. You could never climb up it."
			)
		)
	)
)

(instance Bricks1 of RFeature
	(properties
		nsTop 105
		nsLeft 34
		nsBottom 126
		nsRight 42
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
		)
	)
)

(instance Bricks2 of RFeature
	(properties
		nsTop 49
		nsLeft 58
		nsBottom 109
		nsRight 73
	)

	(method (handleEvent event)
		(cond
			((MousedOn self event 3)
				(event claimed: 1)
				(if (& global205 $0001)
					(Print 52 26) ; "You've found a secret panel in the basement wall."
				else
					(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
				)
			)
			((Said 'look/door,panel[<hidden,hidden]')
				(if (& global205 $0001)
					(Print 52 26) ; "You've found a secret panel in the basement wall."
				else
					(NotHere) ; "You don't see it here."
				)
			)
			((and (& global205 $0001) (Said 'look/archway[<hidden,hidden]'))
				(Print 52 26) ; "You've found a secret panel in the basement wall."
			)
		)
	)
)

(instance Bricks3 of RFeature
	(properties
		nsTop 49
		nsLeft 82
		nsBottom 64
		nsRight 89
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
		)
	)
)

(instance Bricks4 of RFeature
	(properties
		nsTop 15
		nsLeft 81
		nsBottom 34
		nsRight 87
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
		)
	)
)

(instance Bricks5 of RFeature
	(properties
		nsTop 49
		nsLeft 211
		nsBottom 60
		nsRight 221
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 52 11) ; "You notice that the old archways in each wall have been bricked up."
		)
	)
)

(instance Walls of RFeature
	(properties
		nsLeft 96
		nsBottom 35
		nsRight 202
	)

	(method (handleEvent event)
		(cond
			((MousedOn self event 3)
				(event claimed: 1)
				(Print 52 27) ; "These are bare earthen walls."
			)
			((Said 'look/wall')
				(if (& global205 $0001)
					(Print 52 28) ; "One wall is completely bricked up. But the opposite wall has an open archway in it."
				else
					(Print 52 29) ; "It looks as if two opposite walls have been bricked up. On the left wall next to one bricked-up portion, you notice a small, metal plate."
				)
			)
		)
	)
)

(instance Beams of RFeature
	(properties
		nsTop 36
		nsBottom 48
		nsRight 237
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/beam'))
			(event claimed: 1)
			(Print 52 30) ; "Old, rotted beams support this dank basement."
		)
	)
)

(instance Floor1 of RFeature
	(properties
		nsTop 50
		nsLeft 96
		nsBottom 73
		nsRight 200
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 52 31) ; "There is nothing but dirt on the ground."
		)
	)
)

(instance Floor2 of RFeature
	(properties
		nsTop 74
		nsLeft 75
		nsBottom 137
		nsRight 180
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {floor})
		)
	)
)

(instance rags of RPicView
	(properties
		y 164
		x 203
		view 152
		loop 2
		cel 1
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {equipment})
			)
			((Said 'scrub/cloth')
				(Print 52 32) ; "In a situation like this that's all you can think of!!"
			)
			((Said 'get/cloth')
				(Print 52 33) ; "You don't need these rags!"
			)
			((Said 'look/cloth')
				(Print 52 34) ; "These are just old rags."
			)
		)
	)
)

(instance tub of RPicView
	(properties
		y 166
		x 188
		view 152
		loop 2
		priority 14
	)

	(method (handleEvent event)
		(cond
			((Said 'rotate,look/bath,equipment[<laundry,scrub]')
				(Print 52 35) ; "It's just old laundry equipment. There is nothing of importance here."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {equipment})
			)
		)
	)
)

(instance door of Prop
	(properties
		y 49
		x 60
		view 152
		signal 16384
	)
)

(instance bodies of Prop
	(properties
		y 148
		x 69
		view 152
		loop 3
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (Said '/body,pile>') (Said '/pile/body[<dead]>'))
				(if (Said '(look<in),search,get')
					(if (or local20 (& global205 $0002))
						(Print 52 16) ; "You don't even want to go near them!"
					else
						(NotHere) ; "You don't see it here."
					)
				)
				(if (Said 'look[<at]')
					(if local20
						(Print 52 36) ; "A pile of dead bodies lies at the bottom of the old laundry chute. The sight sickens you."
					else
						(Print 52 37) ; "Look in the corner."
					)
				)
			)
			((and local20 (MousedOn self event 3))
				(event claimed: 1)
				(Print 52 36) ; "A pile of dead bodies lies at the bottom of the old laundry chute. The sight sickens you."
			)
		)
	)
)

(instance panelCrank of Prop
	(properties
		y 90
		x 67
		view 152
		loop 2
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(if (and (not local17) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {crank})
		)
	)
)

(instance soundFX of Sound
	(properties
		number 53
	)
)

(instance drip of Prop
	(properties
		y 63
		x 117
		view 152
		loop 1
		signal 16384
	)
)

(instance rat of Act
	(properties
		view 151
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((Said '/mouse>')
				(cond
					((Said 'look')
						(if (rat mover:)
							(Print 52 38) ; "Seeing the small, furry shape scurrying across the floor causes your skin to crawl!"
						else
							(NotHere) ; "You don't see it here."
						)
					)
					((Said 'get,capture')
						(if (rat mover:)
							(Print 52 39) ; "What a revolting thought!"
						else
							(NotHere) ; "You don't see it here."
						)
					)
					((Said 'kill')
						(if (rat mover:)
							(Print 52 40) ; "Don't worry about the rats."
						else
							(NotHere) ; "You don't see it here."
						)
					)
				)
			)
			((and (rat mover:) (MousedOn self event 3))
				(event claimed: 1)
				(Print 52 38) ; "Seeing the small, furry shape scurrying across the floor causes your skin to crawl!"
			)
		)
	)
)

(instance glow of HighLite
	(properties)
)

(instance Splash1 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Splash2 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance cBlock of Blk
	(properties
		top 117
		left 54
		bottom 119
		right 63
	)
)

(instance crankCage of Cage
	(properties
		top 120
		left 42
		bottom 142
		right 80
	)
)

