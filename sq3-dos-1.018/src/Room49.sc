;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room49 0
)

(local
	local0
	local1
)

(instance Room49 of Rm
	(properties
		picture 49
	)

	(method (init)
		(= east 50)
		(= west 52)
		(= north 45)
		(= south 53)
		(= horizon 72)
		(= global109 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(Load rsVIEW 63)
		(super init:)
		(lightning init:)
		(gEgo init:)
		(NormalEgo)
		(= global104 0)
		(switch gPrevRoomNum
			(50
				(cond
					((< (gEgo y:) 94)
						(gEgo view: 0 posn: 318 (gEgo y:))
					)
					((== global104 0)
						(gEgo view: 63 posn: 317 (gEgo y:))
					)
				)
			)
			(45
				(NormalEgo)
				(gEgo view: 63 posn: (gEgo x:) (+ horizon 2))
			)
			(52
				(switch global104
					(0
						(gEgo posn: 1 (gEgo y:) view: 63 setPri: -1)
					)
					(1
						(NormalEgo)
						(gEgo posn: 1 80 view: 0)
					)
					(2
						(NormalEgo)
						(gEgo posn: 1 80 view: 0)
					)
				)
			)
			(53
				(NormalEgo)
				(HandsOn)
				(gEgo view: 0 posn: (gEgo x:) 188)
			)
			(40
				(NormalEgo)
				(= global100 0)
				(HandsOn)
				(gEgo view: 63 posn: 184 174 loop: 2 init:)
			)
			(14
				(gEgo view: 63)
				(gCurRoom setScript: Actions)
				(gLongSong owner: -1 number: 22 priority: 1 loop: -1 play:)
				(= global100 1)
			)
			(else
				(gEgo view: 63 posn: 160 187 init:)
			)
		)
		(cond
			(
				(and
					(!= gHandsOff 1)
					(!= gPrevRoomNum 45)
					(gEgo inRect: -5 0 324 94)
					(!= (gCurRoom script:) termCatch)
				)
				(gEgo view: 0)
			)
			((!= (gCurRoom script:) termCatch)
				(gEgo view: 63)
			)
		)
		(self setRegions: 501) ; regDune
	)

	(method (newRoom newRoomNumber)
		(NormalEgo)
		(DisposeScript 988)
		(if (== newRoomNumber 14)
			(gLongSong fade:)
		)
		(if (or (not gHandsOff) (== newRoomNumber 40))
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if
			(and
				(or (== global110 1) (== global110 2))
				(not (gCast contains: global111))
				(& (gEgo onControl: 1) $0004)
			)
			(gCurRoom setScript: termCatch)
		)
		(if
			(and
				(& (gEgo onControl:) $4000)
				(== script 0)
				(not (gCast contains: global111))
			)
			(gCurRoom newRoom: 14)
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
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 49 0) ; "Your ship is resting on a sandy spot between several large rocks. It looks like your automated landing system has done a remarkable job."
						)
						((Said '/craft,aluminum,aluminum')
							(Print 49 1) ; "You proudly look upon your newly acquired spacecraft, the Aluminum Mallard. Truly a fine piece of jun...uh.. machinery."
						)
					)
				)
				((Said 'enter/craft')
					(Print 49 2) ; "Your feet will take you wherever you want to go in most cases."
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 157 143 setMotion: MoveTo 184 174 self)
			)
			(1
				(Print 49 3) ; "As you step out of your ship onto the surface of Phleebhut, you are hit in the face by the harsh winds. It looks like a storm is brewing."
				(RedrawCast)
				(if (== global118 0)
					(= global118 1)
					(Print 49 4 #dispose) ; "Meanwhile...another spacecraft touches down elsewhere on the very same planet."
					(= seconds 5)
				else
					(HandsOn)
				)
			)
			(2
				(cls)
				(gCurRoom newRoom: 40)
			)
		)
	)

	(method (doit)
		(super doit:)
	)
)

(instance flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance termCatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global111 (Act new:))
				(global111
					view: 106
					setPri: (gEgo priority:)
					observeControl: 16384
					setLoop: 8
					setCycle: Fwd
					init:
				)
				(global111 posn: (gEgo x:) (gEgo y:))
				(= local1 (Sound new:))
				(local1 number: 97 loop: -1 priority: 99 play:)
				(gEgo illegalBits: 0 ignoreActors: hide:)
				(= seconds 7)
			)
			(1
				(local1 stop:)
				(EgoDead 901 0 14 16)
			)
		)
	)
)

(instance lightning of Prop
	(properties
		y 54
		x 48
		view 69
		loop 4
	)

	(method (init)
		(super init:)
		(self setScript: flash)
	)
)

(instance thunder of Sound
	(properties)
)

