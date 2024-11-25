;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	sitScript 0
)

(instance sitScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 170)
	)

	(method (doit)
		(super doit:)
		(cond
			((> global342 1)
				(-- global342)
			)
			((== global342 1)
				(= global342 0)
				(if (not ((ScriptID 301 2) script:)) ; shema
					((ScriptID 301 2) setScript: (ScriptID 168 0)) ; shema, comingOut
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (or (Said 'stand') (Said 'get<up'))
					(cond
						(
							(and
								(IsFlag 301)
								(< ((ScriptID 301 2) distanceTo: gEgo) 30) ; shema
							)
							(HighPrint 170 0) ; "Not until you're through with Shema."
						)
						((or (== global340 1) (== global341 1))
							(HighPrint 170 1) ; "You should wait for Shema to bring you what you ordered."
						)
						((== global340 2)
							(HighPrint 170 2) ; "Eat your meal first."
						)
						((== global341 2)
							(HighPrint 170 3) ; "Finish your drink."
						)
						(else
							(self changeState: 8)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 302)
					(ClearFlag 302)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				((ScriptID 301 8) ignoreActors:) ; chair
				(if (< (gEgo x:) 158)
					(gEgo
						illegalBits: 0
						setMotion: MoveTo 145 (gEgo y:) self
					)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo (gEgo x:) 157)
					(= cycles 5)
				)
			)
			(2
				(if (> (gEgo x:) 145)
					(gEgo setMotion: MoveTo 145 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 154)
				(= cycles 2)
			)
			(4
				((ScriptID 301 8) posn: 156 154) ; chair
				(= cycles 3)
			)
			(5
				(gEgo ignoreActors: stopUpd: hide:)
				((ScriptID 301 8) ; chair
					setLoop: 6
					setCel: 0
					setPri: 12
					posn: 141 154
					ignoreActors: 0
				)
				(= cycles 2)
			)
			(6
				((ScriptID 301 8) setCycle: End) ; chair
				(SetFlag 254)
				(= cycles 15)
			)
			(7
				(cond
					((not (gCast contains: (ScriptID 301 2))) ; shema
						((ScriptID 301 2) init:) ; shema
						(gCast delete: (ScriptID 301 2)) ; shema
						(gCast addToFront: (ScriptID 301 2)) ; shema
					)
					((and (not (IsFlag 301)) (not ((ScriptID 301 2) script:))) ; shema
						((ScriptID 301 2) setScript: (ScriptID 168 0)) ; shema, comingOut
					)
				)
			)
			(8
				(User canInput: 0)
				((ScriptID 301 8) setCycle: Beg self) ; chair
			)
			(9
				((ScriptID 301 8) ; chair
					setLoop: 5
					setCel: 4
					setPri: 6
					posn: 141 154
					stopUpd:
				)
				(gEgo loop: 1 show:)
				(= cycles 3)
			)
			(10
				(gEgo setMotion: MoveTo (gEgo x:) 160 self)
			)
			(11
				((ScriptID 301 8) setPri: -1) ; chair
				(ClearFlag 254)
				(= global340 0)
				(= global341 0)
				(HandsOn)
				(gEgo illegalBits: $8000 ignoreActors: 0 setScript: 0)
			)
		)
	)
)

