;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use RFeature)
(use Path)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room23 0
)

(synonyms
	(lamp ignite)
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 7] = [222 130 186 137 193 142 -32768]
	[local12 5] = [222 149 193 142 -32768]
	[local17 7] = [222 130 186 137 210 147 -32768]
	[local24 5] = [222 149 201 147 -32768]
	local29
)

(instance Room23 of Rm
	(properties
		picture 23
	)

	(method (init)
		(= south 29)
		(= west 22)
		(= east 24)
		(= north 12)
		(= horizon 86)
		(super init:)
		(gAddToPics add: Well eachElementDo: #init doit:)
		(self setRegions: 206 setFeatures: Well House) ; houseOReg
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(Load rsSCRIPT 985)
		(Load rsPIC 70)
		(LoadMany rsVIEW 51 55 170)
		(LoadMany rsSOUND 82 120)
		(Thunder number: 17 loop: 0)
		(mySound number: 82 loop: 0)
		(Bucket init: setPri: 10 stopUpd:)
		(Windlass init: setPri: 10 stopUpd:)
		(WHandle init: setPri: 10 stopUpd:)
		(BigBucket ignoreActors: 1 init: hide:)
		(Splash cycleSpeed: 1 setPri: 10 init: stopUpd: hide:)
		(if gDetailLevel
			(Light1 setPri: 9 init: setScript: showers)
			(Light2 setPri: 9 init:)
		)
		(if
			(and
				(>= gAct 3)
				(not (& gCorpseFlags $0004)) ; Gloria
				(!= global122 24)
				(!= global122 gCurRoomNum)
			)
			(switch (Random 1 2)
				(1
					(= global122 gCurRoomNum)
				)
				(2
					(= global122 24)
				)
			)
		)
		(if (and (== gAct 3) (< gJeevesChoresState 7))
			(self setRegions: 203) ; clarwand
			(= global122 24)
		)
		(switch gPrevRoomNum
			(29
				(gEgo posn: 126 188)
			)
			(18
				(gEgo posn: 186 133)
			)
			(22
				(if (> (gEgo y:) 150)
					(gEgo posn: 1 170)
				)
			)
			(17
				(gEgo posn: 70 135)
			)
			(12
				(gEgo posn: 70 135)
			)
			(24
				(if (and (< (gEgo y:) 163) (> (gEgo y:) 156))
					(gEgo posn: 318 165)
				)
			)
		)
		(gEgo illegalBits: -32768 view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 23 0) ; "You are standing at the east side of the circular gravel driveway leading to the old plantation house."
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 12)
		)
		(if (& (gEgo onControl: 0) $0004)
			(gCurRoom newRoom: 18)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 985)
		(DisposeScript 973)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if local4
			(|= gCorpseFlags $0004) ; Gloria
			(= global122 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/body,actress>')
					(cond
						((!= global122 gCurRoomNum)
							(event claimed: 1)
							(Print 23 1) ; "You don't see anybody here."
						)
						((Said 'lift')
							(cond
								(local1
									(Print 23 2) ; "It is already up."
								)
								((Windlass cycler:)
									(Print 23 3) ; "You'll have to wait until the handle stops turning."
								)
								(else
									(self setScript: raiseBucket)
								)
							)
						)
						((Said 'lower,unwind')
							(if (not local1)
								(Print 23 4) ; "It is already down."
							else
								(= local0 1)
							)
						)
						((Said 'kill')
							(Print 23 5) ; "She's already dead!"
						)
						((Said 'kiss')
							(Print 23 6) ; "Ugh!!"
						)
						((Said 'embrace')
							(Print 23 7) ; "Yuck!!"
						)
						((Said 'search,get,pull,pull,press,move,(look<in)')
							(Print 23 8) ; "You can't do that unless you get some help!"
						)
						((Said 'look')
							(Print 23 9) ; "It appears that Gloria was strangled with her own feather boa!"
						)
						((Said 'help')
							(Print 23 10) ; "You can do nothing for her now."
						)
					)
				)
				((and (== global122 gCurRoomNum) (Said 'look/boa'))
					(Print 23 11) ; "The feathers are a bit soggy."
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 23 0) ; "You are standing at the east side of the circular gravel driveway leading to the old plantation house."
						)
						((Said '/path')
							(Print 23 12) ; "A stone path leads toward the middle of the circular driveway."
						)
						((Said '<(in,down,in)/well')
							(if (and local1 (== global122 gCurRoomNum))
								(Print 23 13) ; "Gloria's body blocks any view into the depths of the well."
							else
								(WHandle setScript: lookInWell)
							)
						)
						((Said '<in/doghouse')
							(NotClose) ; "You're not close enough."
						)
						((Said '/hemp')
							(Print 23 14) ; "There is a rope attached to the bucket in the well."
						)
						((Said '/(door<basement),basement')
							(Print 23 15) ; "You notice the cellar door outside the kitchen."
						)
						((Said '/door,lamp')
							(Print 23 16) ; "A porch light illuminates the kitchen door."
						)
						((Said '/monument')
							(Print 23 17) ; "You can barely see it from here."
						)
						(
							(or
								(Said 'look/doghouse')
								(Said 'look/cabin<beauregard')
							)
							(Print 23 18) ; "You see a doghouse by the kitchen door."
						)
					)
				)
				((Said 'get/hemp')
					(Print 23 19) ; "The rope belongs to the well."
				)
				((Said 'get/control')
					(Print 23 20) ; "It is firmly attached to the well."
				)
				((Said 'open/(door[<basement]),basement')
					(NotClose) ; "You're not close enough."
				)
				((Said 'cut,untie/hemp,bucket')
					(Print 23 21) ; "The rope is securely attached to the bucket. You can't take either."
				)
				((and (== local2 1) (Said 'drop/control,handle,bucket'))
					(= local2 0)
				)
				((Said 'wind,rotate/control,handle,hemp')
					(cond
						(local1
							(= local0 1)
						)
						((Windlass cycler:)
							(Print 23 3) ; "You'll have to wait until the handle stops turning."
						)
						(else
							(self setScript: raiseBucket)
						)
					)
				)
				((Said 'enter,climb/well,bucket')
					(Print 23 22) ; "You're brighter than THAT, Laura!"
				)
				((and local1 local2 (Said 'let,release/go,handle,control'))
					(gEgo x: (- (gEgo x:)) heading: 180)
				)
			)
		)
	)
)

