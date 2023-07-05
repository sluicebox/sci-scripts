;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 181)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	tossIt 1
	theNet 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance tossIt of Script
	(properties)

	(method (init param1 param2 param3)
		(switch global125
			(1
				(= local4 140)
			)
			(2
				(= local4 65)
			)
			(3
				(= local4 30)
			)
			(4
				(= local4 20)
			)
		)
		(= global104 (= local0 param2))
		(= global105 (= local1 param3))
		(super init: param1 0 0)
	)

	(method (doit)
		(if
			(and
				(IsFlag 104)
				(< ((ScriptID 185 0) distanceTo: theNet) local4) ; sprite
				(IsFlag 37)
				(or
					(and
						(== ((ScriptID 185 0) loop:) 0) ; sprite
						(< ((ScriptID 185 0) x:) (theNet x:)) ; sprite
					)
					(and
						(== ((ScriptID 185 0) loop:) 1) ; sprite
						(> ((ScriptID 185 0) x:) (theNet x:)) ; sprite
					)
				)
			)
			(ClearFlag 104)
			(SetFlag 42)
			((ScriptID 220 0) setScript: (ScriptID 185 2)) ; forest, spriteCaught
			(gEgo put: 4) ; net
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global143)
					(HandsOff)
				)
				(gEgo setMotion: 0)
				(cond
					(
						(or
							(<=
								(= local5
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										local0
										local1
									)
								)
								20
							)
							(> local5 340)
							(<= local5 60)
						)
						(gEgo setLoop: 3)
						(= local2 (+ (gEgo x:) 11))
						(= local3 (- (gEgo y:) 55))
					)
					((or (<= local5 100) (<= local5 160))
						(gEgo setLoop: 0)
						(= local2 (+ (gEgo x:) 54))
						(= local3 (- (gEgo y:) 51))
					)
					((or (<= local5 200) (<= local5 240))
						(gEgo setLoop: 2)
						(= local2 (- (gEgo x:) 24))
						(= local3 (- (gEgo y:) 47))
					)
					((or (<= local5 290) (<= local5 340))
						(gEgo setLoop: 1)
						(= local2 (- (gEgo x:) 48))
						(= local3 (- (gEgo y:) 51))
					)
				)
				(gEgo view: 181 setCel: 0 setCycle: CT 6 1 self)
			)
			(1
				(gEgo setCel: 7)
				(theNet
					posn: local2 local3
					init:
					setCycle: End
					setMotion: MoveTo local0 (- local1 20) self
				)
			)
			(2
				(NormalEgo)
				(SetFlag 104)
				(SetFlag 218)
				(theNet setCel: 0)
				(switch global125
					(1
						(= seconds 3)
					)
					(2
						(= seconds 2)
					)
					(3
						(= seconds 1)
					)
					(4
						(= ticks 30)
					)
				)
			)
			(3
				(ClearFlag 104)
				(= ticks 12)
			)
			(4
				(gTheIconBar disable: 0)
				(if (IsFlag 37)
					0
				else
					(= ticks 12)
				)
			)
			(5
				(gEgo setScript: getNet)
			)
		)
	)
)

(instance getNet of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(theNet dispose:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gTheIconBar enable: 0)
				(if (< (gEgo x:) (theNet x:))
					(gEgo
						setMotion:
							PolyPath
							(- (theNet x:) 12)
							(+ (theNet y:) 16)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (theNet x:) 8)
							(+ (theNet y:) 16)
							self
					)
				)
			)
			(1
				(gEgo
					view: 7
					setCel: 0
					setLoop: (if (< (gEgo x:) (theNet x:)) 1 else 0)
					setCycle: CT 4 1 self
				)
			)
			(2
				(theNet hide:)
				(ClearFlag 218)
				(gEgo setCycle: End self)
			)
			(3
				(if (> (gEgo y:) 188)
					(NormalEgo)
					(gEgo setMotion: PolyPath (gEgo x:) 180 self)
				else
					(self cue:)
				)
			)
			(4
				(if (not (gEgo loop:))
					(gEgo loop: 6)
				else
					(gEgo loop: 7)
				)
				(gEgo get: 4) ; net
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theNet of Actor
	(properties
		z -10
		yStep 21
		view 181
		loop 4
		signal 26624
		xStep 30
	)

	(method (dispose)
		(super dispose:)
		(self delete:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: getNet)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

