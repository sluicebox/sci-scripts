;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room77 0
)

(local
	local0
	local1
	[local2 22]
	local24
	local25
	local26
)

(instance Room77 of Rm
	(properties
		picture 77
	)

	(method (init)
		(= east 78)
		(= west 73)
		(= horizon 40)
		(= gIndoors 0)
		(Load rsVIEW 21)
		(Load rsVIEW 69)
		(Load rsVIEW 49)
		(Load rsSCRIPT 991)
		(if gNight
			(= picture 177)
		)
		(super init:)
		(self setRegions: 513) ; swampReg
		(= local25 (Prop new:))
		(= local26 (Prop new:))
		(local25
			isExtra: 1
			view: 650
			loop: 2
			cel: 1
			posn: 241 145
			setPri: 0
			setCycle: Fwd
			init:
		)
		(local26
			isExtra: 1
			view: 650
			loop: 4
			cel: 0
			posn: 275 112
			setPri: 0
			setCycle: Fwd
			init:
		)
		(switch gPrevRoomNum
			(east
				(gEgo view: 2 posn: 301 161 loop: 1)
				(= local0 10)
				(= local1 20)
				(= global105 12)
				(User canControl: 1 canInput: 1)
			)
			(west
				(gEgo
					view: 49
					setLoop: 2
					cel: 0
					posn: 32 160
					setCycle: Fwd
					setScript: egoCrawlOut
				)
			)
			(else
				(gEgo
					view: 49
					setLoop: 2
					cel: 0
					posn: 32 160
					setCycle: Walk
					setScript: egoCrawlOut
				)
			)
		)
		(gEgo init:)
		(gEgo edgeHit: 0)
		(= [local2 0] 94)
		(= [local2 1] 167)
		(= [local2 2] 113)
		(= [local2 3] 164)
		(= [local2 4] 135)
		(= [local2 5] 162)
		(= [local2 6] 159)
		(= [local2 7] 165)
		(= [local2 8] 186)
		(= [local2 9] 161)
		(= [local2 10] 206)
		(= [local2 11] 165)
		(= [local2 12] 225)
		(= [local2 13] 161)
		(= [local2 14] 244)
		(= [local2 15] 166)
		(= [local2 16] 264)
		(= [local2 17] 163)
		(= [local2 18] 285)
		(= [local2 19] 167)
		(= [local2 20] 301)
		(= [local2 21] 162)
		(gCurRoom setScript: jump)
		(= global205 1)
	)

	(method (doit)
		(super doit:)
		(if
			(or
				(== (gEgo view:) 5)
				(== (gEgo view:) 6)
				(== (gEgo view:) 7)
			)
			(= local0 0)
			(= local1 0)
		)
		(if
			(and
				(& (gEgo onControl: 0) $4000)
				(== (gEgo view:) 2)
				(== (gEgo script:) 0)
				(< (gEgo heading:) 285)
				(> (gEgo heading:) 255)
			)
			(gEgo setScript: egoCrawlIn)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look/room')
						(Said 'look/around')
						(Said 'look/marsh')
						(Said 'look[<around][/!*]')
					)
					(Print 77 0) ; "From here, a huge muddy swamp spreads eastward. Large moss-covered swamp trees tower overhead, while grass tufts and reedy plants poke up from the mire. You can hear the many chirpings and croakings of unseen swamp creatures."
				)
				((Said 'look<in/cave')
					(Print 77 1) ; "It sure is dark in there!"
				)
				((Said 'look/cave')
					(Print 77 2) ; "A small cave leads into the mountain."
				)
				((Said 'crawl/')
					(if (gEgo inRect: 40 154 63 170)
						(gEgo setScript: egoCrawlIn)
					else
						(Print 77 3) ; "You're not close enough."
					)
				)
				((Said 'hop,hop')
					(jump changeState: 1)
				)
			)
		)
	)
)

(instance egoCrawlOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 0)
				(gEgo xStep: 1 setMotion: MoveTo 68 161 self)
			)
			(1
				(gEgo setLoop: 0 cel: 5 setCycle: Beg self)
			)
			(2
				(gEgo view: 21 setLoop: 0 cel: 6 setCycle: Beg self)
			)
			(3
				(gEgo view: 2 xStep: 3 yStep: 2 setLoop: -1 setCycle: Walk)
				(HandsOn)
				(gEgo setScript: 0)
				(= global105 12)
			)
		)
	)
)

