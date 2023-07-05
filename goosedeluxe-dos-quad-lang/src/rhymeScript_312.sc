;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use ROsc)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 7] = [148 100 155 100 152 100 32768]
	local7
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local7 0)
				(Load rsVIEW 77)
				(Load rsSCRIPT 64983)
				(proc0_9)
				(= cycles 1)
			)
			(1
				(gLongSong stop:)
				(= ticks 30)
			)
			(2
				(gMessager say: 1 0 0 8 0 400) ; "PETER PUMPKIN EATER"
				(rhymeSync init: 400 1 0 0 8)
				(if (!= gLanguage 2)
					(global152 setCycle: ROsc 200 0 cycleSpeed: 4)
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0
									format: {Peter, Peter el come calabazas.}
								)
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0
									format: {Pierre, Pierre Pierre citrouille}
								)
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format: {Laurentia, liebe Laurentia mein,}
								)
							)
						)
						(else
							(proc0_16
								(temp0 format: {Peter, Peter, pumpkin eater,})
							)
						)
					)
					(self setScript: getWife)
					(global152 setCycle: Beg)
				)
				(= cycles 1)
			)
			(4
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format:
									{Ten^a una esposa y no la pod^a retener,}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16 (temp0 format: {avait perdu sa belle dame}))
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{wann werden wir wieder beisammen sein?\nAm Montag.}
							)
						)
					)
					(else
						(proc0_16
							(temp0 format: {Had a wife and could not keep her;})
						)
					)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format: {la meti& en una c#scara de calabaza,}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {il l'a mise dans une citrouille})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{Ach wenn es doch erst wieder Montag w5r,}
							)
						)
					)
					(else
						(proc0_16
							(temp0 format: {He put her in a pumpkin shell,})
						)
					)
				)
				(= cycles 1)
			)
			(6
				(if (>= (rhymeSync prevSignal:) 40)
					(cond
						((== gLanguage 1)
							(proc0_16
								(temp0 format: {y all^ la mantuvo muy bien.})
							)
						)
						((== gLanguage 2)
							(proc0_16
								(temp0 format: {ainsi garda-t-il sa femme.})
							)
						)
						((== gLanguage 3)
							(proc0_16
								(temp0
									format:
										{und ich bei meiner Laurentia w5r,\nLaurentia w5r.}
								)
							)
						)
						(else
							(proc0_16
								(temp0
									format: {And there he kept her very well.}
								)
							)
						)
					)
					(= ticks 180)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(7
				(global109 setLoop: 11 1)
				(global152
					init: global109 (- (CelHigh 77 11 0) 8)
					cel: 0
					cycleSpeed: 3
				)
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global152 setCycle: Fwd)
					(= ticks 75)
				else
					(= ticks 1)
				)
			)
			(8
				(if (and (!= gLanguage 2) (!= gLanguage 3))
					(global152 setCycle: Beg self)
				else
					(self cue: self)
				)
			)
			(9
				(if script
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(global109 loop: 8 cel: 5)
					(global152 cel: 0 dispose:)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(11
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(DisposeScript 64983)
				(= local7 1)
			)
		)
		(temp0 dispose:)
		(if local7
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance getWife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 168 147 self)
			)
			(1
				(proc0_7 gEgo global109)
				(global152 dispose:)
				(global109
					setLoop: 5 1
					setCycle: Walk
					setMotion: MoveTo 157 124 self
				)
				(global111
					view: (global129 view:)
					loop: (global129 loop:)
					cel: (global129 cel:)
					x: (global129 x:)
					y: (global129 y:)
					init:
					moveSpeed: 6
					ignoreActors: 1
					setMotion: MoveTo 145 124 self
				)
				(global129 dispose:)
			)
			(2
				(global111 hide:)
				(global109 setLoop: 6 1 cel: 0 setCycle: End self)
			)
			(3
				(= register (kiss new:))
				(kiss init:)
				(= ticks 18)
			)
			(4
				(register init:)
				(= seconds 4)
			)
			(5
				(kiss dispose:)
				(register dispose:)
				(global109 setCycle: Beg self)
			)
			(6
				(global110 setPri: 48 setCycle: End self)
			)
			(7
				(global109
					setLoop: 5 1
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 5
					setMotion: MoveTo 107 114
				)
				(global111
					show:
					setPri: 49
					illegalBits: 0
					moveSpeed: 5
					setMotion: MoveTo 147 109 self
				)
			)
			(8
				(global111 moveSpeed: 7 setMotion: MoveTo 146 109 self)
			)
			(9
				(global110 setPri: 50 setCycle: Beg self)
			)
			(10
				(global111
					setPri: 51
					view: 77
					posn: 149 86 0
					setLoop: 10 1
					cel: 0
				)
				(= cycles 2)
			)
			(11
				(global109 posn: 107 114 setLoop: 8 1 cel: 0 setCycle: End self)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance kiss of Prop
	(properties
		priority 15
		view 77
		loop 9
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(self cue:)
	)

	(method (cue)
		(= cel 5)
		(self
			setPri: 15
			posn: (+ 140 (Random 1 30)) (+ 60 (Random 1 20))
			setCycle: Beg self
		)
	)
)

(instance goIn of Path ; UNUSED
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