(instance raiseBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: (Avoid new:))
				(cond
					((gEgo inRect: 222 115 320 139)
						(gEgo setMotion: TopPath self)
					)
					((gEgo inRect: 222 139 320 158)
						(gEgo setMotion: BotPath self)
					)
					(else
						(gEgo setMotion: MoveTo 193 142 self)
					)
				)
				(= local2 1)
			)
			(1
				(wellCage init:)
				(gEgo setAvoider: 0 observeBlocks: wellCage hide:)
				(myMusic loop: -1 play:)
				(WHandle view: 51 loop: 2 cel: 0 posn: 193 142 cycleSpeed: 1)
				(Windlass cycleSpeed: 1 setCycle: Fwd)
				(= local3 0)
				(= cycles 1)
			)
			(2
				(WHandle setCycle: End self)
			)
			(3
				(if (!= (++ local3) 5)
					(= state 1)
				)
				(= cycles 1)
			)
			(4
				(Bucket
					loop: (if (== global122 gCurRoomNum) 5 else 4)
					cel: 0
					cycleSpeed: 4
					setCycle: End
				)
				(WHandle setCycle: End self)
			)
			(5
				(myMusic stop:)
				(if (not local1)
					(= local1 1)
					(HandsOn)
				)
				(if
					(and
						(== global122 gCurRoomNum)
						(not (& gCorpseFlags $0040)) ; Lillian
						(not local4)
					)
					(mySound number: 120 loop: 1 play:)
					(= local4 1)
					(Print 23 23 #at 10 20 #icon 363 2 0 #mode 1) ; "Gadzooks! Entangled in the rope is Gloria's lifeless body, her feather boa tightly knotted around her neck!"
				)
				(Windlass setCycle: 0)
				(cond
					(local0
						(HandsOff)
						(= local1 (= local0 0))
						(WHandle setScript: lowerBucket)
						(= state 9)
						(= cycles 1)
					)
					((and local2 (== (gEgo x:) 193) (== (gEgo y:) 142))
						(= state 4)
						(= cycles 1)
					)
					(else
						(= local1 0)
						(gEgo
							loop: 2
							posn: 193 142
							ignoreBlocks: wellCage
							show:
							setCycle: Walk
						)
						(myMusic loop: -1 play:)
						(if local2
							(DirLoop gEgo (gEgo heading:))
						)
						(WHandle
							view: 123
							loop: 6
							cel: 0
							posn: 207 109
							cycleSpeed: 0
							setCycle: End self
						)
						(Windlass cycleSpeed: 0 setCycle: Fwd)
						(Bucket cycleSpeed: 0 setCycle: Beg)
						(= local3 0)
					)
				)
			)
			(6
				(Bucket loop: 7 cel: 1 stopUpd:)
				(WHandle cel: 0 setCycle: End self)
			)
			(7
				(if (!= (++ local3) 5)
					(= state 5)
				)
				(= cycles 1)
			)
			(8
				(Windlass setCycle: 0)
				(WHandle cel: 0 stopUpd:)
				(myMusic stop:)
				(if (== global122 gCurRoomNum)
					(= seconds 2)
				else
					(= state 9)
					(mySound number: 82 play:)
					(= cycles 1)
				)
			)
			(9
				(mySound number: 82 play:)
				(Splash setCycle: End self show:)
			)
			(10
				(Splash cel: 0 hide:)
				(= local2 0)
				(client setScript: 0)
			)
		)
	)
)