(instance egoCrawlIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid)
				(gEgo setMotion: MoveTo 57 162 self)
			)
			(1
				(= global105 0)
				(gEgo view: 21 setLoop: 1 cel: 255 setCycle: End self)
			)
			(2
				(gEgo view: 49 setLoop: 1 cel: 255 setCycle: End self)
			)
			(3
				(gEgo
					setLoop: 3
					setCycle: Walk
					xStep: 1
					setMotion: MoveTo 32 161 self
				)
			)
			(4
				(HandsOn)
				(gEgo
					illegalBits: -32768
					setAvoider: 0
					xStep: 3
					yStep: 2
					setLoop: -1
					setScript: 0
				)
				(= global205 1)
				(gCurRoom newRoom: 73)
			)
		)
	)
)

(instance jump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (== global105 13)
					(Print 77 4) ; "Just Move."
					(self changeState: 0)
				else
					(if (and (== local0 10) (== (gEgo loop:) 0))
						(HandsOn)
						(= global205 1)
						(gCurRoom newRoom: 78)
						(return)
					)
					(if (== local0 0)
						(if
							(or
								(not (gEgo inRect: 87 161 106 172))
								(!= (gEgo loop:) 0)
								(!= (gEgo view:) 2)
							)
							(jump changeState: 10)
						else
							(= local24 (gEgo viewer:))
							(gEgo viewer: 0)
							(HandsOff)
							(gEgo view: 69 cel: 255 setCycle: End self)
						)
					else
						(= local24 (gEgo viewer:))
						(gEgo viewer: 0)
						(HandsOff)
						(gEgo view: 69 cel: 255 setCycle: End self)
					)
				)
			)
			(2
				(gEgo setCycle: CT 1 -1 self)
			)
			(3
				(gEgo xStep: 6 yStep: 4)
				(cond
					((== (gEgo loop:) 0)
						(gEgo setLoop: 2 cel: 255 setCycle: End)
						(++ local0)
						(+= local1 2)
						(gEgo
							setMotion:
								JumpTo
								[local2 local1]
								[local2 (+ local1 1)]
								self
						)
					)
					((== (gEgo loop:) 1)
						(gEgo setLoop: 3 cel: 255 setCycle: End)
						(-- local0)
						(-= local1 2)
						(gEgo
							setMotion:
								JumpTo
								[local2 local1]
								[local2 (+ local1 1)]
								self
						)
					)
					((== (gEgo loop:) 2)
						(gEgo viewer: local24)
						(gEgo
							setMotion:
								JumpTo
								(gEgo x:)
								(+ (gEgo y:) 6)
								self
						)
					)
					((== (gEgo loop:) 3)
						(gEgo viewer: local24)
						(gEgo
							setMotion:
								JumpTo
								(gEgo x:)
								(- (gEgo y:) 6)
								self
						)
					)
				)
			)
			(4
				(if
					(and
						(!= (gEgo onControl: 1) 1024)
						(!= (gEgo onControl: 1) 1)
					)
					(gEgo
						setLoop: -1
						viewer: local24
						setCycle: Walk
						setStep: 3 2
					)
					(HandsOn)
					(return)
				)
				(if (== (gEgo loop:) 2)
					(gEgo cel: -1 setLoop: -1 loop: 4 setCycle: End self)
				else
					(gEgo cel: -1 setLoop: -1 loop: 5 setCycle: End self)
				)
			)
			(5
				(if (== (gEgo loop:) 4)
					(gEgo view: 2 loop: 0 cel: 0 xStep: 3 yStep: 2)
				else
					(gEgo view: 2 loop: 1 cel: 0 xStep: 3 yStep: 2)
				)
				(HandsOn)
				(gEgo viewer: local24)
				(gEgo view: 2 setCycle: Walk)
			)
			(10
				(Print 77 5) ; "Not from here!"
			)
		)
	)
)

