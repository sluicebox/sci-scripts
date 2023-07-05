;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 366)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n396)
(use Submarine_806)
(use n821)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	fCPanel 0
	missleSelector 1
)

(local
	local0
	local1
)

(instance missleSelector of View
	(properties
		y 90
		x 152
		view 427
		loop 2
		priority 14
		signal 273
	)

	(method (delete)
		(gIceKeyDownHandler delete: fCPanel)
		(super delete:)
		(DisposeScript 366)
	)
)

(instance fCPanel of Prop
	(properties
		y 4
		x 156
		view 27
		loop 3
		priority 12
		signal 16
	)

	(method (setCycle param1)
		(if (and argc param1 (param1 isKindOf: Beg))
			(missleSelector hide:)
		)
		(super setCycle: param1 &rest)
	)

	(method (cue)
		(if cel
			(if (!= ((ScriptID 27 1) cel:) 4) ; tV
				((ScriptID 27 1) setCel: 4 setPri: 15) ; tV
			)
			(missleSelector show:)
			(if (== ((subMarine script:) state:) 5)
				(Print 366 0) ; "You were not ordered to take offensive action Commander!"
			)
		)
	)

	(method (doit)
		(if local0
			(-- local0)
		)
		(super doit:)
	)

	(procedure (localproc_0)
		(missleSelector cel: (mod (+ (missleSelector cel:) 1) 3) forceUpd:)
		(= local1 0)
	)

	(procedure (localproc_1)
		(if
			(switch (missleSelector cel:)
				(0
					(Submarine misslesLeft:)
				)
				(1
					(Submarine decoysLeft:)
				)
				(2
					(Submarine torpedosLeft:)
				)
			)
			(= local1 1)
			(if (OneOf ((subMarine script:) state:) 13 9 5)
				(proc396_0 4 366 1) ; "LOCKED ON TARGET"
			else
				(Print 366 2) ; "No Valid Target."
			)
		else
			(proc396_0 4 366 3) ; "EMPTY"
		)
	)

	(procedure (localproc_2)
		(if (!= ((ScriptID 27 1) priority:) 15) ; tV
			((ScriptID 27 1) setPri: 15) ; tV
		else
			((ScriptID 27 1) setPri: 13) ; tV
		)
	)

	(procedure (localproc_3 param1)
		(cond
			((and (& (Submarine flags:) $0100) (not local0))
				(switch (missleSelector cel:)
					(0
						(if (Submarine misslesLeft:)
							(Submarine
								misslesLeft: (- (Submarine misslesLeft:) 1)
							)
						else
							(Print 366 4) ; "You have no harpoon missles left."
							(return)
						)
					)
					(1
						(if (Submarine decoysLeft:)
							(Submarine
								decoysLeft: (- (Submarine decoysLeft:) 1)
							)
						else
							(Print 366 5) ; "You have no decoys left."
							(return)
						)
					)
					(2
						(if (Submarine torpedosLeft:)
							(Submarine
								torpedosLeft: (- (Submarine torpedosLeft:) 1)
							)
						else
							(Print 366 6) ; "You have no sting ray torpedos left."
							(return)
						)
					)
				)
				(= local0 20)
				(gCurRoom
					handleEvent:
						(param1
							type: 1024
							message: (missleSelector cel:)
							modifiers: local1
							yourself:
						)
				)
				(= local1 0)
			)
			((not (OneOf ((subMarine script:) state:) 13 9 5))
				(Print 366 2) ; "No Valid Target."
			)
			((== ((subMarine script:) state:) 5)
				(EgoDead 7 0 0 366 7) ; "Having caused an international incident, you must restart or restore."
			)
			((not (& (Submarine flags:) $0100))
				(Print 366 8) ; "The torpedo room reports a malfunction."
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					($5800
						(localproc_0)
						(event claimed: 1)
					)
					($5900
						(localproc_1)
						(event claimed: 1)
					)
					($5a00
						(localproc_2)
						(event claimed: 1)
					)
					($5b00
						(localproc_3 event)
						(event claimed: 1)
					)
				)
			)
			((MousedOn self event)
				(cond
					((<= 143 (= temp0 (event x:)) 147)
						(localproc_0)
					)
					((<= 150 temp0 154)
						(localproc_1)
					)
					((<= 157 temp0 161)
						(localproc_2)
					)
					((<= 164 temp0 168)
						(localproc_3 event)
					)
				)
			)
		)
	)
)

(instance torpSnd of Sound ; UNUSED
	(properties
		number 48
		priority 3
	)
)