(instance lowerBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Windlass cycleSpeed: 1 setCycle: Fwd)
				(Bucket setCycle: Beg self)
				(WHandle setCycle: Rev)
				(myMusic loop: -1 play:)
				(= local3 0)
			)
			(1
				(Bucket loop: 7 cel: 1 stopUpd:)
				(= cycles 1)
			)
			(2
				(WHandle setCycle: Beg self)
			)
			(3
				(if (!= (++ local3) 5)
					(= state 1)
				)
				(= cycles 1)
			)
			(4
				(myMusic stop:)
				(Windlass setCycle: 0)
				(gEgo
					loop: 2
					posn: 193 142
					ignoreBlocks: wellCage
					show:
					setCycle: Walk
				)
				(WHandle view: 123 loop: 6 cel: 0 posn: 207 109 stopUpd:)
				(HandsOn)
				(= local2 0)
				(client setScript: 0)
			)
		)
	)
)

(instance lookInWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(local1
						(= cycles 1)
					)
					((gEgo inRect: 222 115 320 139)
						(gEgo
							setAvoider: (Avoid new:)
							setMotion: TopLPath self
						)
					)
					((gEgo inRect: 222 139 320 158)
						(gEgo
							setAvoider: (Avoid new:)
							setMotion: BotLPath self
						)
					)
					(else
						(gEgo
							setAvoider: (Avoid new:)
							setMotion: MoveTo 211 147 self
						)
					)
				)
			)
			(1
				(if local1
					(= cycles 1)
				else
					(gEgo view: 55 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(gCast eachElementDo: #hide)
				(if local1
					(BigBucket show:)
				)
				(DrawPic 70 7)
				(if local29
					(if local1
						(Print 23 24 #at 160 132 #width 140) ; "The leaky, oaken bucket barely holds water."
					else
						(NotHere) ; "You don't see it here."
					)
				else
					(Print 23 25 #at 160 132 #width 140) ; "You look into the well, but as it's deep and dark, you can't see much."
				)
				(= cycles 1)
			)
			(3
				(= local29 0)
				(cls)
				(DrawPic gCurRoomNum 6)
				(gAddToPics doit:)
				(gCast eachElementDo: #show)
				(Splash hide:)
				(BigBucket hide:)
				(HandsOn)
				(if local1
					(gEgo posn: 193 142 observeBlocks: wellCage hide:)
					(= cycles 1)
				else
					(gEgo setAvoider: 0 setCycle: Beg self)
				)
			)
			(4
				(if (not local1)
					(gEgo view: 0 setCycle: Walk)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= state 3))
			)
			(1
				(Light1 setCycle: Fwd)
				(Light2 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(Light1 setCycle: End)
				(Light2 setCycle: End self)
			)
			(3
				(Thunder loop: 1 play: self)
			)
			(4
				(if (< (Random 1 100) 25)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance Well of RPicView
	(properties
		y 144
		x 223
		view 123
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<at]/well'))
			(event claimed: 1)
			(Print 23 26) ; "There is an old, deep well just off the driveway."
		)
	)
)

(instance BigBucket of Prop
	(properties
		y 114
		x 154
		view 170
	)
)

(instance WHandle of Prop
	(properties
		y 109
		x 207
		view 123
		loop 6
	)
)

(instance Windlass of Prop
	(properties
		y 113
		x 218
		view 123
		loop 3
	)
)

(instance Bucket of Prop
	(properties
		y 113
		x 223
		view 123
		loop 7
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'look/control')
				(if (gEgo has: 20) ; crank
					(event claimed: 0)
				else
					(Print 23 27) ; "You can use the crank to raise the bucket."
				)
			)
			((Said 'enter,(go,hop,climb,get,sit)<in/bucket,well')
				(Print 23 28) ; "What? Are you crazy?!"
			)
			((Said 'look<in/bucket')
				(if (and local1 (== global122 gCurRoomNum))
					(Print 23 13) ; "Gloria's body blocks any view into the depths of the well."
				else
					(= local29 1)
					(Bucket setScript: lookInWell)
				)
			)
			((Said 'lift/bucket,hemp')
				(cond
					(local1
						(Print 23 2) ; "It is already up."
					)
					((Windlass cycler:)
						(Print 23 3) ; "You'll have to wait until the handle stops turning."
					)
					(else
						(Room23 setScript: raiseBucket)
					)
				)
			)
			((Said 'lower,unwind/bucket,hemp')
				(if (not local1)
					(Print 23 4) ; "It is already down."
				else
					(= local0 1)
				)
			)
			((Said 'get/bucket')
				(Print 23 29) ; "The bucket belongs to the well."
			)
			((or (MousedOn self event 3) (Said 'look/bucket'))
				(event claimed: 1)
				(cond
					((not local1)
						(NotHere) ; "You don't see it here."
					)
					((== global122 gCurRoomNum)
						(Print 23 30) ; "The bucket is hidden from view by Gloria's dripping form."
					)
					(else
						(Print 23 24) ; "The leaky, oaken bucket barely holds water."
					)
				)
			)
		)
	)
)

(instance Splash of Prop
	(properties
		y 124
		x 223
		view 123
		loop 8
	)
)

(instance Light1 of Prop
	(properties
		y 13
		x 261
		view 123
		cel 1
	)
)

(instance Light2 of Prop
	(properties
		y 18
		x 251
		view 123
		loop 1
		cel 1
	)
)

(instance House of RFeature
	(properties
		nsTop 6
		nsBottom 98
		nsRight 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {house})
		)
	)
)

(instance Thunder of Sound
	(properties)
)

(instance mySound of Sound
	(properties)
)

(instance myMusic of Sound
	(properties
		number 37
		priority 5
	)
)

(instance TopPath of Path
	(properties)

	(method (at param1)
		(return [local5 param1])
	)
)

(instance BotPath of Path
	(properties)

	(method (at param1)
		(return [local12 param1])
	)
)

(instance TopLPath of Path
	(properties)

	(method (at param1)
		(return [local17 param1])
	)
)

(instance BotLPath of Path
	(properties)

	(method (at param1)
		(return [local24 param1])
	)
)

(instance wellCage of Cage
	(properties
		top 125
		left 150
		bottom 160
		right 235
	)
)

