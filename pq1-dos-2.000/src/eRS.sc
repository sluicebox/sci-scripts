;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 896)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use PolyPath)
(use Game)
(use User)
(use Actor)
(use System)

(public
	eRS 0
	sWI 1
	sWO 2
	sRW 3
	sonny 4
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(cond
		((< (gEgo x:) 0)
			(gEgo x: (+ 0 (* (gEgo xStep:) 2)))
		)
		((> (gEgo x:) 319)
			(gEgo x: (- 319 (* (gEgo xStep:) 2)))
		)
	)
)

(procedure (localproc_1)
	(cond
		((< (gEgo y:) (gCurRoom horizon:))
			(gEgo y: (+ (gCurRoom horizon:) (* (gEgo yStep:) 2)))
		)
		((> (gEgo y:) 189)
			(gEgo y: (- 189 (* (gEgo yStep:) 2)))
		)
	)
)

(class PQRoom of Rm
	(properties
		style 10
		x 0
		y 0
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
	)

	(method (init &tmp [temp0 2])
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
			(else
				(self setScript: eRS 0 gPrevRoomNum)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(HandsOff)
				(if (== temp0 -1)
					(self setScript: sRW 0 ((User alterEgo:) edgeHit:))
				else
					(self setScript: lRS 0 temp0)
				)
			)
		)
	)
)

(instance lRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp1
					(/
						(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
						2
					)
				)
				(switch register
					((client north:)
						(gCurRoom newRoom: register)
					)
					((client south:)
						(= temp0
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						(if (IsObject (gEgo head:))
							(+=
								temp0
								(CelHigh
									((gEgo head:) view:)
									((gEgo head:) loop:)
									((gEgo head:) cel:)
								)
							)
						)
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ 189 temp0) self
						)
					)
					((client east:)
						(gEgo
							setMotion: PolyPath (+ 319 temp1) (gEgo y:) self
						)
					)
					((client west:)
						(gEgo
							setMotion: PolyPath (- 0 temp1) (gEgo y:) self
						)
					)
				)
			)
			(1
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom setScript: 0 newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(HandsOff)
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp1
					(/
						(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
						2
					)
				)
				(switch register
					((client north:)
						(localproc_0)
						(gEgo y: (+ (gCurRoom horizon:) (gEgo yStep:)))
						(= cycles 1)
					)
					((client south:)
						(localproc_0)
						(gEgo
							y: (+ 189 temp0)
							setMotion:
								PolyPath
								(gEgo x:)
								(- 189 (* (gEgo yStep:) 2))
								self
						)
					)
					((client east:)
						(localproc_1)
						(gEgo
							x: (+ 319 temp1)
							setMotion:
								PolyPath
								(- 319 (* (gEgo xStep:) 2))
								(gEgo y:)
								self
						)
					)
					((client west:)
						(localproc_1)
						(gEgo
							x: (- 0 temp1)
							setMotion:
								PolyPath
								(+ 0 (* (gEgo xStep:) 2))
								(gEgo y:)
								self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sWO of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setMotion: PolyPath (gCurRoom x:) (gCurRoom y:) self
				)
			)
			(1
				(gCurRoom posn: 0 0 newRoom: register)
			)
		)
	)
)

(instance sWI of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (gCurRoom x:) (gCurRoom y:) self)
			)
			(1
				(gCurRoom posn: 0 0)
				(if (not next)
					(HandsOn)
				)
				(gEgo ignoreActors: 0 setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance sRW of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= local0 (= temp0 (gEgo x:)))
				(= local1 (= temp1 (gEgo y:)))
				(= temp3
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(if (IsObject (gEgo head:))
					(+=
						temp2
						(CelHigh
							((gEgo head:) view:)
							((gEgo head:) loop:)
							((gEgo head:) cel:)
						)
					)
				)
				(switch register
					(1
						(+= local1 5)
					)
					(2
						(+= temp0 temp3)
						(-= local0 5)
					)
					(3
						(+= temp1 temp2)
						(-= local1 5)
					)
					(4
						(-= temp0 temp3)
						(+= local0 5)
					)
				)
				(gEgo ignoreActors: 1 setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(3
				(gEgo ignoreActors: 0)
				(Prints
					{Unless dispatch has someplace for you to go, you better stick around and do sergeant stuff.}
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sonny of Talker
	(properties
		x 15
		y 15
		view 1013
		cel 1
		talkWidth 145
		font 4
		color 1
		back 5
	)

	(method (init)
		(switch global206
			(2
				(self view: 1015)
				(sonnyMouth view: 1015 nsLeft: 36 nsTop: 42)
			)
			(177
				(self view: 1014)
				(sonnyMouth view: 1014 nsLeft: 36 nsTop: 42)
			)
			(1
				(self view: 1014)
				(sonnyMouth view: 1014 nsLeft: 36 nsTop: 42)
			)
			(else
				(self view: 1013)
				(sonnyMouth view: 1013 nsLeft: 36 nsTop: 42)
			)
		)
		(super init: 0 0 sonnyMouth &rest)
	)
)

(instance sonnyMouth of Prop
	(properties
		nsTop 42
		nsLeft 36
		view 1013
		loop 1
	)
)

