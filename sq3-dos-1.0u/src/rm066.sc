;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	rm066 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm066 of Rm
	(properties
		picture 66
		horizon 88
		north 60
		east 67
		south 69
	)

	(method (init &tmp [temp0 50] temp50)
		(User canInput: 1 canControl: 1)
		(self setRegions: 600) ; ortega
		(Load rsSOUND 33)
		(if global256
			(Load rsPIC 65)
			(Load rsVIEW 87)
			(Load rsSCRIPT 991)
			(= temp50 JumpTo)
		else
			(Load rsVIEW 90)
			(Load rsVIEW 95)
			(Load rsSOUND 78)
		)
		(super init:)
		(if global256
			(gCurRoom drawPic: 65)
		else
			(rock1 init: stopUpd:)
			(rock2 init: stopUpd:)
		)
		(switch gPrevRoomNum
			(60
				(gEgo
					posn:
						(if (> (gEgo x:) 159)
							159
						else
							(gEgo x:)
						)
						(+ (gCurRoom horizon:) 2)
					init:
				)
			)
			(61
				(gEgo posn: 240 (+ (gCurRoom horizon:) 2) init:)
			)
			(67
				(gEgo
					posn:
						317
						(if (< (gEgo y:) (gCurRoom horizon:))
							(+ (gCurRoom horizon:) 2)
						else
							(gEgo y:)
						)
					init:
				)
			)
			(69
				(gEgo posn: 169 187 init:)
				(if (and global256 (not global172))
					(self setScript: MyMy)
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (dispose)
		(if global256
			(DisposeScript 991)
		)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== (gCurRoom script:) 0)
			(switch (gEgo edgeHit:)
				(EDGE_TOP
					(if (< (gEgo x:) 159)
						(= newRoomNumber 60)
					else
						(= newRoomNumber 61)
					)
				)
				(EDGE_RIGHT
					(= newRoomNumber 67)
				)
				(EDGE_BOTTOM
					(= newRoomNumber 69)
				)
			)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0 [temp1 50])
		(super doit:)
		(if (== (gEgo view:) 95)
			(= local4
				(cond
					(
						(or
							(== (gEgo heading:) 315)
							(== (gEgo heading:) 0)
							(== (gEgo heading:) 45)
						)
						0
					)
					((or (== (gEgo heading:) 90) (== (gEgo heading:) 270)) 2)
					(
						(or
							(== (gEgo heading:) 135)
							(== (gEgo heading:) 180)
							(== (gEgo heading:) 225)
						)
						1
					)
				)
			)
			(if (!= local5 local4)
				(switch local4
					(0
						(gEgo setLoop: 1)
					)
					(1
						(gEgo setLoop: 0)
					)
					(2
						(gEgo setLoop: (if (== local5 0) 1 else 0))
					)
				)
			)
			(= local5 local4)
		)
		(if (not (gCurRoom script:))
			(cond
				((== (= temp0 (gEgo onControl:)) 3)
					(gEgo setPri: 3 posn: (gEgo x:) (+ (gEgo y:) 2))
					(= global180 1)
				)
				(
					(or
						(== temp0 5)
						(== temp0 7)
						(== temp0 69)
						(== temp0 133)
						(== temp0 197)
					)
					(gEgo setPri: 3 posn: (+ (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 9) (== temp0 13))
					(gEgo setPri: 5 posn: (gEgo x:) (- (gEgo y:) 2))
					(= global180 1)
				)
				((or (== temp0 17) (== temp0 49) (== temp0 273))
					(gEgo setPri: 7 posn: (gEgo x:) (+ (gEgo y:) 2))
					(= global180 1)
				)
				((or (== temp0 33) (== temp0 161))
					(gEgo setPri: 7 posn: (- (gEgo x:) 12) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 257) (== temp0 769))
					(gEgo setPri: 5 posn: (- (gEgo x:) 12) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 513) (== temp0 1537))
					(gEgo setPri: 5 posn: (- (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 2049) (== temp0 2065) (== temp0 2053))
					(gEgo setPri: 5 posn: (gEgo x:) (+ (gEgo y:) 2))
					(= global180 1)
				)
				((== temp0 1025)
					(gEgo
						setPri: 3
						posn: (- (gEgo x:) 6) (- (gEgo y:) 2)
					)
					(= global180 1)
				)
			)
		)
		(if (and global219 local6)
			(-- local6)
		)
		(if (== local6 1)
			(= local6 -1)
			(gCurRoom setScript: DeadMeat)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'leap,jump/canyon[<across,above]')
				(cond
					((not global256)
						(Print 66 0) ; "Why not just walk across?"
					)
					((gEgo has: 9) ; Metal_Pole
						(self setScript: PoleVault)
					)
					(else
						(Print 66 1) ; "I know you're quite a guy, but even you can't jump across such a wide crevice."
					)
				)
			)
			((Said 'pole/leap')
				(cond
					((not global256)
						(Print 66 0) ; "Why not just walk across?"
					)
					((gEgo has: 9) ; Metal_Pole
						(self setScript: PoleVault)
					)
					(else
						(Print 66 1) ; "I know you're quite a guy, but even you can't jump across such a wide crevice."
					)
				)
			)
			((Said 'use/pole')
				(cond
					((not global256)
						(Print 66 2) ; "You ponder the many uses of the metal pole, but just can't seem to figure out any way it could help you."
					)
					((gEgo has: 9) ; Metal_Pole
						(self setScript: PoleVault)
					)
					(else
						(DontHave) ; "You don't have it."
					)
				)
			)
			((Said 'drop/pole/canyon[<across,above]')
				(cond
					((not global256)
						(Print 66 3) ; "What for?"
					)
					((gEgo has: 9) ; Metal_Pole
						(Print 66 4) ; "The pole is too short to span the crevice."
					)
					(else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

(instance MyMy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 66 5) ; "My my, things have certainly changed since you were here last! That unstable rock has fallen into the simmering lava below."
				(= global172 1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance PoleVault of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(gEgo setMotion: MoveTo 229 206 self)
			)
			(1
				(gEgo
					view: 87
					setLoop: 0
					setCel: 0
					setMotion: 0
					setCycle: Fwd
				)
				(Print 66 6) ; "Your brow furrows in grim determination as you prepare for a tremendous leap."
				(= seconds 2)
			)
			(2
				(gEgo setMotion: MoveTo 195 172 self)
			)
			(3
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(pole init: setCycle: End)
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 177 152
					setCycle: 0
					setMotion: JumpTo 108 143 self
				)
			)
			(5
				(if (gEgo has: 10) ; Thermal_Detonator
					(HandsOff)
					(kaboom play:)
					(blast init: setCycle: End self)
					(gEgo dispose:)
				else
					(self changeState: 7)
				)
			)
			(6
				(Print 66 7) ; "The impact of your landing set off the thermal detonator.  Your fragments are strewn over a wide area."
				(EgoDead 0 0 16 20) ; "Didn't mom always tell you not to play with firecrackers?"
			)
			(7
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 98 133 self
				)
			)
			(8
				(pole dispose:)
				(gEgo put: 9) ; Metal_Pole
				(gGame changeScore: 20)
				(Print 66 8) ; "The Romanian judge gives you a 9.5! A truly outstanding jump by one of the finest young athletes we've seen this season.  You'd like to try that again, but your pole seems to have fallen into the tumultuous lava below."
				(HandsOn)
				(= global159 0)
				(client setScript: 0)
			)
		)
	)
)

(instance DeadMeat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(kaboom play:)
				(blast init: setCycle: End self)
				(gEgo dispose:)
			)
			(1
				(Print 66 9) ; "The impact switch on the thermal detonator was triggered by your wobbling on the unstable rock. Your fragments are strewn over a wide area."
				(EgoDead 0 0 16 20) ; "Didn't mom always tell you not to play with firecrackers?"
			)
		)
	)
)

(instance pole of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 87
			setLoop: 2
			setCel: 0
			setPri: (gEgo priority:)
			posn: 177 172
			ignoreActors:
		)
	)
)

(instance blast of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 87
			setLoop: 4
			setCel: 0
			setPri: (+ (gEgo priority:) 1)
			posn: (gEgo x:) (gEgo y:)
			ignoreActors:
		)
	)
)

(instance rock1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 1
			setCel: 0
			setPri: 6
			posn: 158 153
			ignoreActors:
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gEgo onControl: 1) 64) (not (gCurRoom script:)))
				(cond
					((not (gEgo mover:))
						(if (not local2)
							(= local2 1)
							(gEgo setCycle: Fwd)
						)
					)
					(local2
						(= local2 0)
						(gEgo setCycle: Walk)
					)
				)
				(if (not local0)
					(= local0 1)
					(quake play:)
					(self setCycle: Fwd)
					(gEgo view: 95 setStep: 1 1)
				)
			)
			(local0
				(= local0 0)
				(self setCel: 0 setCycle: 0 stopUpd:)
				(if (and (not local1) (not (gCurRoom script:)))
					(gEgo
						view: 0
						setStep: 3 2
						loop:
							(switch (gEgo heading:)
								(0 3)
								(45 0)
								(90 0)
								(135 0)
								(180 2)
								(225 1)
								(270 1)
								(315 1)
							)
					)
					(RedrawCast)
					(gEgo setLoop: -1)
				)
			)
		)
	)
)

(instance rock2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 2
			setCel: 0
			setPri: 6
			posn: 162 170
			ignoreActors:
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gEgo onControl: 1) 128) (not (gCurRoom script:)))
				(cond
					((not (gEgo mover:))
						(if (not local3)
							(= local3 1)
							(gEgo setCycle: Fwd)
						)
					)
					(local3
						(= local3 0)
						(gEgo setCycle: Walk)
					)
				)
				(if (not local1)
					(= local1 1)
					(quake play:)
					(self setCycle: Fwd)
					(gEgo view: 95 setStep: 1 1)
				)
				(if (and (gEgo has: 10) (not local6)) ; Thermal_Detonator
					(HandsOff)
					(= local6 2)
				)
			)
			(local1
				(= local1 0)
				(self setCel: 0 setCycle: 0 stopUpd:)
				(if (and (not local0) (not (gCurRoom script:)))
					(gEgo
						view: 0
						setStep: 3 2
						loop:
							(switch (gEgo heading:)
								(0 3)
								(45 0)
								(90 0)
								(135 0)
								(180 2)
								(225 1)
								(270 1)
								(315 1)
							)
					)
					(RedrawCast)
					(if (not global183)
						(Print 66 10) ; "It appears that parts of this planet's surface are not entirely stable. Better be careful or you'll end up in that lava fondue below."
						(= global183 1)
					)
					(gEgo setLoop: -1)
				)
			)
		)
	)
)

(instance kaboom of Sound
	(properties
		number 33
		priority 3
	)
)

(instance quake of Sound
	(properties
		number 78
		priority 2
	)
)

